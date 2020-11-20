import javax.swing.JOptionPane;

public class Main{
	public static void main(String []args){		
		// take the input 1 
		int firstNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the first Integer"));
		// take the input 2
		int secondNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the second Integer"));
		
		// Calculate the sum 
		int sum = firstNumber + secondNumber;
		
		// display the result 
		// the null parameter indicates the position to be center on the screen
		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of two Integers", JOptionPane.PLAIN_MESSAGE);
	}
}