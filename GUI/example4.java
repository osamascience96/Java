// label sample example 
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main{
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Show IP");
		JLabel l1, l2;
		l1 = new JLabel("First Label:");
		l2 = new JLabel("Second Label");
		l1.setBounds(50, 50, 100, 30);
		l2.setBounds(50, 100, 100, 30);
		
		jFrame.add(l1);
		jFrame.add(l2);
		
		jFrame.setSize(300, 300);
		
		jFrame.setLayout(null);
		jFrame.setVisible(true);
	}
}

