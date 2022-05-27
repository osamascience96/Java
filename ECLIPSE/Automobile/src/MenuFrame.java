import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class MenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuFrame.class.getResource("/Images/background.jpg")));
		setForeground(Color.WHITE);
		setTitle("AutoMobile Record System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSelectOptions = new JLabel("Select Options");
		lblSelectOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectOptions.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblSelectOptions.setForeground(Color.WHITE);
		contentPane.add(lblSelectOptions, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(500, 500));
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(verticalBox);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBackground(UIManager.getColor("Button.focus"));
		verticalBox.add(textPane_2);
		
		JButton btnAddAccident = new JButton("Add Accident");
		btnAddAccident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccident dialog = new AddAccident();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		verticalBox.add(btnAddAccident);
		btnAddAccident.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnAddAccident.setForeground(Color.BLACK);
		btnAddAccident.setBackground(Color.WHITE);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(UIManager.getColor("Button.focus"));
		textPane.setSelectedTextColor(UIManager.getColor("Button.focus"));
		verticalBox.add(textPane);
		
		JButton btnAccidentDetails = new JButton("Accident Details");
		btnAccidentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindAccident frame = new FindAccident();
				frame.setVisible(true);
			}
		});
		btnAccidentDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		verticalBox.add(btnAccidentDetails);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(UIManager.getColor("Button.focus"));
		verticalBox.add(textPane_1);
		
		JButton btnSearchAccident = new JButton("Search Accidents");
		btnSearchAccident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchAccidentDetails frame = new SearchAccidentDetails();
				frame.setVisible(true);
			}
		});
		btnSearchAccident.setFont(new Font("SansSerif", Font.BOLD, 20));
		verticalBox.add(btnSearchAccident);
	}

}
