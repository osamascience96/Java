package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Balance {
	private File file;
	
	public Balance() {
		this.file = new File("Balance");
	}
	
	public String ReadBalance() {
		String balance = null;
		Scanner dataReader;
		try {
			dataReader = new Scanner(this.file);
			while(dataReader.hasNextLine()) {
				balance = dataReader.nextLine();
			}
			dataReader.close();
			this.file = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}
	
	public void WriteBalance(int amount) {
		// get the previous balance 
		int balance = Integer.parseInt(this.ReadBalance());
		
		try {
			FileWriter fileWriter = new FileWriter("Balance");
			balance += amount;
			fileWriter.write(String.valueOf(balance));
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateBalance(int amount) {
		// get the previous balance 
		int balance = Integer.parseInt(this.ReadBalance());
		
		try {
			FileWriter fileWriter = new FileWriter("Balance");
			balance -= amount;
			fileWriter.write(String.valueOf(balance));
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
