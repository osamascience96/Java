import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class PossibilityExtractor {
	// private instance of the ingrediant set
	private Set<String> ingrediantSet = null;
	
	// constructor of the ingrediant sets
	public PossibilityExtractor(Set<String> ingrediantsSet) {
		this.ingrediantSet = ingrediantsSet;
	}
	
	// function that uses the O^n2 that makes all the possibilites from the input and return in the hastable datastructure.
	public Hashtable<Integer, ArrayList<String>> GetPossibilitiesHash(){
		int count = 0;
		// creating the hashtable datastructure to hold the data
		Hashtable<Integer, ArrayList<String>> hashtableList = new Hashtable<Integer, ArrayList<String>>();
		// check if the size of the set is 1
		if(this.ingrediantSet.size() > 1) {
			// using O^n2 algorithm 
			for(int i=0; i < this.ingrediantSet.size(); i++) {
				for(int j=i+1; j < this.ingrediantSet.size(); j++) {
					ArrayList<String> arrayList = new ArrayList<String>();
					Object ingrediantArray[] = this.ingrediantSet.toArray();
					arrayList.add(String.valueOf(ingrediantArray[i]));
					arrayList.add(String.valueOf(ingrediantArray[j]));
					hashtableList.put(count++, arrayList);
				}
			}
		}else {
			ArrayList<String> arrayList = new ArrayList<String>();
			Object ingrediantArray[] = this.ingrediantSet.toArray();
			arrayList.add(String.valueOf(ingrediantArray[0]));
			hashtableList.put(0, arrayList);
		}
		
		return hashtableList;
	}
}
