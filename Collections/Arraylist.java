import java.util.ArrayList;

// Play with array list

public class main {

	public static void main(String[] args){
		 ArrayList<String> namesList = new ArrayList<String>();
		 // add the element to the end of the list 
		 namesList.add("Osama");
		 namesList.add("Jafri");
		 namesList.add("Usman");
		 namesList.add("Saad");
		 namesList.add("Ali");
		 
		 System.out.println(namesList);
		 
		 // appends the specified element to the specified index 
		 namesList.add(1, "Hassan");
		 
		 System.out.println(namesList);
		 
		 // gets the element at the specified index
		 System.out.println(namesList.get(3)); // prints Usman
		 
		 // returns true if the list contains the specified element 
		 System.out.println(namesList.contains("Ali")); // returns true
		 
		 // removes the element at the specified position in the list 
		 System.out.println(namesList.remove(0));
		 System.out.println(namesList); // removes the name from the list
		 
		 // returns the number of elements in the list 
		 System.out.println(namesList.size());
		 
		 // clear the entire list 
		 namesList.clear();
		 System.out.println(namesList); // the list is clear
	}
}
