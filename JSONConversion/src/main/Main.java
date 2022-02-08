package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;

public class Main {
	public static void main(String[] args) {
		
		JSONParser jsonParser = new JSONParser();
		
		File directory = new File("./");
		String path = directory.getAbsolutePath().toString();
		
		String sample1 = path.concat("/src/main/sample1.json");
		String sample2 = path.concat("/src/main/sample2.json");
		String sample3 = path.concat("/src/main/sample3.json");
		
		try {
	         Object obj = jsonParser.parse(new FileReader(sample3));
	         String data = obj.toString();
	         
	         JsonElement jsonelement = Jankson.builder().build().loadElement(data);
	         System.out.println(jsonelement.toJson());
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
}
