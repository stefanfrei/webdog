package org.schlibbuz.webdog.selenium;

//     ChromeDriver, ChromiumDriver, EdgeDriver, EventFiringWebDriver, FirefoxDriver, InternetExplorerDriver, OperaDriver, RemoteWebDriver, SafariDriver
public enum WebDriverType {
    // types
    CHROME("chrome"),
    CHROMIUM("chromium"),
    EDGE("edge"),
    EVENT_FIRING_WEB("eventfiringweb"),
    FIREFOX("gecko"),
    INTERNET_EXPLORER("internetexplorer"),
    OPERA("opera"),
    REMOTE_WEB("remoteweb"),
    SAFARI("safari");
    // end


    private final String name;


    WebDriverType(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }


    public static WebDriverType fromName(String name) {
        for(WebDriverType t : values()) {
            if(t.name.equals(name)) return t;
        }
        return null;
    }
}
