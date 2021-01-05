// Add and Subtract Program GUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main{
	public static void main(String[] args) {
		AddSubInterface addSubInterfaceObj = new AddSubInterface();
		addSubInterfaceObj.SetInterfaceReady();
	}
}

class AddSubInterface extends JFrame{
	private JFrame jFrame = null;
	private JTextField operand1 = null;
	private JTextField operand2 = null;
	private JTextField resutlField = null;
	private JButton plusOperator = null;
	private JButton subtractOperator = null;
	
	public AddSubInterface() {
		// TODO Auto-generated constructor stub
		jFrame = new JFrame("Add and Subtract");
		operand1 = new JTextField();
		operand2 = new JTextField();
		resutlField = new JTextField();
		plusOperator = new JButton("+");
		subtractOperator = new JButton("-");
		
		ConfigureInterface();
	}
	
	private void ConfigureInterface() {
		operand1.setBounds(50, 100, 100, 20);
		operand2.setBounds(200, 100, 100, 20);
		resutlField.setBounds(120, 150, 100, 20);
		resutlField.setEnabled(false);
		plusOperator.setBounds(50, 200, 50, 30);
		subtractOperator.setBounds(150, 200, 50, 30);
		
		ConfigureOperations();
		
		// add all the components to the jframe
		jFrame.add(operand1);
		jFrame.add(operand2);
		jFrame.add(resutlField);
		jFrame.add(plusOperator);
		jFrame.add(subtractOperator);
	}
	
	private void ConfigureOperations() {
		plusOperator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int op1 = Integer.parseInt(operand1.getText().toString().isEmpty() == false ? operand1.getText().toString() : "0");
				int op2 = Integer.parseInt(operand2.getText().toString().isEmpty() == false ? operand2.getText().toString() : "0");
				
				String result = PerformOperation(op1, op2, '+');
				resutlField.setText(result);
			}
		});
		
		subtractOperator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int op1 = Integer.parseInt(operand1.getText().toString().isEmpty() == false ? operand1.getText().toString() : "0");
				int op2 = Integer.parseInt(operand2.getText().toString().isEmpty() == false ? operand2.getText().toString() : "0");
				
				String result = PerformOperation(op1, op2, '-');
				resutlField.setText(result);
			}
		});
	}
	
	private String PerformOperation(int a, int b, char type) {
		String result = "";
		if (type == '+') {
			result = String.valueOf(a + b);
		}else {
			result = String.valueOf(a - b);
		}
		return result;
	}
	
	public void SetInterfaceReady() {
		jFrame.setSize(500, 500);
		jFrame.setLayout(null);
		jFrame.setVisible(true);
	}
}
