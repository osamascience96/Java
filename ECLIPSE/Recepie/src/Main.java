import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Taking input from the user 
		String receipeInput = new Scanner(System.in).next();
		
		// split the input usig , delimeter
		String recepeArray[] = receipeInput.split(",");
		
		// set the input to the set of the string
		Input.SetInputSet(recepeArray);
		
		// fetch the set in the form of the hashtable
		Hashtable<Integer, String> keypairingrediants = Input.GetHashTableList();
		
		//creating the instance of the read recepie file 
		ReadRecepieFile readRecepieFile = new ReadRecepieFile();
		
		//reading the data from the hashtable and getting the data from the file, and storing the linear graph in the same function 
		readRecepieFile.ReadFile(keypairingrediants);
		
		// show the data
		Graph.showTraversal();
		
		System.out.println("You can cook the following with available ingrediants:");
		// start from here...
		readRecepieFile.DisplaySuggestions(Graph.GETGRAPHNODE());
	}
}
