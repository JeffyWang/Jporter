package com.jeffy.jporter;

import net.sf.json.JSONObject;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public class PropertyContext {
    private PropertyOperation operation;

    public PropertyContext(PropertyOperation operation) {
        this.operation = operation;
    }

    public PropertyOperation getOperation() {
        return operation;
    }

    public void setOperation(PropertyOperation operation) {
        this.operation = operation;
    }

    public Object operation(JSONObject json, String sourceJson) {
        PropertyType propertyType = PropertyType.value(operation.getOperationType());

        if(json.get(Property.VALUE.getProperty()) != null)
            return json.get(Property.VALUE.getProperty());

        switch (propertyType) {
            case OBJECT:
                return operation.getObjectProperties(json, sourceJson);
            case OBJECT_ARRAY:
                return operation.getObjectArrayProperties(json, sourceJson);
            case STRING_ARRAY:
                return operation.getStringArrayProperties(json, sourceJson);
            case NUMBER_ARRAY:
                return operation.getNumberArrayProperties(json, sourceJson);
            case BOOLEAN_ARRAY:
                return operation.getBooleanArrayProperties(json, sourceJson);
            case STRING:
                return operation.getString(json, sourceJson);
            case NUMBER:
                return operation.getNumber(json, sourceJson);
            case BOOLEAN:
                return operation.getBoolean(json, sourceJson);
            default:
                return "type is error";
        }
    }
}
