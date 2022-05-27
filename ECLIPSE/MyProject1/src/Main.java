import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main{
	public static void main(String []args){
		//creating the instance of the Jrame
		JFrame jframe = new JFrame();
		
		// Button
		JButton button = new JButton("Click Me!");
		// set bounds to the button x, y, width, height
		button.setBounds(50, 50, 100, 100);
		
		// adding the button in Jframe
		jframe.add(button);
		// set the size of the frame width 500 and height 500
		jframe.setSize(500, 500);
		
		jframe.setLayout(null);
		jframe.setVisible(false);
	}
}