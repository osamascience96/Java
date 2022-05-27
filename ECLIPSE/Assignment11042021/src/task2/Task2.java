package task2;

import java.util.Scanner;

public class Task2 {
	private String inputString;
	
	public Task2() {
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();
	}
	
	public void CountVovels() {
		int countVovels = 0;
		
		for(int i=0; i < inputString.length(); i++) {
			if(isVovel(inputString.charAt(i))) {
				countVovels +=1;
			}
		}
		
		System.out.println("The Vovels Count is: ".concat(String.valueOf(countVovels)));
	}
	
	// return true if the char is vovel
	private boolean isVovel(char ch) {
		boolean is_vovel = false;
		
		if((ch == 'a' || ch == 'A') || (ch == 'e' || ch == 'E') || (ch == 'i' || ch == 'I') || (ch == 'o' || ch == 'O') || (ch == 'u' || ch == 'U')) {
			is_vovel = true;
		}
		
		return is_vovel;
	}
}
