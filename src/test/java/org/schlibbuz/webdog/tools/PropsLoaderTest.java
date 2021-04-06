package org.schlibbuz.webdog.tools;


import static org.testng.Assert.assertEquals;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.Set;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PropsLoaderTest {
    
    private static final Logger w = LogManager.getLogger(PropsLoaderTest.class);
    private static final String APP_PROPS_FILE = "src/main/resources/app.props";
    private static final String APP_SYSPROPS_PREFIX = "webdog.";

    @BeforeTest
    public void setup() {
        PropsLoader.addSysProps();
    }

    @DataProvider(name = "sysProps")
    public static Object[][] sysProps() {

        try(InputStream input = new FileInputStream(APP_PROPS_FILE)) {

            Properties props = new Properties();
            props.load(input);
            Set<String> propsNames = props.stringPropertyNames();
            Object[][] data = new Object[propsNames.size()][2];
            int i = 0;
            for (String propsName : propsNames) {
                data[i][0] = APP_SYSPROPS_PREFIX + propsName;
                data[i++][1] = props.getProperty(propsName);
            }
            return data;
        } catch(IOException e) {
            throw new RuntimeException(); // no reason to proceed without app.props
        }
    }

    @Test(dataProvider= "sysProps")
    public void getSysProps(String sysPropName, String sysPropValue) {
        w.trace("Testing System Property {}", sysPropName);
        assertEquals(System.getProperty(sysPropName), sysPropValue);
    }

}
