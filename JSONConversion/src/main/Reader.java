package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	public String GetJSONData(String filename) {
		// using json simple library, to parse the json from the file only
		JSONParser jsonParser = new JSONParser();
		
		Object object = null;
		
		try {
			FileReader reader = reader = new FileReader(filename);
			object = jsonParser.parse(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object.toString();
	}
}
