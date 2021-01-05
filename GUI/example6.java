// textfield example

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main{
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("TextField Example");
		
		JTextField jTextfield1 = new JTextField("Hey! My heart is broken!!!");
		JTextField jTextField2 = new JTextField("May God fill my heart with purity");
		
		jTextfield1.setBounds(50, 100, 200, 30);
		jTextField2.setBounds(50, 200, 200, 30);
		
		jFrame.add(jTextfield1);
		jFrame.add(jTextField2);
		
		jFrame.setSize(500, 500);
		jFrame.setLayout(null);
		jFrame.setVisible(true);
		
	}
}
