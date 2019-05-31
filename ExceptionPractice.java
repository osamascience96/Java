import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args){
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			int month = scanner.nextInt();
			System.out.println(months[month]);
		}catch(IndexOutOfBoundsException exception) {
			System.out.println("Index out of Bounds");
		}catch(InputMismatchException exception) {
			System.out.println("Input Mismatch");
		}
	}
}
