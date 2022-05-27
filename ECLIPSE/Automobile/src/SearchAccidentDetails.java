import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;

import DatabaseOperations.DataSelection;
import Models.AccidentModel;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;

public class SearchAccidentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField avgDangersTxtField;
	private JTextField totalDangerTxtField;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public SearchAccidentDetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchAccidentDetails.class.getResource("/Images/background.jpg")));
		setTitle("Search Accident");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		horizontalBox.add(lblNewLabel);
		
		JCalendar calendar = new JCalendar();
		horizontalBox.add(calendar);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setText("                            ");
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("SansSerif", Font.PLAIN, 19));
		horizontalBox.add(lblEndDate);
		
		JCalendar calendar_1 = new JCalendar();
		horizontalBox.add(calendar_1);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Accident Id");
		model.addColumn("Location");
		model.addColumn("State Code");
		table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		
		calendar_1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				Date date = calendar.getDate();
				String startDate = String.format("%1$tY-%1$tm-%1$td", date);
				date = calendar_1.getDate();
				String endDate = String.format("%1$tY-%1$tm-%1$td", date);
				
				for (AccidentModel accidentModel: new DataSelection().GetAllAccidentFromDatabaseInDateRange(startDate, endDate)) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.addRow(new Object[] {accidentModel.GetAccidentId(), accidentModel.GetCity(), accidentModel.GetState()});
				}
			}
			
		});
	}

}
