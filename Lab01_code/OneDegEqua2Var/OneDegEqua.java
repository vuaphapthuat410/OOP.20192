import javax.swing.JOptionPane;
import java.lang.Float;

public class OneDegEqua {
	public static void main(String args[]){
		String strA11, strA12, strA21, strA22, strB1, strB2;
		float a11, a12, a21, a22, b1, b2, d, d1, d2, x1, x2;
		String sol;
		strA11 = JOptionPane.showInputDialog(null,
					"Please input the first coefficient a11: ", "Input the a11",
					JOptionPane.INFORMATION_MESSAGE);

		strA12 = JOptionPane.showInputDialog(null,
					"Please input the second coefficient a12 ", "Input the a12",
					JOptionPane.INFORMATION_MESSAGE);
		strB1 = JOptionPane.showInputDialog(null,
					"Please input the first coefficient b1: ", "Input the b1",
					JOptionPane.INFORMATION_MESSAGE);

		strA21 = JOptionPane.showInputDialog(null,
					"Please input the second coefficient a21 ", "Input the a21",
					JOptionPane.INFORMATION_MESSAGE);
		strA22 = JOptionPane.showInputDialog(null,
					"Please input the first coefficient a22: ", "Input the a22",
					JOptionPane.INFORMATION_MESSAGE);

		strB2 = JOptionPane.showInputDialog(null,
					"Please input the second coefficient b2 ", "Input the b2",
					JOptionPane.INFORMATION_MESSAGE);

		a11 = Float.valueOf(strA11);
		a12 = Float.valueOf(strA12);
		a21 = Float.valueOf(strA21);
		a22 = Float.valueOf(strA22);
		b1 = Float.valueOf(strB1);
		b2 = Float.valueOf(strB2);

		d = a11*a22 - a21*a12;
		d1 = b1*a22 - b2*a12;
		d2 = a11*b2 - a21*b1; 
		if(d == 0) {
			if(d == d1 && d1 == d2 && d == 0) {
				JOptionPane.showMessageDialog(null,"Infinitive solutions.","Solution", JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
			}
			else {
				JOptionPane.showMessageDialog(null,"No solution.","Solution", JOptionPane.ERROR_MESSAGE);
				System.exit(2);
			}
		}
		else {
			x1 = d1/d;
			x2 = d2/d;
			sol = "The unique solution is (x1,x2) = (" + Float.toString(x1) + "," + Float.toString(x2) + ").";
			JOptionPane.showMessageDialog(null,sol,"Solution", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} 
	}
}