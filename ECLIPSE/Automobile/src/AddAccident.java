import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.Box;
import com.toedter.calendar.JCalendar;

import DatabaseOperations.DataSelection;
import DatabaseOperations.InsertIntoDatabase;
import Models.AgentModel;
import Models.AutoModel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddAccident extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField countryCode;
	private JTextField damages;
	
	private JComboBox vechile_no_box;
	private JComboBox driver_ssn_combo;
	private JCalendar datePickerObj;
	private TextField cityName;
	/**
	 * Create the dialog.
	 */
	public AddAccident() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddAccident.class.getResource("/Images/background.jpg")));
		setTitle("Add Accident");
		setBounds(100, 100, 513, 644);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			Box verticalBox = Box.createVerticalBox();
			contentPanel.add(verticalBox);
			{
				JTextPane txtpnSelectDate = new JTextPane();
				txtpnSelectDate.setEditable(false);
				txtpnSelectDate.setBackground(UIManager.getColor("Button.background"));
				verticalBox.add(txtpnSelectDate);
				txtpnSelectDate.setFont(new Font("SansSerif", Font.PLAIN, 18));
				txtpnSelectDate.setText("Select Date");
			}
			{
				datePickerObj = new JCalendar();
				verticalBox.add(datePickerObj);
			}
			{
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				textPane.setBackground(UIManager.getColor("Button.background"));
				verticalBox.add(textPane);
			}
			{
				JTextPane txtpnEnterCityName = new JTextPane();
				txtpnEnterCityName.setEditable(false);
				txtpnEnterCityName.setBackground(UIManager.getColor("Button.background"));
				txtpnEnterCityName.setFont(new Font("SansSerif", Font.PLAIN, 18));
				txtpnEnterCityName.setText("Enter City Name");
				verticalBox.add(txtpnEnterCityName);
			}
			{
				cityName = new TextField();
				cityName.setFont(new Font("SansSerif", Font.PLAIN, 10));
				verticalBox.add(cityName);
			}
			{
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				textPane.setBackground(UIManager.getColor("Button.background"));
				verticalBox.add(textPane);
			}
			{
				JTextPane txtpnEnterCountryCode = new JTextPane();
				txtpnEnterCountryCode.setEditable(false);
				txtpnEnterCountryCode.setBackground(UIManager.getColor("Button.background"));
				txtpnEnterCountryCode.setFont(new Font("SansSerif", Font.PLAIN, 18));
				txtpnEnterCountryCode.setText("Enter Country Code");
				verticalBox.add(txtpnEnterCountryCode);
			}
			{
				countryCode = new JTextField();
				countryCode.setFont(new Font("SansSerif", Font.PLAIN, 10));
				verticalBox.add(countryCode);
				countryCode.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsertDataintoDatabase();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// close the dialog 
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			Box horizontalBox = Box.createHorizontalBox();
			getContentPane().add(horizontalBox, BorderLayout.CENTER);
			{
				Box verticalBox = Box.createVerticalBox();
				horizontalBox.add(verticalBox);
				{
					JLabel lblNewLabel = new JLabel("Vechile No.");
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
					verticalBox.add(lblNewLabel);
				}
				{
					vechile_no_box = new JComboBox();
					vechile_no_box.setEditable(true);
					verticalBox.add(vechile_no_box);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
			}
			{
				Box verticalBox = Box.createVerticalBox();
				horizontalBox.add(verticalBox);
				{
					JLabel lblNewLabel = new JLabel("Damages");
					verticalBox.add(lblNewLabel);
					lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
				}
				{
					damages = new JTextField();
					damages.setAlignmentY(Component.TOP_ALIGNMENT);
					verticalBox.add(damages);
					damages.setColumns(7);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
			}
			{
				Box verticalBox = Box.createVerticalBox();
				horizontalBox.add(verticalBox);
				{
					JLabel lblDrivenSsn = new JLabel("Driven SSN");
					lblDrivenSsn.setHorizontalAlignment(SwingConstants.CENTER);
					lblDrivenSsn.setFont(new Font("SansSerif", Font.PLAIN, 19));
					verticalBox.add(lblDrivenSsn);
				}
				{
					driver_ssn_combo = new JComboBox();
					driver_ssn_combo.setEditable(true);
					verticalBox.add(driver_ssn_combo);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					verticalBox.add(textPane);
				}
			}
		}
		
		setComboBoxes();
	}
	
	
	// set all the combo boxes
	private void setComboBoxes() {
		DataSelection dataSelectionObj = new DataSelection();
		
		//populate the vin combobox
		for(AutoModel autoModel: dataSelectionObj.GetAllAutosFromDatabase()) {
			vechile_no_box.addItem(autoModel.GetVechileIdentityNo());
		}
		
		// populate the driver_ssn_combo boxe
		for(AgentModel agentModel: dataSelectionObj.GetAllAgentsFromDatabase()) {
			driver_ssn_combo.addItem(agentModel.GETSSN());
		}
	}
	
	// Insert the data in database
	private void InsertDataintoDatabase() {
		InsertIntoDatabase inserttoDatabase = new InsertIntoDatabase();
		Date date = datePickerObj.getDate();
		inserttoDatabase.InsertOperation(String.format("%1$tY-%1$tm-%1$td", date), cityName.getText().toString(), countryCode.getText().toString(), vechile_no_box.getSelectedItem().toString(), Double.parseDouble(damages.getText().toString()), driver_ssn_combo.getSelectedItem().toString());
	}

}
