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
        if (operation.getOperationType().equals(PropertyType.OBJECT.getType()))
            return operation.getObjectProperties(json, sourceJson);
        else if (operation.getOperationType().equals(PropertyType.OBJECT_ARRAY.getType()))
            return operation.getObjectArrayProperties(json, sourceJson);
        else if (operation.getOperationType().equals(PropertyType.STRING_ARRAY.getType()))
            return operation.getStringArrayProperties(json, sourceJson);
        else if (operation.getOperationType().equals(PropertyType.NUMBER_ARRAY.getType()))
            return operation.getNumberArrayProperties(json, sourceJson);
        else if (operation.getOperationType().equals(PropertyType.BOOLEAN_ARRAY.getType()))
            return operation.getBooleanArrayProperties(json, sourceJson);
        else if(operation.getOperationType().equals(PropertyType.STRING.getType()))
            return operation.getString(json, sourceJson);
        else if(operation.getOperationType().equals(PropertyType.NUMBER.getType()))
            return operation.getNumber(json, sourceJson);
        else if(operation.getOperationType().equals(PropertyType.BOOLEAN.getType()))
            return operation.getBoolean(json, sourceJson);

        return "type is error";
    }
}
