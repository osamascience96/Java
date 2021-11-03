
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  University maintains an ArrayList called cohorts that stores the list of classes of the university.
 *  Your task is to correctly implement the method bodies for:
 * 
 *  protected ArrayList<Cohort> quickSort(ArrayList<Cohort> list, boolean ascending, String attr)
 *	protected boolean checkForCycles(Graph rel, Module node, Map<Module, Boolean> visited, Map<Module, Boolean> beingVisited)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local modules object as a parameter. You can observe calls to these public
 *  methods in the go methods of UniversityTest.java.  
 */
public class University
{
	private ArrayList<Cohort> cohorts;
	private Graph graph;
	
	public University()
	{
		cohorts = new ArrayList<Cohort>();
		graph = new Graph();
	}
	
	public void clear()
	{
		for (Cohort v : cohorts)
		{
			v.getBtree().clear();
		}
		cohorts.clear();
		graph = new Graph();
	}
	public void addClass(Cohort v)
	{
		cohorts.add(v);
		if (!v.getModule().getPrerequisites().isEmpty()) {
			for (Module m : v.getModule().getPrerequisites()) {
				graph.insertEdge(v.getModule(), m);
			}
		} else {
			graph.insertNode(v.getModule());
		}
	}
	public ArrayList<Cohort> getCohort()
	{
		return cohorts;
	}
	public Graph getGraph()
	{
		return graph;
	}
	public void describeModuleList()
	{
		for (Cohort v : cohorts)
		{
			System.out.println(v.toString());
			v.describeStudentTree();
		}
	}
	
	/**
	 * This method calls the tree walk method for a specific cohort
	 * @param val The index of the cohort that you want to call the method for
	 * @return A String with the names of all Students in the tree
	 */
	public String walkTree(int val)
	{
		return cohorts.get(val).walkTree();
	}
	
	/**
	 * This method calls the find method for a specific cohort
	 * @param val The index of the cohort that you want to call the method for
	 * @return A reference to the Student that was found or null if no Student found
	 */
	public Student find(int val, String name)
	{
		return cohorts.get(val).find(name);
	}
	
	/**
	 * This method calls the protected checkForCycle to find for cycles in the graph.
	 * 
	 * You should not modify this code.
	 */
    public boolean checkForCycles()
    {
    	Map<Module, Boolean> visited = new HashMap<Module, Boolean>();
    	Map<Module, Boolean> beingVisited = new HashMap<Module, Boolean>();
    	for (Module m : graph.getVertices()) {
    		if (checkForCycles(this.graph, m, visited, beingVisited)) {
    	    	return true;
    		}
    	}
    	return false;
    }
    
	/**
	 * This method should find cycles in directed graphs.
	 *
     * @param graph The graph
	 * @param node the current node
	 * @param visited List of visited nodes
	 * @param beingVisited List of nodes being visited
	 * 
 	 * @return true, if there is a cycle, false otherwise
	 */
    protected boolean checkForCycles(Graph graph, Module node, Map<Module, Boolean> visited, Map<Module, Boolean> beingVisited)
    {
    	/*
    	 * TODO
    	 */
        return false;
    }

	/**
	 * This method should use quick sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
	 * @return	The ArrayList 'modules' that has been sorted using insertion sort
	 */
    public ArrayList<Cohort> quickSort(boolean asc, String attr)
    {	
    	ArrayList<Cohort> sorted = new ArrayList<Cohort>(cohorts); // copy of the list
    	return quickSort(sorted, 0, cohorts.size()-1, asc, attr);
    }
    
    /**
	 * This method should use quick sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * @param list The arraylist to be sorted
	 * @param low First index
	 * @param high Last index
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
     * 
	 * @return	The ArrayList 'modules' that has been sorted using insertion sort
	 */
    protected ArrayList<Cohort> quickSort(ArrayList<Cohort> list, int low, int high, boolean ascending, String attr)
    {   	
        /*
         * TODO
         */
    	return list;
    }

}
