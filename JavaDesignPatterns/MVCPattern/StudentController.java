
public class StudentController {
	private StudentModel studentModel;
	
	public StudentController() {
		studentModel = new StudentModel();
	}
	
	public void setStudentName(String name) {
		studentModel.setName(name);
	}
	
	public void setRollNo(String rollNo) {
		studentModel.setRollNo(rollNo);
	}
	
	public void updateView() {
		StudentView.printStudentDetials(studentModel);
	}
}

