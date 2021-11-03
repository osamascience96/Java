public class Person {
	public <N, A> void displayInformation(N parameter1, A parameter2) {
		if (parameter1.getClass().getTypeName().equals("java.lang.String")) {
			// if pararm 1 equal to string
			System.out.println("Your Name is "+ parameter1 + " and your age is " + parameter2);
		}else {
			System.out.println("Your Name is "+ parameter2 + " and your age is " + parameter1);
		}
	}
}
