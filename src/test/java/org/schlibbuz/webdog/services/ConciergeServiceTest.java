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

public class ConciergeServiceTest {

    private ConciergeService inst;


    @BeforeTest
    public void preTest() {
        PropsLoader.addSysProps();
    }

    @BeforeMethod
    public void preMeth() {
        inst = new ConciergeService();
    }

    @AfterMethod
    public void postMeth() {
        inst = null;
    }

    @Test
    public void getWelcome() {
        String expected = "Welcome to webdog 1.1-SNAPSHOT";
        assertEquals(inst.getWelcome(), expected);
    }
}
