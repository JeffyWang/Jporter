package com.jeffy.jporter;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public enum PropertyType {
    OBJECT("object"), ARRAY("array"), STRING("string"), NUMBER("number"), BOOLEAN("boolean");

    private String type;

    private PropertyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
