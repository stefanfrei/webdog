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
import org.schlibbuz.webdog.tools.ArgsSanitizer;
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
        var ux = new UIExperience();
        ux.sayWelcome();
        var as = new ArgsSanitizer(args);
        Properties props = PropsLoader.loadProps();

        System.setProperty("webdriver.gecko.driver", props.getProperty("geckodriver.path"));

        w.trace(props.getProperty("browsersync.path"));
        ProcessBuilder pb = new ProcessBuilder(
                props.getProperty("browsersync.path"),
                "start",
                "--server",
                "--port", "9000",
                "--files", "*.html", "css/*.css", "img/*", "js/*"
        ).inheritIO();

        pb.directory(as.getWebRoot());
        w.trace(pb.directory().getAbsolutePath());
        Process browserSync = pb.start();

        Thread closeBrowserSync = new Thread() {
            @Override
            public void run() {
                CompletableFuture<Process> handle = browserSync.onExit();
                browserSync.destroy();
                w.trace("waiting for process to end ...");
                try {
                    handle.get();
                    w.trace("ok");
                } catch(InterruptedException | ExecutionException e) {
                    w.error("omg harsh -> %s", e.getMessage());
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }   
                }
            }
        };

        Runtime.getRuntime().addShutdownHook(closeBrowserSync);
        browserSync.waitFor();
    }

    static String getBrowserSyncBinary() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) return "browser-sync.cmd";
        return "browser-sync";
    }

}
