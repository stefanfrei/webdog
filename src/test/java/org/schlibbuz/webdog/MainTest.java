package org.schlibbuz.webdog;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    
    private static final Logger w = LogManager.getLogger(MainTest.class);
    private WebDriver d;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver","C:/Program Files/Mozilla Geckodriver/geckodriver.exe");
        d = new FirefoxDriver();
    }

    @AfterTest
    public void teardown() {
        d.quit();
    }

    @Test
    public void testTitle() {
        w.trace("running test");
        d.manage().window().maximize();
        d.manage().deleteAllCookies();
        d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        d.get("http://localhost:3000/");
        String expected = "org.schlibbuz ‒ Home";
        w.trace(expected);
        assertEquals(d.getTitle(), expected);
    }
}
