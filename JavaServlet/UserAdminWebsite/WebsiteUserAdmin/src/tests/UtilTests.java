package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utility.User;

public class UtilTests {
	
	
	@Test
	public void TestEmail() {
		assertTrue(User.VerifyEmail("osamahu96@gmail.com"));
		assertFalse(User.VerifyEmail("@gmail.com"));
	}
	
	public void TestPassword() {
		assertTrue(User.VerifyPassword("123"));
		assertFalse(User.VerifyPassword("osama123"));
	}
	
	
}
