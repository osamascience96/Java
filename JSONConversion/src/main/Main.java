package main;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		
		File directory = new File("./");
		String path = directory.getAbsolutePath().toString();
		
		String sample1 = path.concat("/src/main/sample1.json");
		String sample2 = path.concat("/src/main/sample2.json");
		String sample3 = path.concat("/src/main/sample3.json");
		String sample4 = path.concat("/src/main/sample4.json");
		String sample5 = path.concat("/src/main/sample5.json");
		
		String json = new Reader().GetJSONData(sample5);
		
		Conversion.ConverttoJavax(json);
	}
}
