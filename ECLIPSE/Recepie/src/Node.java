import java.util.ArrayList;
import java.util.Hashtable;

// This Vertex node is contained inside the graph class
public class Node {
	// making the linear graph
	private Hashtable<String, ArrayList<String>> hashtableData;
	// next vertex
	private Node graphEdge;
	
	// constructor that sets the hash and addess to the next vertex using the graph edge
	public Node(Hashtable<String, ArrayList<String>> hashtableData) {
		// TODO Auto-generated constructor stub
		this.hashtableData = hashtableData;
		this.graphEdge = null;
	}

	// getters and setters of the node
	public Hashtable<String, ArrayList<String>> getHashtableData() {
		return hashtableData;
	}

	public void setHashtableData(Hashtable<String, ArrayList<String>> hashtableData) {
		this.hashtableData = hashtableData;
	}

	public Node getGraphEdge() {
		return graphEdge;
	}

	public void setGraphEdge(Node graphEdge) {
		this.graphEdge = graphEdge;
	}
	
	
}
