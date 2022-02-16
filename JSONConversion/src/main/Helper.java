package main;

import javax.json.Json;
import javax.json.JsonValue;
import blue.endless.jankson.JsonPrimitive;

public class Helper {
	public static JsonValue GetPrimitiveData(JsonPrimitive jsonPrimitive) {
		JsonValue finalJsonValue = null;
		
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
			finalJsonValue = Json.createValue(obj.toString());
		}else if(obj instanceof Long) {
			long data = (Long) obj;
			finalJsonValue = Json.createValue(data);
		}
		
		return finalJsonValue;
	}
}
