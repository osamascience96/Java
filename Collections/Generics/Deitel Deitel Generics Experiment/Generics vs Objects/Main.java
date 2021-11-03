// Sample Age Program using generics
public class Main{
	public static void printArray(Object[] inputArray) {
		// display the information 
		for (Object element: inputArray) {
			System.out.print(element + " ");
		}
		
		System.out.println();
	}
	public static void main(String []args){		
		Integer integerArray[] = {1, 2, 3, 4};
		Double doubleArray[] = {1.1, 2.2, 3.3, 4.4};
		Character charArray[] = {'a', 'b', 'c', 'd'};
		
		printArray(integerArray);
		printArray(doubleArray);
		printArray(charArray);
	}
}