import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main{
	
	static Iterator func(ArrayList mylist) {
		Iterator it = mylist.iterator();
		while(it.hasNext()) {
			Object element = it.next();
			if (element.equals("###")) {
				break;
			}
		}
		
		return it;
	}
	
	public static void main(String []args){		
		ArrayList<Object> mylist = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			mylist.add(sc.next());
		}
		
		mylist.add("###");
		
		for (int j=0; j<m; j++) {
			mylist.add(sc.next());
		}
		
		Iterator it = func(mylist);
		while(it.hasNext()) {
			Object element = it.next();
			System.out.println(element.toString());
		}
	}
}