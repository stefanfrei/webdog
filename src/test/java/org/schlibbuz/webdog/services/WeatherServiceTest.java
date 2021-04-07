// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.services;

import static org.testng.Assert.*;

import org.schlibbuz.webdog.tools.PropsLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WeatherServiceTest {

    private WeatherService inst;


    @BeforeTest
    public void preTest() {
        PropsLoader.addSysProps();
    }

    @BeforeMethod
    public void pre() {
        inst = new WeatherService();
    }

    @AfterMethod
    public void post() {
        inst = null;
    }

    @Test
    public void getActualWeather() {
        String expected = "The weather near Zurich is partly cloudy and enjoyable 15 degrees celsius";
        assertEquals(inst.getActualWeather(), expected);
    }
}
