package main;

import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonNull;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;

public class Traverse {
	
	public static JsonValue DoTraverse(JsonElement jsonElement) {
		JsonValue jsonValue = null;
		
		javax.json.JsonArray jsonArray = null;
		javax.json.JsonObject jsonObject = null;
		
		// get the class type of janksonElement
		if(jsonElement instanceof JsonArray) {
			// init the JanksonArray
			JsonArray jnkArray = (JsonArray) jsonElement;			
			JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
			
			// iterate through jankson array
			for(JsonElement jsonelem: jnkArray) {
				JsonValue tempJsonVal = DoTraverse(jsonelem);
				jsonArrayBuilder.add(tempJsonVal);
			}
			
			jsonArray = jsonArrayBuilder.build();
			return jsonArray;
		}
		else if(jsonElement instanceof JsonObject) {
			// init the JanksonObject
			JsonObject jnkObject = (JsonObject) jsonElement;
			// init the empty jsonObjectBuilder
			JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
			
			Set<String> keySet = jnkObject.keySet();
			for(String key: keySet) {
				JsonElement tempJnkElem = jnkObject.get(key);
				
				if(!(tempJnkElem instanceof JsonArray) && !(tempJnkElem instanceof JsonObject)) {
					// add primitive type to the jsonValue
					if(!(tempJnkElem instanceof JsonNull)) {
						JsonPrimitive jsonPrimitive = (JsonPrimitive) tempJnkElem;
						JsonValue jsval = Helper.GetPrimitiveData(jsonPrimitive);
						jsonObjectBuilder.add(key, jsval);
					}else {
						jsonObjectBuilder.add(key, JsonValue.NULL);
					}
				}else {
					JsonValue jsVal = DoTraverse(tempJnkElem);
					jsonObjectBuilder.add(key, jsVal);
				}
			}
			
			jsonObject = jsonObjectBuilder.build();
			return jsonObject;
		}else {
			// add the primitive type to the json value
			if(!(jsonElement instanceof JsonNull)) {
				JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
				jsonValue = Helper.GetPrimitiveData(jsonPrimitive);
			}else {
				jsonValue = JsonValue.NULL;
			}
		}
		
		return jsonValue;
	}
}
