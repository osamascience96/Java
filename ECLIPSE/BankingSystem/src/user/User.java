package user;

import java.util.Scanner;

public class User {
	private Scanner scannerInput;
	private String name;
	private String email;
	private String password;
	
	public User() {
		this.scannerInput = new Scanner(System.in);
	}
	
	public void Login() {
		System.out.println("===> *********************************************************** <===");
		System.out.print("Enter Name> ");
		name = scannerInput.nextLine();
		
		System.out.print("Enter Email> ");
		email = scannerInput.nextLine();
		
		System.out.print("Enter Password> ");
		password = scannerInput.nextLine();
		System.out.println("===> *********************************************************** <===");
	}
	
	public void PrintUserCredentials() {
		System.out.println("===> **************************************************************** <===");
		System.out.println("===> Welcome " + this.name + " <===");
		System.out.println("===> " + this.email + " <===");
		System.out.println("===> **************************************************************** <===");
	}
	
}
