// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
//
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PropsLoader {

    private static final Logger w = LogManager.getLogger(PropsLoader.class);

    private PropsLoader() {}
    
    public static Properties loadProps() {
        try (InputStream input = PropsLoader.class.getClassLoader().getResourceAsStream("app.props")) {
            Properties props = new Properties();
            props.load(input);
            return props;

        } catch (IOException e) {
            w.error(e.getMessage());
        }

        return null;
    }

    public static String getVersion() {
        try (InputStream input = PropsLoader.class.getClassLoader().getResourceAsStream("app.props")) {
            Properties props = new Properties();
            props.load(input);
            return props.getProperty("version");

        } catch (IOException e) {
            w.error(e.getMessage());
        }

        return null;
    }
}
