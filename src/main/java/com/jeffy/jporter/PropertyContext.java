package com.jeffy.jporter;

import com.jeffy.jporter.Property;
import com.jeffy.jporter.PropertyOperation;
import com.jeffy.jporter.PropertyType;
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
        else if (operation.getOperationType().equals(PropertyType.ARRAY.getType()))
            return operation.getArrayProperties(json, sourceJson);
        else
            return operation.getValue(json, sourceJson);
    }
}
