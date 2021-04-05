package org.schlibbuz.webdog.tools;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UIExperience {

    private static final Logger w = LogManager.getLogger(UIExperience.class);

    public void sayWelcome() {
        w.info("Welcome to webdog %s", UIExperience.class.getPackage().getImplementationVersion());
    }

    public void reportWeather() {
        w.info("The weather near Zurich is partly cloudy and enjoyable 15 degrees celsius");
    }
    
}
