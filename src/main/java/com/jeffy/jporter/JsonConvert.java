package com.jeffy.jporter;

import com.jayway.jsonpath.JsonPath;
import net.sf.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public class JsonConvert {
    public static JSONObject convert(String sourceJson, String resultJson) {
        JSONObject sourceJsonObj = JSONObject.fromObject(sourceJson);
        JSONObject resultJsonObj = JSONObject.fromObject(resultJson);

        PropertyOperation operation = new PropertyOperation();
        PropertyContext context = new PropertyContext(operation);

        String type = resultJsonObj.getString(Property.TYPE.getProperty());

        operation.setOperationType(type);
        context.operation(resultJsonObj, sourceJson);
        JSONObject result = JSONObject.fromObject(operation.getResultJson());

        return result;
    }
}
