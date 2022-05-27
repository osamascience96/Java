package customer;

import java.util.Scanner;

import account.Account;
import user.User;

public class Customer extends User{
	
	private Scanner scannerInput;
	private String accountNumber;
	
	public Customer() {
		this.scannerInput = new Scanner(System.in);
	}
	
	public void InputAccountCredentials() {
		System.out.print("Account Number> ");
		this.accountNumber = this.scannerInput.nextLine();
		System.out.println("===> Your Balance is: " + Account.GetMoneyContainer() + " OMR <===");
	}
		
}
