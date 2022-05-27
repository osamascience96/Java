package main;

import javax.json.Json;
import javax.json.JsonValue;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.api.SyntaxError;

public class Conversion {
	public static void ConverttoJavax(String ReceivedJSONString) {
		JsonElement jsonElement = null;
		
		try {
			// set received json to jsonelement
			jsonElement = Jankson.builder().build().loadElement(ReceivedJSONString);
			// Set the Jsonvalue by traversing
			JsonValue jsonValue = Traverse.DoTraverse(jsonElement);
			System.out.println(jsonValue);
		} catch (SyntaxError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
