
// A Class definition that has only single Function

public class Sample<T> {
	public Sample() {
		// TODO Auto-generated constructor stub
	}
	
	// generic data type function that accepts all the params 
	<T>void showArray(T[] data) {
		for (int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
}
