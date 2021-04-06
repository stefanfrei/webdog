package org.schlibbuz.webdog.tools;


import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PropsLoaderTest {
    
    private static final Logger w = LogManager.getLogger(PropsLoaderTest.class);

    public PropsLoaderTest() {
    }

    @BeforeTest
    public void setup() {
        PropsLoader.addSysProps();
    }

    @Test
    public void getSysProps() {
        w.trace("Testing System Properties");
        assertEquals(System.getProperty("webdog.artifact"), "webdog");
        assertEquals(System.getProperty("webdog.version"), "1.1-SNAPSHOT");
    }

}
