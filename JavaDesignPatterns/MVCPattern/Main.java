
public class Main {
	private static StudentModel stdModel = null;
	
	public static void main(String[] args) {
		StudentController stdController = new StudentController();
		
		// setting the data from the sample database
		stdController.setRollNo(reteriveStudentFromDatabase().getRollNo());
		stdController.setStudentName(reteriveStudentFromDatabase().getName());
		
		// calling the view from the controller
		stdController.updateView();
	}
	
	// sample function thats creates the singleton object of the student model just for the examples
	private static StudentModel reteriveStudentFromDatabase() {
		if (stdModel == null) {
			stdModel = new StudentModel();
			stdModel.setName("Ali");
			stdModel.setRollNo("314-23422");
		}
		
		return stdModel;
	}
}

