// ip address of the website
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main{
	public static void main(String[] args) {
		new LabelInterface();
	}
}

class LabelInterface extends JFrame{
	private JTextField textField;
	private JLabel label;
	private JButton button;
	
	public LabelInterface() {
		// TODO Auto-generated constructor stub
		textField = new JTextField();
		label = new JLabel();
		button = new JButton("Find IP");
		
		textField.setBounds(50, 50, 150, 20);
		label.setBounds(50, 100, 250, 20);
		button.setBounds(50, 150, 95, 30);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String host = textField.getText();
				try {
					String ipAddress = InetAddress.getByName(host).getHostAddress();
					label.setText("IP of " + host + " is: " + ipAddress);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		add(textField);
		add(label);
		add(button);
		
		setSize(500, 500);
		
		setLayout(null);
		setVisible(true);
	}
}


