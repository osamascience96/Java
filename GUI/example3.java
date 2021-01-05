// Program to write the button 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jFrame = new JFrame("Button Example");
		
		// embedded the title on the button
		//JButton button = new JButton("Click Me!");
		
		
		//Adding the image button
		URL url = null;
		BufferedImage bufferedImg = null;
		try {
			url = new URL("https://www.businessupturn.com/wp-content/uploads/2020/05/Sunny-Leone-bikini-Photo.jpg");
			bufferedImg = ImageIO.read(url);
		}catch(Exception e) {
			e.printStackTrace();
		}
		JButton button = new JButton(new ImageIcon(bufferedImg));
		
		button.setBounds(10, 10, 600, 600);
		
		// add the action listener
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Fuck You in the Ass", "Fuck You", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		jFrame.add(button);
		jFrame.setSize(700, 700);
		jFrame.setLayout(null);
		jFrame.setVisible(true);
	}
}

