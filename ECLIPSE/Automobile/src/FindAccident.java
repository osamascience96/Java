import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DatabaseOperations.DataSelection;
import Models.AccidentModel;

import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FindAccident extends JFrame {

	private JPanel contentPane;
	private JComboBox accidentId;
	private JTable accidentUserTable;

	/**
	 * Create the frame.
	 */
	public FindAccident() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, BorderLayout.NORTH);
		
		JTextPane txtpnEnterAccidentId = new JTextPane();
		txtpnEnterAccidentId.setEditable(false);
		txtpnEnterAccidentId.setText("Enter Accident Id");
		txtpnEnterAccidentId.setBackground(UIManager.getColor("Button.background"));
		txtpnEnterAccidentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horizontalBox.add(txtpnEnterAccidentId);
		
		String cols[] = {"AccidentId", "city", "state", "accident_date", "InvAid", "vin", "damages", "driver_ssn"};
		String data[][] = {new DataSelection().GetAllGeneralAccidentFromDatabase(1)};
		
		DefaultTableModel tableModel = new DefaultTableModel(data, cols);
		accidentUserTable = new JTable(tableModel);
		add(new JScrollPane(accidentUserTable));
		
		
		accidentId = new JComboBox();
		accidentId.setEditable(true);
		
		horizontalBox.add(accidentId);
		
		
		contentPane.add(new JScrollPane(accidentUserTable), BorderLayout.CENTER);
		
		SetAccidentIdCombobox();
		
		// on selecting comboxbox
		accidentId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel)accidentUserTable.getModel();
				model.addRow(new DataSelection().GetAllGeneralAccidentFromDatabase(Integer.parseInt(accidentId.getSelectedItem().toString())));
			}
		});
	}
	
	private void SetAccidentIdCombobox() {
		DataSelection dataSelection = new DataSelection();
		for(AccidentModel accidentModel: dataSelection.GetAllAccidentFromDatabase()) {
			accidentId.addItem(accidentModel.GetAccidentId());
		}
	}

}
