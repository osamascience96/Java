package task1;

import java.util.Scanner;

public class Task1 {
	private int inputNumber = 0;
	
	public Task1() {
		inputNumber = new Scanner(System.in).nextInt();
	}
	
	public void EvenorOdd() {
		if(inputNumber % 2 == 0) {
			System.out.println("The Number is Even");
		}else {
			System.out.println("The Number is Odd");
		}
	}
}
