import java.util.Scanner;

public class MyRoot {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the index (either 2 or 3) and the radicand: ");
		String inputData = scanner.nextLine();
				
		String[] inputDataArray = inputData.split(" ");
		
		if(inputDataArray.length == 2) {
			int index = Integer.parseInt(inputDataArray[0]);
			int number = Integer.parseInt(inputDataArray[1]);
			
			BisectionAlgorithm bisectionAlgorithm = new BisectionAlgorithm();
			bisectionAlgorithm.Root(index, number);
		}else {
			System.out.println("Please Enter the valid input");
		}
	}
}
