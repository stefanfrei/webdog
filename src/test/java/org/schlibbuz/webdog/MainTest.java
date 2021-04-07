package org.schlibbuz.webdog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    
    private static final Logger w = LogManager.getLogger(MainTest.class);

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void teardown() {
    }

    @Test
    public void main() {
        w.trace("testing main");
        assertTrue(true);
    }

}
