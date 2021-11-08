
/**
 * Cohort - A class that associates the Module, the list of students (stored as a Binary Tree)
 * enrolled in the Module, and a Professor.
 * 
 * ATTENTION: You do NOT need to modify this code at all.
 * 
 */
public class Cohort
{
	private Module module; // internal code of the module eg. 5246
	private BinaryTree btree; // binary tree that stores the students enrolled in this module
	private Professor prof; // Professor teaching this module
	
	/**
	 * Constructor
	 * @param m module
	 * @param p Professor
	 */
	public Cohort(Module m, Professor p) {
		this.module = m;
		this.btree = new BinaryTree(); // empty
		this.prof = p;
	}
	/**
	 * Constructor
	 * @param m module
	 * @param bt binaryTree with the students enrolled in the module
	 * @param p Professor
	 */
	public Cohort(Module m, BinaryTree bt, Professor p) {
		this.module = m;
		this.btree = bt;
		this.prof = p;
	}
	
	// getters and setters!
	public Module getModule() {
		return module;
	}

	public BinaryTree getBtree() {
		return btree;
	}
	public void setBtree(BinaryTree btree) {
		this.btree = btree;
	}
	
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}

	/**
	 * Add a Student to the binary tree
	 * @param s The Student
	 */
	public void addStudent(Student s)
	{
		btree.addNode(s);
		s.addModule(module);
	}
	
	/**
	 * Walk tree method
	 * @return A String with the names of all Students in the tree
	 */
	public String walkTree()
	{
		return btree.walkTree();
	}

	/**
	 * Find a student in the binary tree using the name
	 * @param name The name of the student you are searching for
	 * @return A reference to the Student that was found or null if no Student found
	 */
	public Student find(String name)
	{
		return btree.find(name);
	}
	
	/**
	 * Method for printing the tree
	 */
	public void describeStudentTree()
	{	
		btree.printTree();
	}

	/**
	 * Get a description of the Module as a String
	 */
	public String toString() {
		return "Class: " + module.getCode() + " - " + module.getName() + 
				" -- Students: " + btree.walkTree(); 
	}
	
}
