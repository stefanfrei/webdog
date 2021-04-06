package org.schlibbuz.webdog.tools;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;

public class ArgsSanitizer {

    private static final Logger w = LogManager.getLogger(ArgsSanitizer.class);

    private final String[] args;
    
    public ArgsSanitizer(final String[] args) {
        this.args = args;
    }

    public File getWebRoot() throws IOException {
        String webRootFolder = "testdata";
        if (args.length > 0) {
            webRootFolder = args[0];
        }
        File webRoot = new File(webRootFolder);
        if (webRoot.isDirectory()) {
            return webRoot;
        }
        String errorMessage = "Directory not found -> " + webRoot.getAbsolutePath();
        w.error(errorMessage);
        throw new IOException(errorMessage);
    }
}
