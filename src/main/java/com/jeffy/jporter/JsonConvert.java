package com.jeffy.jporter;

import net.sf.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Jeffy on 2014/9/18 0018.
 */
public class JsonConvert {

    public static void main(String[] args) {
        String sourceJson = "{\"servers\":{\"network_id\":\"392af6f9-6503-4cde-9470-14bbe4d8ec0c\",\"flavor\":{\"memory\":1024,\"cpu\":1,\"disk\":80},\"image\":\"936a8f40-0fa3-4350-9730-0a469c61b032\",\"scale\":1},\"partial\":1}";
        String resultJson = "{\"properties\":{\"network_id\":{\"type\":\"string\",\"path\":\"$.servers.network_id\"},\"memory\":{\"type\":\"string\",\"path\":\"$.servers.flavor.memory\"},\"flavor\":{\"type\":\"object\",\"properties\":{\"cpu\":{\"type\":\"string\",\"path\":\"$.servers.flavor.cpu\"},\"disk\":{\"type\":\"string\",\"path\":\"$.servers.flavor.disk\"},\"image\":{\"type\":\"string\",\"path\":\"$.servers.image\"}}},\"scale\":{\"type\":\"string\",\"path\":\"$.servers.scale\"},\"partial\":{\"type\":\"string\",\"path\":\"$.partial\"}}}";

        JSONObject sourceJsonObj = JSONObject.fromObject(sourceJson);
        JSONObject resultJsonObj = JSONObject.fromObject(resultJson);

        Iterator sourceIt = sourceJsonObj.keys();
        Iterator resultIt = resultJsonObj.keys();

        PropertyOperation operation = new PropertyOperation();
        PropertyContext context = new PropertyContext(operation);

        operation.setOperationType(PropertyType.OBJECT.getType());
        context.operation(resultJsonObj, sourceJson);
        JSONObject result = JSONObject.fromObject(operation.getResultJson());
        System.out.println(result);
    }
}
