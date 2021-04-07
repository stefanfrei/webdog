package org.schlibbuz.webdog.tools;


import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ArgsScannerTest {

    private static final Logger w = LogManager.getLogger(ArgsScannerTest.class);

    private ArgsScanner inst;

    public ArgsScannerTest() {
    }

    @BeforeTest
    public void preTest() {
    }

    @BeforeMethod
    public void preMeth() throws CmdLineArgException {
        inst = new ArgsScanner(null, new String[]{});
    }

    @AfterMethod
    public void postMeth() {
        inst = null;
    }

    @DataProvider(name = "parseArgs")
    public static Object[][] parseArgs() {
        return new Object[][] {
            { new String[]{"run"}, "run"},
            { new String[]{"run", "-wd=gecko"}, "run -wd=gecko"},
            { new String[]{"run", "--webdriver=chrome"}, "run -wd=chrome"}
        };
    }
    @Test(dataProvider = "parseArgs")
    public void parseArgs(String[] args, String expected) {
        w.trace("Testing args {}", args.toString());
    }

    @DataProvider(name = "isOption")
    public static Object[][] isOption() {
        return new Object[][] {
            {"", false},
            {" ", false},
            {"- ", true},
            {"-jo", true},
            {"--jsoup-only", true},
            {"---hasta-la-vista-baby", true},
            {"jojo", false},
        };
    }
    @Test(dataProvider = "isOption")
    public void isOption(String option, boolean expected) {
        assertEquals(inst.isOption(option), expected);
    }

    @DataProvider(name = "isOptionLong")
    public static Object[][] isOptionLong() {
        return new Object[][] {
            {"", false},
            {" ", false},
            {"- ", false},
            {"--", true},
            {"-jo", false},
            {"--jsoup-only", true},
            {"--selenium-only", true},
            {"---hasta-la-vista-baby", true},
            {"jojo", false},
        };
    }
    @Test(dataProvider = "isOptionLong")
    public void isOptionLong(String option, boolean expected) {
        assertEquals(inst.isOptionLong(option), expected);
    }

    @DataProvider(name = "isOptionValid")
    public static Object[][] isOptionValid() {
        return new Object[][] {
            {"", false},
            {" ", false},
            {"- ", false},
            {"-jo", true},
            {"-xo", false},
            {"--jsoup-only", true},
            {"---hasta-la-vista-baby", false},
            {"jojo", false},
        };
    }
    @Test(dataProvider = "isOptionValid")
    public void isOptionValid(String option, boolean expected) {
        assertEquals(inst.isOptionValid(option), expected);
    }
}
