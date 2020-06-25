
public class SingleObject {
	private static SingleObject singleInstance;
	
	private SingleObject() {
	}
	
	public static SingleObject getInstance() {
		if (singleInstance == null) {
			singleInstance = new SingleObject();
		}
		
		return singleInstance;
	}
	
	public void showMessage() {
		System.out.println("This is the single object");
	}
	
	
}
