package helper;

import java.io.IOException;

public class Console {
	private static final String OperatingSystem = System.getProperty("os.name");
	
	public static void ClearScreen() {
		try {
			if(OperatingSystem.contains("Windows")) {
				Runtime.getRuntime().exec("cmd /c cls");
			}else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
