package com.jeffy.jporter;

import net.sf.json.JSONObject;

/**
 * Created by Jeffy on 2014/9/19 0019.
 */
public class JsonConvertTest {
        public static void main(String[] args) {
            String sourceJson = "{\"servers\":{\"network_id\":\"392af6f9-6503-4cde-9470-14bbe4d8ec0c\",\"flavor\":{\"memory\":1024,\"cpu\":1,\"disk\":80},\"image\":\"936a8f40-0fa3-4350-9730-0a469c61b032\",\"scale\":1},\"partial\":1,\"testa\":[{\"str\":\"1\",\"num\":{\"int\":1}},{\"str\":\"2\",\"num\":{\"int\":2}},{\"str\":\"3\",\"num\":{\"int\":3}},{\"str\":\"4\",\"num\":{\"int\":4}},{\"str\":\"5\",\"num\":{\"int\":5}}],\"testb\":[1,2,3]}";
            String resultJson = "{\"type\":\"object\",\"properties\":{\"testa\":{\"type\":\"object_array\",\"path\":\"$.testa\",\"properties\":{\"num\":{\"type\":\"object\",\"properties\":{\"int\":{\"type\":\"number\",\"path\":\"$.num.int\"}}}}}}}";

            JSONObject json = JsonConvert.convert(sourceJson, resultJson);
            System.out.println(json);
        }

}
