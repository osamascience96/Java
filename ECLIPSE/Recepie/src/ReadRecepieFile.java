import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class ReadRecepieFile extends Graph{
	// private file instance
	private File fileObj;
	
	// constructor that initlizes the file object to read the file.
	public ReadRecepieFile() {
		this.fileObj = new File("Recipes.txt");
	}
	
	// function that reads the files and store inside the linear graph to which this class is inherited.
	public void ReadFile(Hashtable<Integer, String> hashtable) {
		
		Hashtable<String, ArrayList<String>> finalHashtable = new Hashtable<String, ArrayList<String>>();
		
		try {
			Scanner scanReader = new Scanner(this.fileObj);
			while(scanReader.hasNextLine()) {
				String data = scanReader.nextLine();
				
				List<String> dataArray =  Arrays.asList(data.split(","));
				ArrayList<String> listArrayIngrediants = new ArrayList<String>();
				
				for(int i=1; i < dataArray.size(); i++) {
					listArrayIngrediants.add(dataArray.get(i));
				}
				
				// check if the size of the list is equal to the size of the input param hashtable 
				if(listArrayIngrediants.size() == hashtable.size()) {
					boolean isvalid = false;
					
					ArrayList<String> inputlist = new ArrayList<String>();
					for(int i=0; i < hashtable.size(); i++) {
						inputlist.add(hashtable.get(i));
					}
					// if the size is equal, then no need to compare linearly, just use the containsall function
					// which will compare the both lists of equal size, on input list that is
					// converted from hashtable and the other is also the same converted from hashtable
					if(inputlist.containsAll(listArrayIngrediants)) {
						isvalid = true;
					}
					
					if(isvalid) {
						finalHashtable.put(dataArray.get(0), listArrayIngrediants);
					}
				}else if(listArrayIngrediants.size() == 1) {
					if(hashtable.get(0).compareTo(listArrayIngrediants.get(0)) == 0) {
						finalHashtable.put(dataArray.get(0), listArrayIngrediants);
					}
				}else if(listArrayIngrediants.size() < hashtable.size()) {
					boolean iscontained = false;
					
					ArrayList<String> inputlist = new ArrayList<String>();
					for(int i=0; i < hashtable.size(); i++) {
						inputlist.add(hashtable.get(i));
					}
					
					for(int i=0; i < listArrayIngrediants.size(); i++) {
						if(inputlist.contains(listArrayIngrediants.get(i))) {
							iscontained = true;
						}else {
							iscontained = false;
							break;
						}
					}
					
					if(iscontained) {
						finalHashtable.put(dataArray.get(0), listArrayIngrediants);
					}
				}
			}
			
			// adding to the graph from the finalhashtable
			InsertVertex(finalHashtable);
			
			// close the scanner object 
			scanReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// show suggestions
	public void DisplaySuggestions(Node linearGraphVertex) {
		if(linearGraphVertex != null) {
			Node startNode = linearGraphVertex;
			while(startNode != null) {
				String key = startNode.getHashtableData().keys().nextElement();
				ArrayList<String> recepiesArrayList = startNode.getHashtableData().get(key);
				try {
					Scanner scanReader = new Scanner(this.fileObj);
					while(scanReader.hasNextLine()) {
						String data = scanReader.nextLine();
						
						List<String> dataArray =  Arrays.asList(data.split(","));
						ArrayList<String> listArrayIngrediants = new ArrayList<String>();
						
						for(int i=1; i < dataArray.size(); i++) {
							listArrayIngrediants.add(dataArray.get(i));
						}
						
						ArrayList<String> specifiedSuggestArrayList = new ArrayList<String>();
						
						if(listArrayIngrediants.containsAll(recepiesArrayList)) {
							
							for(int i=0; i < listArrayIngrediants.size(); i++) {
								if(!(recepiesArrayList.contains(listArrayIngrediants.get(i)))) {
									specifiedSuggestArrayList.add(listArrayIngrediants.get(i));
								}
							}
							
							System.out.println("if you buy {".concat(!(specifiedSuggestArrayList.isEmpty()) ? specifiedSuggestArrayList.toString() : listArrayIngrediants.toString()).concat("} you can cook ").concat(dataArray.get(0).concat(": {").concat(listArrayIngrediants.toString()).concat("}")));
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startNode = startNode.getGraphEdge();
			}
		}else {
			System.out.println("No Suggestions Available");
		}
	}
}
