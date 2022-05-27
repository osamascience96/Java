package manager;

import java.util.Scanner;

import account.Account;
import helper.Balance;
import user.User;

public class Manager extends User{
	private Scanner scannerInput;
	private String managerNumber;
	
	public Manager() {
		// TODO Auto-generated constructor stub
		this.scannerInput = new Scanner(System.in);
	}
	
	public void InputManagerAccountCredentials() {
		System.out.print("Manager Number> ");
		this.managerNumber = this.scannerInput.nextLine();
		System.out.println("===> Users Bank Money: " + Account.GetMoneyContainer() + " OMR <===");
	}
	
	public void ManagerMenu() {
		System.out.println("===> Manager Menu <===");
		System.out.println("===> Clear Cheque <===");
		System.out.println("===> Add Bank Money <===");
		System.out.println("===> Enter 1 for Clear Cheque and 2 for Add Money to the Bank");
		System.out.print("Enter> ");
		int managerMenu = 0;
		if(this.scannerInput.hasNextInt()) {
			managerMenu = this.scannerInput.nextInt();
		}
		
		switch (managerMenu) {
		case 1:
			System.out.println("===> *********************************************************** <===");
			System.out.println("Enter Cheque Number> ");
			String chequeNumber = this.scannerInput.next();
			System.out.println(chequeNumber.concat(" Checque Cleared"));
			break;
		case 2:
			System.out.println("===> *********************************************************** <===");
			System.out.print("Enter Amount> ");
			int amount = this.scannerInput.nextInt();
			Balance balance = new Balance();
			// check amount is greater than 0
			if(amount > 0) {
				// check if the amount is greater than the bank money
				balance.WriteBalance(amount);
			}else {
				System.out.println("Money value Should be greater than 0 OMR");
			}
			System.out.println("===> *********************************************************** <===");
			System.out.println("The Bank Money is : " + Account.GetMoneyContainer() + " OMR");
			break;
		default:
			System.out.println("Invalid Option Selected");
			break;
		}
	}
}
