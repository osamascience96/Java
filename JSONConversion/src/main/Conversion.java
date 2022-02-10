package main;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonValue;

import org.json.simple.parser.JSONParser;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;

public class Conversion {
	public static void ConverttoJavax(String ReceivedJSONString) {
		
		JSONParser jsonParser = new JSONParser();
		
		try {
	         Object obj = jsonParser.parse(new FileReader(ReceivedJSONString));
	         String data = obj.toString();
	         
	         JsonElement jsonelement = Jankson.builder().build().loadElement(data);
	        
	         JsonValue jsonValue = Json.createValue(jsonelement.toJson());
	         System.out.println(jsonValue);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
}
