package homework11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class Question1 {
	private JFrame frame;
	private JButton button1, button2, button3, button4, button5;

	public Question1() {
		frame = new JFrame("作业一");
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 400);
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		frame.add(button5);
		frame.add(button4);
		frame.add(button3);
		frame.add(button2);
		frame.add(button1);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Question2 {
	private JFrame frame;
	private JButton button1, button2, button3, button4, button5;

	public Question2() {
		frame = new JFrame("作业二");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		frame.add(BorderLayout.WEST, button5);
		frame.add(BorderLayout.EAST, button4);
		frame.add(BorderLayout.SOUTH, button3);
		frame.add(BorderLayout.NORTH, button2);
		frame.add(BorderLayout.CENTER, button1);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Question1();
		new Question2();

	}

}
