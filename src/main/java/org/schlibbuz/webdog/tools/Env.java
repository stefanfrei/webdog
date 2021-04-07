// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
//
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

import org.schlibbuz.webdog.selenium.WebDriverType;

public class Env {

    private AppModeType amt;
    private boolean jsoupOn;
    private boolean seleniumOn;
    private String webRoot;
    private WebDriverType wdt;


    public Env() {
        // default settings
        amt = AppModeType.RUN;
        jsoupOn = true;
        seleniumOn = true;
        webRoot = System.getProperty("user.dir"); // present working directory
        wdt = WebDriverType.FIREFOX;
        // default settings end
    }

    public AppModeType getAmt() {
        return amt;
    }

    public void setAmt(AppModeType amt) {
        this.amt = amt;
    }

    public boolean isJsoupOn() {
        return jsoupOn;
    }

    public void setJsoupOn(boolean jsoupOn) {
        this.jsoupOn = jsoupOn;
    }

    public boolean isSeleniumOn() {
        return seleniumOn;
    }

    public void setSeleniumOn(boolean seleniumOn) {
        this.seleniumOn = seleniumOn;
    }

    public String getWebRoot() {
        return webRoot;
    }

    public void setWebRoot(String webRoot) {
        this.webRoot = webRoot;
    }

    public WebDriverType getWdt() {
        return wdt;
    }

    public void setWdt(WebDriverType wdt) {
        this.wdt = wdt;
    }

}
