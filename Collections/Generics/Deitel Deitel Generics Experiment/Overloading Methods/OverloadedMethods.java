public class OverloadedMethods {
	
//	// method printArray to print integer array
//	public static void printArray(Integer[] inputArray) {
//		for (Integer element: inputArray) {
//			System.out.print(element + " ");
//		}
//		
//		System.out.println();
//	}
//	
//	// method printArray to print Double array
//	public static void printArray(Double[] inputArray) {
//		for (Double element: inputArray) {
//			System.out.print(element+ " ");
//		}
//		
//		System.out.println();
//	}
//	
//	// method printArray to print Character Array
//	public static void printArray(Character[] inputArray) {
//		for (Character element: inputArray) {
//			System.out.print(element+ " ");
//		}
//		
//		System.out.println();
//	}
	
	// Generic function for any array type
	public static <E> void printArray(E[] inputArray) {
		for (E element: inputArray) {
			System.out.print(element+ " ");
		}
		
		System.out.println();
	}
}
