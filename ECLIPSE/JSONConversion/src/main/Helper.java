package main;

import javax.json.Json;
import javax.json.JsonValue;

import blue.endless.jankson.JsonNull;
import blue.endless.jankson.JsonPrimitive;

public class Helper {
	public static JsonValue GetPrimitiveData(JsonPrimitive jsonPrimitive) {
		JsonValue finalJsonValue = null;
		
		if(jsonPrimitive != null) {
			Object obj = jsonPrimitive.getValue();
			
			// using instanceof to get the datatype of primitive types
			if(obj instanceof Integer) {
				int data = (Integer) obj;
				finalJsonValue = Json.createValue(data);
			}else if(obj instanceof Float) {
				float data = (Float) obj;
				finalJsonValue = Json.createValue(data);
			}else if(obj instanceof Double) {
				double data = (Double) obj;
				finalJsonValue = Json.createValue(data);
			}else if(obj instanceof String) {
				String data = (String) obj;
				finalJsonValue = Json.createValue(data);
			}else if(obj instanceof Boolean) {
				Boolean bool = (Boolean) obj;
				if(bool) {
					finalJsonValue = JsonValue.TRUE;
				}else {
					finalJsonValue = JsonValue.FALSE;
				}
			}else if(obj instanceof Long) {
				long data = (Long) obj;
				finalJsonValue = Json.createValue(data);
			}
		}
		
		return finalJsonValue;
	}
}
