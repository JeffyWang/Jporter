package com.jeffy.jporter;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public class PropertyOperation {
    private String operationType;
    private Map<String, Object> resultJson;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Map<String, Object> getResultJson() {
        return resultJson;
    }

    public Object getString(JSONObject json, String sourceJson) {
        Object value = JsonPath.read(sourceJson, getPath(json));
        return value;
    }

    public Object getNumber(JSONObject json, String sourceJson) {
        return getString(json, sourceJson);
    }

    public Object getBoolean(JSONObject json, String sourceJson) {
        return getString(json, sourceJson);
    }

    public Object getArray(JSONObject json, String sourceJson) {
        Object array = JsonPath.read(sourceJson, getPath(json));
        return array;
    }

    public String getPropertyType(JSONObject json) {
        return json.getString(Property.TYPE.getProperty());
    }

    public String getPath(JSONObject json) {
        return json.getString(Property.PATH.getProperty());
    }

    public Object getObjectProperties(JSONObject json, String sourceJson) {
        JSONObject properties = (JSONObject) json.get(Property.PROPERTIES.getProperty());
        Iterator it = properties.keys();

        PropertyOperation operation = new PropertyOperation();
        PropertyContext context = new PropertyContext(operation);

        resultJson = new HashMap<String, Object>();

        while (it.hasNext()) {
            String key = (String) it.next();
            JSONObject obj = (JSONObject) properties.get(key);
            String type = getPropertyType(obj);
            operation.setOperationType(type);
            Object value = context.operation(obj, sourceJson);
            resultJson.put(key, value);
        }

        return resultJson;
    }

    public Object getObjectArrayProperties(JSONObject json, String sourceJson) {
        JSONArray array = (JSONArray) getArray(json, sourceJson);
        List<Object> list = new ArrayList<Object>();

        for(int i = 0; i < array.size(); i ++) {
            Object value =getObjectProperties(json, array.get(i).toString());
            list.add(value);
        }

        return list;
    }

    public Object getStringArrayProperties(JSONObject json, String sourceJson) {
        Object value = getString(json, sourceJson);

        return value;
    }

    public Object getNumberArrayProperties(JSONObject json, String sourceJson) {
        Object value = getNumber(json, sourceJson);

        return value;
    }

    public Object getBooleanArrayProperties(JSONObject json, String sourceJson) {
        Object value = getBoolean(json, sourceJson);

        return value;
    }

}