package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Traverse {
	
	public static Object RecursiveTraverse(Object object) {
		JsonArray finaljsonArrx = null;
		JsonObject finaljsonobjx = null;
		
		if(object instanceof JSONArray) {
			JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
			
			JSONArray jsonArray = (JSONArray) object;
			for (Object jsonarrObj : jsonArray) {
				Object tempobj = RecursiveTraverse(jsonarrObj);
				if(tempobj instanceof JsonObject) {
					JsonObject jsonObject = (JsonObject) tempobj;
					jsonArrayBuilder.add(jsonObject);
				}else if(tempobj instanceof JsonArray){
					JsonArray jsonArrayx = (JsonArray) tempobj;
					jsonArrayBuilder.add(jsonArrayx);
				}else {
					jsonArrayBuilder.add(Json.createValue(tempobj.toString()));
				}
			}
			
			finaljsonArrx = jsonArrayBuilder.build();
			return finaljsonArrx;
		}else if(object instanceof JSONObject) {
			Map<String, JsonValue> mapObject = new HashMap<String, JsonValue>();
			
			JsonObjectBuilder builder = Json.createObjectBuilder();
			
			JSONObject jsonObject = (JSONObject) object;
			Set<String> keySet = jsonObject.keySet();
			
			for (String key : keySet) {
				Object valueObj = jsonObject.get(key);
				// check if the value inside the key is string object
				if(!(valueObj instanceof JSONObject) && !(valueObj instanceof JSONArray)) {
					JsonValue jsonValue = Json.createValue(valueObj.toString());
					mapObject.put(key, jsonValue);
				}else {
					Object tempObj = RecursiveTraverse(valueObj);
					
					if(tempObj instanceof JsonArray) {
						JsonArray jsonArray = (JsonArray) tempObj;
						mapObject.put(key, jsonArray);
					}else {
						JsonObject jsonObjectx = (JsonObject) tempObj;
						mapObject.put(key, Json.createValue(jsonObjectx.toString()));
					}
				}
			}
			
			mapObject.forEach(builder::add);
			finaljsonobjx = builder.build();
			return finaljsonobjx;
		}
		
		return object;
	}
}
