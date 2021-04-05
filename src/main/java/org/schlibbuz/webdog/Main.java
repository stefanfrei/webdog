/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schlibbuz.webdog;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Stefan Frei <stefan.a.frei@gmail.com>
 */
public class Main {

    private static final Logger w = LogManager.getLogger(Main.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:/Program Files/Mozilla Geckodriver/geckodriver.exe");
        WebDriver d = new FirefoxDriver();
        d.manage().window().maximize();
        d.manage().deleteAllCookies();
        d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        d.get("http://localhost:3000/");
        w.trace(d.getPageSource());
        d.quit();
    }

}
