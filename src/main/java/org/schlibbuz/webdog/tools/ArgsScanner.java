package org.schlibbuz.webdog.tools;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public class ArgsScanner {

    private static final Logger w = LogManager.getLogger(ArgsScanner.class);

    private final String[] args;
    private final Env env;
    private final Map<String, String> optsMap;
    
    public ArgsScanner(final Env env, final String[] args) throws CmdLineArgException {
        this.env = env;
        this.args = args;
        this.optsMap = buildOptsMap();
        if(args.length > 0) {
            setArgs();
        }
    }

    Map<String, String> buildOptsMap() {
        var m = new HashMap<String, String>();
        m.put("--jsoup-only", "-jo");
        m.put("-jo", "-jo");
        m.put("--selenium-only", "-so");
        m.put("-so", "-so");
        return m;
    }

    private void setArgs() throws CmdLineArgException {
        var argsList = new LinkedList<>(Arrays.asList(args));

        // check app-mode
        if (!isOption(argsList.peekFirst())) {
            String amtName = argsList.pollFirst();
            AppModeType amt = AppModeType.fromName(amtName.toLowerCase());
            if (amt == null) throw new CmdLineArgException("unknown mode -> " + amtName);
        }

        // options
        while (
                !argsList.isEmpty()
                &&
                isOption(
                        argsList.peekFirst()
                )
        ) {
            final String option = argsList.pollFirst();

            // clean out unknown options
            if ( !isOptionValid(option) ) {
                w.warn("unknown option ignored -> {}", option);
                while (!isOption(argsList.peekFirst())) {
                    String attr = argsList.pollFirst();
                    w.warn("unused option attribute ignored -> {}", attr);
                }
            }
            // clean out finished

            // map option to env
            final String optionShort = toOptionShort(option);

            if(optionShort.equals("-jo")) {
                env.setJsoupOn(true);
                env.setSeleniumOn(false);
            } else if (optionShort.equals("-so")) {
                env.setSeleniumOn(true);
                env.setJsoupOn(false);
            }

        }
        // options end

        // check webroot
        if (!isOption(argsList.getLast())) {
            env.setWebRoot(
                findWebRoot(argsList.pollLast())
            );
        }
    }

    String findWebRoot(final String webRoot) throws CmdLineArgException {
        final String webRootLower = webRoot.toLowerCase();

        if (webRootLower.startsWith("http://") || webRootLower.startsWith("https://")) return webRoot;

        File webRootFile = new File(webRoot);
        if (webRootFile.exists() && webRootFile.isDirectory()) return webRoot; //is local folder

        String potUrl = "http://" + webRootLower;

        try {
            new URL(potUrl);
            return potUrl;
        } catch (MalformedURLException e) {
            throw new CmdLineArgException(e.getMessage());
        }
    }

    boolean isOption(final String option) {
        return  option.length() >= 1
                &&
                option.startsWith("-");
    }

    boolean isOptionLong(final String option) {
        return  option.length() >= 2
                &&
                option.startsWith("--");
    }

    boolean isOptionValid(final String option) {
        return optsMap.containsKey(option);
    }

    String toOptionShort(final String optionLong) {
        return optsMap.get(optionLong);
    }

}
