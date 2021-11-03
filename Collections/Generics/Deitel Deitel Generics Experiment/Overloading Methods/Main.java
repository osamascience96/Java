public class Main{
	
	
	
	public static void main(String []args){		
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		
		System.out.println("Array IntegerArray Contains: ");
		OverloadedMethods.printArray(integerArray);
		
		System.out.println("Array DoubleArray Contains: ");
		OverloadedMethods.printArray(doubleArray);
		
		System.out.println("Array CharacterArray Contains: ");
		OverloadedMethods.printArray(characterArray);
	}
	
}