package com.encryption;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Encrypt {
	
	// constructor
	public Encrypt() {
	}
	
	// function that encrypt the text
	public String EncryptText(String text) {
		// converting the string to base64 to encrypt the string
		// Note: base64 is not strong encryption
		return this.GetBase64PassString(text);
	}
	
	private String GetBase64PassString(String text) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(text.getBytes());
	}
}
