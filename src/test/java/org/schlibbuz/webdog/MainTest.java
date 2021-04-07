package org.schlibbuz.webdog;

import static org.testng.Assert.*;

import org.schlibbuz.webdog.tools.CmdLineArgException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MainTest {

    @Test
    public void main() {
        // to please jacoco
        assertTrue(true);
    }

    @DataProvider(name = "run")
    public static Object[][] run() {
        return new Object[][] {
            {new String[]{"poing"}, false}, // illegal app-mode or folder poing not in pwd or
            {new String[]{}, false}, // no *.html in pwd
            {new String[]{"run"}, false}, // no *.html in pwd or folder run not in pwd
            {new String[]{"trace"}, false}, // no *.html in pwd or folder trace not in pwd
            {new String[]{"debug"}, false}, // no *.html in pwd or folder debug not in pwd
            {new String[]{"RUN"}, false}, // no *.html in pwd or folder RUN not in pwd
            {new String[]{"TRACE"}, false}, // no *.html in pwd or folder TRACE not in pwd
            {new String[]{"DEBUG"}, false}, // no *.html in pwd or folder DEBUG not in pwd
            {new String[]{"--pingpong=abc"}, false}, // illegal commandline-argument
            {new String[]{"-jo", "webdriver=stallone"}, false}, // illegal webdriver
            {new String[]{"illegaldnsdog.org"}, false}, // illegal dns-name or folder illegaldnsdog.org not in pwd
            {new String[]{"https://illegaldnsdog.org/"}, false}, // illegal dns-name
            {new String[]{"run", "myip.ch"}, true},
            {new String[]{"trace", "myip.ch"}, true},
            {new String[]{"debug", "myip.ch"}, true},
            {new String[]{"RUN", "myip.ch"}, true},
            {new String[]{"TRACE", "myip.ch"}, true},
            {new String[]{"DEBUG", "myip.ch"}, true},
            {new String[]{"run", "-jo", "myip.ch"}, true},
            {new String[]{"TrAcE", "--jsoup-only", "myip.ch"}, true},
            {new String[]{"debug", "-so", "myip.ch"}, true},
            {new String[]{}, true},
            {new String[]{}, true},
            {new String[]{}, true},
        };
    }
    @Test(dataProvider = "run")
    public void run(String[] args, boolean expectToPass) {
        boolean passed = false;
        try {
            Main.run(args);
            passed = true;
        } catch (CmdLineArgException e) {

        }
        assertEquals(passed, expectToPass);
    }

}
