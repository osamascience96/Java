import java.util.Stack;

// Stack which is LIFO data structure
public class main {

	public static void main(String[] args){
		 Stack<String> notifications = new Stack<String>();
		 
		 // pushes the item into the stack 
		 notifications.push("Facebook: Girlfriend Msg");
		 notifications.push("Whatsapp: Group Message");
		 notifications.push("Quora: New Topic on the fire");
		 
		 // pop the last item from the stack 
		 System.out.println(notifications.pop());
		 System.out.println(notifications);// object removed
		 
		 // returns the object at the top without removing it from Stack
		 System.out.println(notifications.peek());
		 System.out.println(notifications); // object not removed
		 
		 // checks if the list is empty
		 System.out.println(notifications.empty()); // false in this case
		 
		 System.out.println(notifications.search("Whatsapp: Group Message")); // 1 in this case
		 
	}
}
