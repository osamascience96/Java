package account;

import java.util.Scanner;

import helper.Balance;

public class Account {
	private Scanner scannerInput;
	private Balance balance;
	
	public Account() {
		this.scannerInput = new Scanner(System.in);
		this.balance = new Balance();
	}
	
	public static int GetMoneyContainer() {
		Balance balance = new Balance();
		return Integer.parseInt(balance.ReadBalance());
	}
	
	public void AccountsMenuCredentials() {
		System.out.println("===> Accounts Menu <===");
		System.out.println("===> Money Withdrawl <===");
		System.out.println("===> Money Transfer <===");
		System.out.println("===> Balance Check <===");
		System.out.println("===> Enter 1 for Withdrawl, 2 for transfer, 3 for balance check");
		System.out.print("Enter> ");
		int accountOption = 0;
		if(this.scannerInput.hasNextInt()) {
			accountOption = this.scannerInput.nextInt();
		}
		
		switch (accountOption) {
		case 1:
			System.out.println("===> *********************************************************** <===");
			System.out.print("Enter Amount> ");
			int accountMoney = this.scannerInput.nextInt();
			// check accountMoney is greater than 0
			if(accountMoney > 0) {
				// check if the accountMoney is greater than the actualBalance
				if(accountMoney > GetMoneyContainer()) {
					System.out.println("Not enough balance");
				}else {
					this.balance.UpdateBalance(accountMoney);
					System.out.println("Your remaining balance is : " + GetMoneyContainer() + " OMR");
				}
			}else {
				System.out.println("Money value Should be greater than 0 OMR");
			}
			break;
		case 2:
			System.out.println("===> *********************************************************** <===");
			System.out.print("Enter Transfer Account Number> ");
			String transferAccountNumber = this.scannerInput.next();
			System.out.print("Enter Amount> ");
			int moneyTransfer = this.scannerInput.nextInt();
			
			if(moneyTransfer > 0) {
				// check if the accountMoney is greater than the actualBalance
				if(moneyTransfer > GetMoneyContainer()) {
					System.out.println("Not enough balance");
				}else {
					this.balance.UpdateBalance(moneyTransfer);
					System.out.println("Your remaining balance is : " + GetMoneyContainer() + " OMR");
				}
			}else {
				System.out.println("Money value Should be greater than 0 OMR");
			}
			break;
		case 3:
			System.out.println("===> *********************************************************** <===");
			System.out.println("Your Balance is : " + GetMoneyContainer() + " OMR");
			break;
		default:
			System.out.println("Invalid Accounts Menu");
			break;
		}
		
		this.scannerInput.close();
	}
}
