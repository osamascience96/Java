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
		this.isARUAA = false;
		this.enrolledModules = new ArrayList<Module>();
	}
	
	public Student(String fn, int rn, String em, ArrayList<Module> enrollMod, boolean isARUAA) {
		super(fn, rn, em);
		this.numberModules = 0;
		this.enrolledModules = enrollMod;
		this.isARUAA = isARUAA;
	}
	
	/**
	 * @return the Number of Modules
	 */
	public int getNumberModule() {
		return this.numberModules;
	}
	
	/**
	 * @param mod - Get the index of the given module
	 * @return index of the module in arraylist */
	public int GetModuleIndex(Module mod) {
		for(Module module : this.enrolledModules) {
			if(mod.getCode() == module.getCode()) {
				return this.enrolledModules.indexOf(module);
			}
		}
		
		return -1;
	}

	/**
	 * @param mod - Module to add to this student
	 * @return true if the module was added successfully
	 */
	public boolean addModule(Module mod) {
		boolean isAltered = false;
		// ensure step 7
		if(this.numberModules < MAX_NUM_MODULES) {
			// if the module exists in the arraylist
			if(this.GetModuleIndex(mod) < 0) {
				// add the module to the arraylist
				this.enrolledModules.add(mod);
				this.numberModules = (this.numberModules + 1);
				isAltered = true;
			}
		}
		
		return isAltered;
	}
	
	public boolean removeModule(Module mod) {
		// get the index of module 
		int index = this.GetModuleIndex(mod);
		if(index > -1) {
			//remove from index
			this.enrolledModules.remove(index);
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Module> getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(ArrayList<Module> enrolledModules) {
		this.enrolledModules = enrolledModules;
	}

	public boolean isARUAA() {
		return isARUAA;
	}

	public void setARUAA(boolean isARUAA) {
		this.isARUAA = isARUAA;
	}

	public String toString() {
		return "Student: " + this.fullname; 
	}
}
