// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
//
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UIExperience {

    private static final Logger w = LogManager.getLogger(UIExperience.class);

    public void sayWelcome() {
        String version = UIExperience.class.getPackage().getImplementationVersion();
        if (version == null) version = PropsLoader.getVersion();
        w.info("Welcome to webdog {}", version);
    }

    public void reportWeather() {
        w.info("The weather near Zurich is partly cloudy and enjoyable 15 degrees celsius");
    }
    
}
