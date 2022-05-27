import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Input {
	// init the static set for the input 
	private static Set<String> recepiesSet = new HashSet<String>();
	
	// set the (Set datastructure) from the upcoming input
	public static void SetInputSet(String[] ingredientsInput){
		recepiesSet.addAll(Arrays.asList(ingredientsInput));
	}
	
	// hashtable that gets the
	public static Hashtable<Integer, String> GetHashTableList(){
		Hashtable<Integer, String> hashtableList = new Hashtable<Integer, String>();
		
		for(int i=0; i < recepiesSet.size(); i++) {
			hashtableList.put(i, String.valueOf(recepiesSet.toArray()[i]));
		}
		
		return hashtableList;
	}
	
	// get the ingredient set
	public static Set<String>GetInputIngredients(){
		return recepiesSet;
	}
}
