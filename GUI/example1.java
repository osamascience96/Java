import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Simple();
	}
}

class Simple{
	private JFrame jframe = null;
	
	Simple(){
		//creating the instance of the Jrame
		jframe = new JFrame();
						
		// Button
		JButton button = new JButton("Click Me!");
		// set bounds to the button x, y, width, height
		button.setBounds(50, 50, 100, 100);
						
		// adding the button in Jframe
		jframe.add(button);
		// set the size of the frame width 500 and height 500
		jframe.setSize(500, 500);
						
		jframe.setLayout(null);
		jframe.setVisible(true);
	}
}


