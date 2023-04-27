package Q2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Event1 implements ActionListener {
	JFrame frame;
	JButton button1, button2;

	public Event1() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("十二次作业一");
		frame.setLayout(new GridLayout(2, 1, 50, 50));
		frame.setSize(500, 500);
		button1 = new JButton("确定");
		button2 = new JButton("取消");
		frame.add(button1);
		frame.add(button2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("确定")) {
			button1.setText("取消");
			button2.setText("确定");
		} else if (e.getActionCommand().equals("取消")) {
			button2.setText("取消");
			button1.setText("确定");
		}
	}

}

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Event1();
	}

}
