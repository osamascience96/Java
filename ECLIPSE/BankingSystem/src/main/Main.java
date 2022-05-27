package main;

import java.util.Scanner;

import account.Account;
import customer.Customer;
import helper.Console;
import manager.Manager;

public class Main {
	public static void main(String[] args) {
		// clear the screen
		Console.ClearScreen();
		// start the program
		System.out.println("===> Welcome to a Console Banking System Prototype <===");
		System.out.println("===> Login as a Customer or Manager <===");
		System.out.println("===> Press 1 for Customer or 2 for Manager <===");
		
		Scanner scanner = new Scanner(System.in);
		
		int option = scanner.nextInt();
		
		switch (option) {
		case 1:
			// customer
			Customer customer = new Customer();
			Account account = new Account();
			customer.Login();
			customer.PrintUserCredentials();
			customer.InputAccountCredentials();
			account.AccountsMenuCredentials();
			break;
		case 2:
			// manager
			Manager manager = new Manager();
			manager.Login();
			manager.PrintUserCredentials();
			manager.InputManagerAccountCredentials();
			manager.ManagerMenu();
			break;
		default:
			System.out.println("Invalid Option Selected");
			break;
		}
		
		scanner.close();
	}
}
