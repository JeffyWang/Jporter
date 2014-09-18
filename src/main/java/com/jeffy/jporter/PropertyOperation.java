package com.jeffy.jporter;

import com.jayway.jsonpath.JsonPath;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public class PropertyOperation {
    private String operationType;
    private Map<String, Object> resultJson = new HashMap<String, Object>();

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Map<String, Object> getResultJson() {
        return resultJson;
    }

    public void setResultJson(Map<String, Object> resultJson) {
        this.resultJson = resultJson;
    }

    public Object getValue(JSONObject json, String sourceJson) {
        Object value = JsonPath.read(sourceJson, getPath(json));
        return value;
    }

    public String getPropertyType(JSONObject json) {
        return json.getString(Property.TYPE.getProperty());
    }

    public String getPath(JSONObject json) {
        return json.getString(Property.PATH.getProperty());
    }

    public JSONObject getObjectProperties(JSONObject json, String sourceJson) {
        JSONObject properties = (JSONObject) json.get(Property.PROPERTIES.getProperty());
        Iterator it = properties.keys();

        PropertyOperation operation = new PropertyOperation();
        PropertyContext context = new PropertyContext(operation);

        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key);
            JSONObject obj = (JSONObject) properties.get(key);
            String type = getPropertyType(obj);
            operation.setOperationType(type);
            Object value = context.operation(obj, sourceJson);
            resultJson.put(key, value);
        }

        return JSONObject.fromObject(resultJson);
    }

    public JSONObject getArrayProperties(JSONObject json, String sourceJson) {
        return null;
    }
}