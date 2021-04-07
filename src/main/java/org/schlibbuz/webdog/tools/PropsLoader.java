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
    private static final String PROPS_FILE_DEFAULT = "app.props";
    private static final String PROPS_PREFIX = "webdog.";


    private PropsLoader() {
    }

    public static void addSysProps() {
        PropsLoader.addSysProps(PROPS_FILE_DEFAULT);
    }

    public static synchronized void addSysProps(final String propsFile) {
        try (InputStream input = PropsLoader.class.getClassLoader().getResourceAsStream(propsFile)) {
            var props = new Properties();
            props.load(input);
            props.forEach( (k, v) -> {
                final String key = PROPS_PREFIX + k;
                w.trace("setting sysprop {} = '{}'", key, v);
                System.setProperty(key, v.toString());
            });

        } catch (IOException e) {
            w.error(e.getMessage());
        }
    }

}
