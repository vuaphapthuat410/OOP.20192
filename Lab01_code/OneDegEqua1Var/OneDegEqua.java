import javax.swing.JOptionPane;
import java.lang.Float;

public class OneDegEqua {
	public static void main(String args[]){
		String strNum1, strNum2;
		float num1, num2, sum;
		String sol;
		strNum1 = JOptionPane.showInputDialog(null,
					"Please input the first coefficient a: ", "Input the a",
					JOptionPane.INFORMATION_MESSAGE);

		strNum2 = JOptionPane.showInputDialog(null,
					"Please input the second coefficient b ", "Input the b",
					JOptionPane.INFORMATION_MESSAGE);

		num1 = Float.valueOf(strNum1);
		num2 = Float.valueOf(strNum2);

		if(num1 == 0) 
		{
			JOptionPane.showMessageDialog(null,"Error: a cannot be 0. Divide cannot perform.","Error 1", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		sum = -num2/num1;
		sol = "The unique solution is : " + Float.toString(sum);
		JOptionPane.showMessageDialog(null,sol,"Solution", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}