import java.util.Queue;
import java.util.LinkedList;

// Queue which is FIFO data structure
public class main {

	public static void main(String[] args){
		 Queue<String> queue = new LinkedList<String>();
		 queue.add("Order1");
		 queue.add("Order2");
		 queue.add("Order3");
		 
		 System.out.println(queue); // dislays the queue
		 
		 System.out.println(queue.poll()); // reterives and removes in FIFO order
		 
		 System.out.println(queue);
		 
	}
}
