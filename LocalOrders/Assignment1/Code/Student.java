import java.util.ArrayList;

/**
 * Student - Representation of a student.
 * 
 */

public class Student extends Person
{
	protected static int MAX_NUM_MODULES = 5; // maximum number of modules that a student can enroll
	protected int numberModules; // number of modules currently enrolled
	
	protected ArrayList<Module> enrolledModules;
	protected boolean isARUAA;
	
	/**
	 * Constructor
	 * @param fn Full Name
	 * @param rn Registration Number
	 * @param em Email
	 */
	public Student(String fn, int rn, String em) {
		super(fn, rn, em);
		this.numberModules = 0;
	}
	
	/**
	 * @return the Number of Modules
	 */
	public int getNumberModule() {
		return this.numberModules;
	}

	/**
	 * @param mod - Module to add to this student
	 * @return true if the module was added successfully
	 */
	public boolean addModule(Module mod) {
		this.numberModules = (this.numberModules + 1);
		return true;
	}
	
	public boolean removeModule(Module mod) {
		/*
		 * TODO
		 */
		return false;
	}
	
	
	public String toString() {
		return "Student: " + this.fullname; 
	}
}
