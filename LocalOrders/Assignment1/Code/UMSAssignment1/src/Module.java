import java.util.ArrayList;

/**
 * Module - A representation of the Module.
 * 
 * ATTENTION: You do NOT need to modify this code at all.
 */

public class Module
{
	private int code; // internal code of the module eg. 5246
	private String name; // name of the module
	private ArrayList<Module> prerequisites; // the list of prerequisites Modules
	
	/**
	 * Constructor
	 * @param c internal code
	 * @param n name
	 */
	public Module(int c, String n) {
		this.code = c;
		this.name = n;
		this.prerequisites = new ArrayList<Module>();
	}
	/**
	 * Constructor
	 * @param c internal code
	 * @param n name
	 * @param pre prerequisite modules
	 */
	public Module(int c, String n, ArrayList<Module> pre) {
		this.code = c;
		this.name = n;
		this.prerequisites = pre;
	}
	
	// getters and setters!
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Module> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(ArrayList<Module> pre) {
		this.prerequisites = pre;
	}

	public void addPrerequisites(Module m) {
		this.prerequisites.add(m);
	}
	public void removePrerequisites(Module m) {
		this.prerequisites.remove(m);
	}

	/**
	 * Get a description of the Module as a String
	 */
	public String toString() {
		return "Module: " + code + " - " + name; 
	}
	
}
