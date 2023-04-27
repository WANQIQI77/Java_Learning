package homework12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//����
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
			frame.setTitle("������ȷ����ť");
		} else if (e.getActionCommand().equals("ȡ��")) {
			frame.setTitle("������ȡ����ť");
		}
	}

}

//�ⲿ��
class buttonEvent implements ActionListener {
	Event2 event2;

	public buttonEvent(Event2 event2) {
		// TODO Auto-generated constructor stub
		this.event2 = event2;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == event2.button1) {
			this.event2.getFrame().setTitle("������ȷ����ť");
		} else if (e.getSource() == event2.button2) {
			this.event2.getFrame().setTitle("������ȡ����ť");
		}
	}
}

class Event2 {
	JFrame frame;
	JButton button1, button2;

	public Event2() {
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
		button1.addActionListener(new buttonEvent(this));
		button2.addActionListener(new buttonEvent(this));
	}

	JFrame getFrame() {
		return frame;
	}

}

//�ڲ���
class Event3 {
	JFrame frame;
	JButton button1, button2;

	public Event3() {
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
		button1.addActionListener(new buttonEvent(button1));
		button2.addActionListener(new buttonEvent(button2));
	}

	class buttonEvent implements ActionListener {

		JButton button;

		public buttonEvent(JButton button) {
			// TODO Auto-generated constructor stub
			this.button = button;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				frame.setTitle("������ȷ����ť");
			} else if (e.getSource() == button2) {
				frame.setTitle("������ȡ����ť");
			}
		}
	}

}

//������
class Event4 {
	JFrame frame;
	JButton button1, button2;

	public Event4() {
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
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setTitle("������ȷ����ť");
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setTitle("������ȡ����ť");
			}
		});
	}

}

//lambda���ʽ
class Event5 {
	JFrame frame;
	JButton button1, button2;

	public Event5() {
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
		button1.addActionListener(e -> frame.setTitle("������ȷ����ť"));
		button2.addActionListener(e -> frame.setTitle("������ȡ����ť"));
	}

}

public class Q1 {

	public static void main(String[] args) {
		new Event5();
	}

}
