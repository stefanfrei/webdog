/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schlibbuz.webdog;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.schlibbuz.webdog.tools.ArgsScanner;
import org.schlibbuz.webdog.tools.CmdLineArgException;
import org.schlibbuz.webdog.tools.Env;
import org.schlibbuz.webdog.tools.PropsLoader;
import org.schlibbuz.webdog.tools.UIExperience;

/**
 *
 * @author Stefan Frei <stefan.a.frei@gmail.com>
 */
public class Main {

    private static final Logger w = LogManager.getLogger(Main.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CmdLineArgException {
        Main.run(args);
    }

    static void run(String[] args) throws CmdLineArgException {
        w.trace("webdog starting ...");
        PropsLoader.addSysProps();
        var env = new Env();
        new ArgsScanner(env, args);

        var ux = new UIExperience();
        ux.printWelcome();
        ux.printActualWeather();
    }
}
