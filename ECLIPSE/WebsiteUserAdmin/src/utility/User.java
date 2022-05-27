package utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	public static boolean VerifyEmail(String email) {
		String regex = "^[A-Za-z0-9]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean VerifyPassword(String password) {
		return password.length() >= 6;
	}
	
	public static String GetSHA256Password(String input) throws NoSuchAlgorithmException
    { 
        // Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
        // digest() method called 
        // to calculate message digest of an input 
        // and return array of byte
        return new String(md.digest(input.getBytes(StandardCharsets.UTF_8))); 
    }
}
