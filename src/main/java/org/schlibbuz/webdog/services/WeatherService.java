// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.services;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WeatherService {
    
    private static final Logger w = LogManager.getLogger(WeatherService.class);

    public String getActualWeather() {
        w.trace("getting actual weather");
        return "The weather near Zurich is partly cloudy and enjoyable 15 degrees celsius";
    }
}
