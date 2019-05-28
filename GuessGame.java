import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean flag = false;
		int randomNumber = (int)(Math.random() * 100) + 1;
		System.out.println("A Random Number has been generated");
		System.out.println("You have 10 turns to guess the random number generated");
		System.out.println("=+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (int i=10;i>0;i--) {
			System.out.println("You have " + i + " turn");
			
			System.out.print("Enter the Number to Guess: ");
			int guess = new Scanner(System.in).nextInt();
			
			if(guess < randomNumber) {
				System.out.println("Number Generated is greater than " + guess); 
			}else if (guess > randomNumber) {
				System.out.println("Number Generated is smaller than " + guess);
			}else {
				flag = true;
				break;
			}
		}
		
		if (flag) {
			System.out.println("You Won!!!");
		}else {
			System.out.println("You Loose!!!");
			System.out.println("The Right Number is " + randomNumber);
		}
	}

}
