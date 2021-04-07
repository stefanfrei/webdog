// Copyright (c) 2021 Stefan Frei <stefan.a.frei@gmail.com>
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package org.schlibbuz.webdog.services;

public class ConciergeService {
    

    public String getWelcome() {
        return new StringBuilder("Welcome to ")
                .append(System.getProperty("webdog.artifact"))
                .append(" ")
                .append(System.getProperty("webdog.version"))
                .toString();
    }
}
