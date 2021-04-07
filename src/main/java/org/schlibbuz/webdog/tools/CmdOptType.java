// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.tools;

public enum CmdOptType {
    JO("-jo"), // jsoup-only
    SO("-so"); // selenium-only
    // end


    private final String name;


    CmdOptType(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }


    public static CmdOptType fromName(String name) {
        for(CmdOptType t : values()) {
            if(t.name.equals(name)) return t;
        }
        return null;
    }
}
