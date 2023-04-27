package homework11;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame {
	JFrame frame;
	JPanel panel1, panel2, panel3, panel4;

	public MyFrame() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("×÷Òµ¶þ");
		frame.setLayout(new GridLayout());
		frame.setSize(400, 400);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel1.setBackground(new Color(100, 100, 100));
		panel2.setBackground(new Color(255, 10, 0));
		panel3.setBackground(new Color(0, 20, 200));
		panel4.setBackground(new Color(10, 0, 0));
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
