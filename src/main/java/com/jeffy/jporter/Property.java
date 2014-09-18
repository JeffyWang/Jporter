package com.jeffy.jporter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public enum Property {
    VALUE("value"), TYPE("type"), PATH("path"), PROPERTIES("properties");

    private String property;

    private Property(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
