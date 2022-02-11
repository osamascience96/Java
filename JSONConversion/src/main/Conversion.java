package main;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonValue;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;

public class Conversion {
	public static void ConverttoJavax(String ReceivedJSONString) {
		
		JSONParser jsonParser = new JSONParser();
		
		try {
	         Object obj = jsonParser.parse(new FileReader(ReceivedJSONString));
	         String data = obj.toString();
	         // Set the data to the dataelement
	         JsonElement jsonelement = Jankson.builder().build().loadElement(data);
	         // traerse and convert to the javax.json.jsonvalue
	         JsonValue jsonValue = Json.createValue(Traverse.RecursiveTraverse(jsonParser.parse(jsonelement.toJson())).toString());
	         System.out.println(jsonValue);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
}
