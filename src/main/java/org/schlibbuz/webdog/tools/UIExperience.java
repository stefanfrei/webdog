// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
//
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

import org.apache.logging.log4j.Logger;
import org.schlibbuz.webdog.services.ConciergeService;
import org.schlibbuz.webdog.services.WeatherService;
import org.apache.logging.log4j.LogManager;

public class UIExperience {

    private static final Logger w = LogManager.getLogger(UIExperience.class);
    private final ConciergeService conciergeService;
    private final WeatherService weatherService;

    public UIExperience() {
        conciergeService = new ConciergeService();
        weatherService = new WeatherService();
    }

    public void sayWelcome() {
        w.info(conciergeService.getWelcome());
    }

    public void printWeatherReport() {
        w.info(weatherService.getActualWeather());
    }

}
