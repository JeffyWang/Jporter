package com.jeffy.jporter;

import net.sf.json.JSONObject;

/**
 * Created by Jeffy on 2014/9/19 0019.
 */
public class JsonConvertTest {
        public static void main(String[] args) {
            String sourceJson = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10,\"time\":[\"Monday\",\"Tuesday\",\"Wednesday\",\"Thursday\",\"Friday\"]}";
            String resultJson = "{\"type\":\"object\",\"properties\":{\"book\":{\"type\":\"object_array\",\"path\":\"$.store.book\",\"properties\":{\"category\":{\"type\":\"string\",\"path\":\"$.category\"},\"isbn\":{\"type\":\"string\",\"path\":\"$.isbn\"},\"price\":{\"type\":\"number\",\"path\":\"$.price\"}}},\"test\":{\"type\":\"string\",\"value\":\"test\"}}}";



            JSONObject json = JsonConvert.convert(sourceJson, resultJson);
            System.out.println(json);
        }

}
