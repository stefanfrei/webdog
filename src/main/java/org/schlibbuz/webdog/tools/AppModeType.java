// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

public enum AppModeType {
    RUN("run"),
    TRACE("trace"),
    DEBUG("debug");
    // end


    private final String name;


    AppModeType(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }


    public static AppModeType fromName(String name) {
        for(AppModeType t : values()) {
            if(t.name.equals(name)) return t;
        }
        return null;
    }
}
