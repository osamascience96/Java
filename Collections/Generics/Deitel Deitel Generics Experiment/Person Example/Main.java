// Sample Age Program using generics
public class Main{
	public static void main(String []args){		
		String name = "osama";
		Integer age = 23;
		
		Person p = new Person();
		
		// let the param be in the function 
		p.displayInformation(name, age);
		
		// let the params be in the function in this way
		p.displayInformation(age, name);
	}
}