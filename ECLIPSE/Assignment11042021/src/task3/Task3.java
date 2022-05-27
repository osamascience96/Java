package task3;

import java.util.Scanner;

public class Task3 {
	private String[] numberList;
	
	public Task3() {
		Scanner sc = new Scanner(System.in);
		
		String inputList = sc.nextLine();
		
		numberList = inputList.split(" ");
	}
	
	public void SumOfNumbers() {
		int sum = 0;
		
		for(int i=0; i < numberList.length; i++) {
			sum += GetConvertNumber(numberList[i]);
		}
		
		System.out.println("The sum of the numbers: ".concat(String.valueOf(sum)));
	}
	
	private int GetConvertNumber(String num) {
		return Integer.parseInt(num);
	}
}
