/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schlibbuz.webdog;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.schlibbuz.webdog.tools.ArgsScanner;
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
    public static void main(String[] args) throws IOException, InterruptedException {
        PropsLoader.addSysProps();
        var ux = new UIExperience();
        ux.sayWelcome();
        ux.printWeatherReport();
        var as = new ArgsScanner(args);
    }

}
