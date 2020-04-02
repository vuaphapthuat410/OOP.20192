import javax.swing.JOptionPane;
import java.lang.Double;
import java.lang.Math;

public class TwoDegEqua {
	public static void main(String args[]){
		String strA, strB, strC;
		double a, b, c, delta, x1, x2;
		String sol;
		strA = JOptionPane.showInputDialog(null,
					"Please input the first coefficient a: ", "Input the a",
					JOptionPane.INFORMATION_MESSAGE);

		strB = JOptionPane.showInputDialog(null,
					"Please input the second coefficient b ", "Input the b",
					JOptionPane.INFORMATION_MESSAGE);
		strC = JOptionPane.showInputDialog(null,
					"Please input the first coefficient c: ", "Input the c",
					JOptionPane.INFORMATION_MESSAGE);

		a = Double.valueOf(strA);
		b = Double.valueOf(strB);
		c = Double.valueOf(strC);

		if(a == 0) {
			if(b == 0) 
			{
				JOptionPane.showMessageDialog(null,"Error: a and b cannot be 0 together.","Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			else {
				sol = "The unique solution is : " + Double.toString(-c/b);
				JOptionPane.showMessageDialog(null,sol,"Solution", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);			
			}
		}
		else {
			delta = b*b - 4*a*c;
			if(delta < 0) {
				JOptionPane.showMessageDialog(null,"NO solution.","Solution", JOptionPane.INFORMATION_MESSAGE);
				System.exit(2);
			}
			if(delta == 0 ){
				x1 = -b/(2*a);
				sol = "The unique solution is x1 = x2 = " + Double.toString(x1) + ".";
				JOptionPane.showMessageDialog(null,sol,"Solution", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			else if(delta  > 0){
				x1 = (-b + Math.sqrt(delta))/(2*a);
				x2 = (-b - Math.sqrt(delta))/(2*a);
				sol = "The unique solution is (x1,x2) = (" + Double.toString(x1) + "," + Double.toString(x2) + ").";
				JOptionPane.showMessageDialog(null,sol,"Solution", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		} 
	}
}