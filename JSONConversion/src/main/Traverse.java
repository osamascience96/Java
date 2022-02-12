package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;

public class Traverse {
	public static Object DoTraverse(Object jsonObject) {
		JsonArray finaljsonArrx = null;
		JsonObject finaljsonobjx = null;
		
		if(jsonObject instanceof JsonArray) {
			finaljsonArrx = new JsonArray();
			
			JsonArray jsonArray = (JsonArray) jsonObject;
			
			for(Object jsonarrObj : jsonArray) {
				Object tempObj = DoTraverse(jsonarrObj);
				if(tempObj instanceof JsonObject) {
					JsonObject jsonObjectx = (JsonObject) tempObj;
					finaljsonArrx.add(jsonObjectx);
				}else if(tempObj instanceof JsonArray) {
					JsonArray jsonArrayx = (JsonArray) tempObj;
					finaljsonArrx.add(jsonArrayx);
				}else {
					JsonElement jsonElement = null;
					try {
						jsonElement = Jankson.builder().build().loadElement(tempObj.toString());
					} catch (SyntaxError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finaljsonArrx.add(jsonElement);
				}
			}
			
			return finaljsonArrx;
		}else if(jsonObject instanceof JsonObject) {
			Map<String, JsonElement> mapObject = new HashMap<String, JsonElement>();
			
			finaljsonobjx = new JsonObject();
			
			JsonObject jsonobj = (JsonObject) jsonObject;
			Set<String> keySet = jsonobj.keySet();
			for(String key: keySet) {
				Object valueObj = jsonobj.get(key);
				// check if the value inside the key is string object
				if(!(valueObj instanceof JsonObject) && !(valueObj instanceof JsonArray)) {
					try {
						JsonElement jsonElement = Jankson.builder().build().loadElement(valueObj.toString());
						mapObject.put(key, jsonElement);
					} catch (SyntaxError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					Object tempObj = DoTraverse(valueObj);
					
					if(tempObj instanceof JsonArray) {
						JsonArray jsonArray = (JsonArray) tempObj;
						mapObject.put(key, jsonArray);
					}else {
						JsonObject jsonObjectx = (JsonObject) tempObj;
						mapObject.put(key, jsonObjectx);
					}
				}
			}
			
			finaljsonobjx.putAll(mapObject);
			return finaljsonobjx;
		}
		
		return jsonObject;
	}
}
