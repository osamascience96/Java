import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Graph - A class that implements a directed graph using adjacency (linked) lists,
 * as explained in Week 6.
 * 
 * ATTENTION: You do NOT need to modify this code at all.
 * 
 */

public class Graph {
	private ArrayList<LinkedList<Module>> adj;  // the adjacency list
	private ArrayList<Module> vertices;  // the list of nodes

	/**
	 * Constructor
	 */
	public Graph() {
		adj = new ArrayList<LinkedList<Module>>();
		vertices = new ArrayList<Module>();
	}
	
	public ArrayList<Module> getVertices() {
		return this.vertices;
	}
	
	/**
	 * Add a node.
	 * @param i The node
	 */
	public void insertNode(Module i) {
		vertices.add(i);
		adj.add(new LinkedList<Module>());
	}
	
	/**
	 * Add an edge to the graph. 
	 * If the starting node does not exist, it is created.
	 *  
	 * @param i Starting node
	 * @param j Ending node
	 */
	public void insertEdge(Module i, Module j) {
		if (vertices.contains(i)) {
			adj.get(vertices.indexOf(i)).add(j);
		} else {
			vertices.add(i);
			adj.add(new LinkedList<Module>(Arrays.asList(j)));
		}
	}
	
	/**
	 * Remove edge. 
	 *  
	 * @param i Starting node
	 * @param j Ending node
	 */
	public void removeEdge(Module i, Module j) {
		if (vertices.contains(i)) {
			adj.get(vertices.indexOf(i)).remove(j);
		}
	}
	
	/**
	 * Get adjacency list of Node i
	 * @param i The node
	 * @return Adjancey list
	 */
	public LinkedList<Module> getAdj(Module i) {
		int index = vertices.indexOf(i);
		if (index != -1) {
			return adj.get(index);
		} else {
			return new LinkedList<Module>();
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < vertices.size(); i++) { 
            s.append(vertices.get(i) + " -> "); 
            for (int j = 0; j < adj.get(i).size(); j++) { 
            	s.append(adj.get(i).get(j) + " -> "); 
            } 
            s.append("\n"); 
        } 
		return s.toString();
	}
}
