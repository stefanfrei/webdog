// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIExperienceTest {
    
    private UIExperience inst;

    @BeforeMethod
    public void pre() {
        inst = new UIExperience();
    }

    @AfterMethod
    public void post() {
        inst = null;
    }

    @Test
    public void printWelcome() {
        //Assert pass, is just a wrapper
        inst.printWelcome();
        assertTrue(true);
    }

    @Test
    public void printActualWeather() {
        //Assert pass, is just a wrapper
        inst.printActualWeather();
        assertTrue(true);
    }
}
