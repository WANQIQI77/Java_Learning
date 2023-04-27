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
		frame = new JFrame("ʮ������ҵһ");
		frame.setLayout(new GridLayout(2, 1, 50, 50));
		frame.setSize(500, 500);
		button1 = new JButton("ȷ��");
		button2 = new JButton("ȡ��");
		frame.add(button1);
		frame.add(button2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ȷ��")) {
			button1.setText("ȡ��");
			button2.setText("ȷ��");
		} else if (e.getActionCommand().equals("ȡ��")) {
			button2.setText("ȡ��");
			button1.setText("ȷ��");
		}
	}

}

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Event1();
	}

}
