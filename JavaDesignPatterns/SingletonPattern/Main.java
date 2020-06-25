
public class Main {

	public static void main(String[] args) {
		SingleObject s1 = SingleObject.getInstance();
		SingleObject s2 = SingleObject.getInstance();
		SingleObject s3 = SingleObject.getInstance();
		
		s1.showMessage();
		s2.showMessage();
		s3.showMessage();
		
//		print the memory address of both the variables, are these the aliases of the same memory address?
//		lets check it out>....
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
