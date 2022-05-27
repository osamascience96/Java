import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
	// The Node(vertex) is contained inside the graph class.
	// static instance of the startnode so that it becomes same for all the instances across all the translation unit
	private static Node startNode;
	
	// inserting the data in the linear graph
	protected void InsertVertex(Hashtable<String, ArrayList<String>> hashtable) {
		if(startNode != null) {
			Node tempVertex = startNode;
			// loop though the end of the vertex
			while(tempVertex.getGraphEdge() != null) {
				tempVertex = tempVertex.getGraphEdge();
			}
			// init the new node(vertex) instance to the recent graph edge
			// consider the following diagram of the linear graph
			// eg *---->*----->*---->*---...
			tempVertex.setGraphEdge(new Node(hashtable));
		}else {
			// if the startnode is null then init the start node with the new vertex instance
			startNode = new Node(hashtable);
		}
	}
	
	
	// show the tranversal of the linear graph that returns the hashtable to each recepie.
	public static void showTraversal() {
		if(startNode != null) {
			Node startVertex = startNode;
			System.out.println("The output also contains the suggestions");
			System.out.println("You can cook the following:-");
			// traversing through all the vertex of the linear graph.
			while(startVertex != null) {
				System.out.println(startVertex.getHashtableData());
				startVertex = startVertex.getGraphEdge();
			}
		}else {
			System.out.println("No Data available");
		}
	}
	
	// return the startnode that contains the data 
	public static Node GETGRAPHNODE() {
		return startNode;
	}
	
}
