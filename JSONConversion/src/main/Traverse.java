package main;

import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;
import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;

public class Traverse {
	private static String JanksonObjectClassName = "blue.endless.jankson.JsonObject";
	private static String JanksonArrayClassName = "blue.endless.jankson.JsonArray";
	private static String JanksonNullClassName = "blue.endless.jankson.JsonNull";
	
	private static String JavaxObjectClassName = "org.glassfish.json.JsonObjectBuilderImpl$JsonObjectImpl";
	private static String JavaxArrayClassName = "org.glassfish.json.JsonArrayBuilderImpl$JsonArrayImpl";
	
	private static String NumberType = "org.glassfish.json.JsonNumberImpl";
	private static String StringType = "org.glassfish.json.JsonStringImpl";
	
	public static JsonValue DoTraverse(JsonElement jsonElement) {
		JsonValue jsonValue = null;
		
		javax.json.JsonArray jsonArray = null;
		javax.json.JsonObject jsonObject = null;
		
		// get the class type of janksonElement
		String className = jsonElement.getClass().getName();
		if(className.compareTo(JanksonArrayClassName) == 0) {
			// init the JanksonArray
			JsonArray jnkArray = (JsonArray) jsonElement;			
			JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
			
			// iterate through jankson array
			for(JsonElement jsonelem: jnkArray) {
				JsonValue tempJsonVal = DoTraverse(jsonelem);
				if(tempJsonVal != null) {
					String jsonValClassName = tempJsonVal.getClass().getName();
					
					if(jsonValClassName.compareTo(JavaxObjectClassName) == 0) {
						javax.json.JsonObject jsonxOb = (javax.json.JsonObject) tempJsonVal;
						jsonArrayBuilder.add(jsonxOb);
					}else if(jsonValClassName.compareTo(JavaxArrayClassName) == 0) {
						javax.json.JsonArray jsonxArr = (javax.json.JsonArray) tempJsonVal;
						jsonArrayBuilder.add(jsonxArr);
					}else {
						if(jsonValClassName.contains(NumberType)) {
							JsonNumber jsonNumber = (JsonNumber) tempJsonVal;
							jsonArrayBuilder.add(jsonNumber);
						}else if(jsonValClassName.contains(StringType)) {
							JsonString jsonString = (JsonString) tempJsonVal;
							jsonArrayBuilder.add(jsonString);
						}
					}
				}else {
					jsonArrayBuilder.add("null");
				}
			}
			
			jsonArray = jsonArrayBuilder.build();
			return jsonArray;
		}
		else if(className.compareTo(JanksonObjectClassName) == 0) {
			// init the JanksonObject
			JsonObject jnkObject = (JsonObject) jsonElement;
			// init the empty jsonObjectBuilder
			JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
			
			Set<String> keySet = jnkObject.keySet();
			for(String key: keySet) {
				JsonElement tempJnkElem = jnkObject.get(key);
				className = tempJnkElem.getClass().getName();
				
				if(className.compareTo(JanksonArrayClassName) != 0 && className.compareTo(JanksonObjectClassName) != 0) {
					// add primitive type to the jsonValue
					if(tempJnkElem != null) {
						JsonPrimitive jsonPrimitive = (JsonPrimitive) tempJnkElem;
						JsonValue jsval = Helper.GetPrimitiveData(jsonPrimitive);
						className = jsval.getClass().getName();
						
						if(className.contains(NumberType)) {
							JsonNumber jsonNumber = (JsonNumber) jsval;
							jsonObjectBuilder.add(key, jsonNumber);
						}else if(className.contains(StringType)) {
							JsonString jsonString = (JsonString) jsval;
							jsonObjectBuilder.add(key, jsonString);
						}
					}else {
						jsonObjectBuilder.add(key, "null");
					}
				}else {
					JsonValue jsVal = DoTraverse(tempJnkElem);
					String jsonValClassName = jsVal.getClass().getName();
					
					if(jsonValClassName.compareTo(JavaxArrayClassName) == 0) {
						javax.json.JsonArray jsonArr = (javax.json.JsonArray) jsVal;
						jsonObjectBuilder.add(key, jsonArr);
					}else {
						javax.json.JsonObject jsonOb = (javax.json.JsonObject) jsVal;
						jsonObjectBuilder.add(key, jsonOb);
					}
				}
			}
			
			jsonObject = jsonObjectBuilder.build();
			return jsonObject;
		}else {
			// add the primitive type to the json value
			if(className.compareTo(JanksonNullClassName) != 0) {
				JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
				jsonValue = Helper.GetPrimitiveData(jsonPrimitive);
			}
		}
		
		return jsonValue;
	}
}
