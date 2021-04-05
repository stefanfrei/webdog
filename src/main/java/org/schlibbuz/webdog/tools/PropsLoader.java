package org.schlibbuz.webdog.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsLoader {

    private PropsLoader() {}
    
    public static Properties loadProps() {
        try (InputStream input = PropsLoader.class.getClassLoader().getResourceAsStream("app.props")) {
            Properties props = new Properties();
            props.load(input);
            return props;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
