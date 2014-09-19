package com.jeffy.jporter;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public enum PropertyType {
    OBJECT("object"), OBJECT_ARRAY("object_array"), STRING_ARRAY("string_array"), NUMBER_ARRAY("number_array"), BOOLEAN_ARRAY("boolean_array"), STRING("string"), NUMBER("number"), BOOLEAN("boolean");

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

    public static PropertyType value(String type) {
        for (PropertyType propertyType : PropertyType.values()) {
            if (propertyType.getType().equals(type)) {
                return propertyType;
            }
        }

        return null;
    }
}
