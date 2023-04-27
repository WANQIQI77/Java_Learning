package homework12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//本类
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
			frame.setTitle("单击了确定按钮");
		} else if (e.getActionCommand().equals("取消")) {
			frame.setTitle("单击了取消按钮");
		}
	}

}

//外部类
class buttonEvent implements ActionListener {
	Event2 event2;

	public buttonEvent(Event2 event2) {
		// TODO Auto-generated constructor stub
		this.event2 = event2;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == event2.button1) {
			this.event2.getFrame().setTitle("单击了确定按钮");
		} else if (e.getSource() == event2.button2) {
			this.event2.getFrame().setTitle("单击了取消按钮");
		}
	}
}

class Event2 {
	JFrame frame;
	JButton button1, button2;

	public Event2() {
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
		button1.addActionListener(new buttonEvent(this));
		button2.addActionListener(new buttonEvent(this));
	}

	JFrame getFrame() {
		return frame;
	}

}

//内部类
class Event3 {
	JFrame frame;
	JButton button1, button2;

	public Event3() {
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
				frame.setTitle("单击了确定按钮");
			} else if (e.getSource() == button2) {
				frame.setTitle("单击了取消按钮");
			}
		}
	}

}

//匿名类
class Event4 {
	JFrame frame;
	JButton button1, button2;

	public Event4() {
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
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setTitle("单击了确定按钮");
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setTitle("单击了取消按钮");
			}
		});
	}

}

//lambda表达式
class Event5 {
	JFrame frame;
	JButton button1, button2;

	public Event5() {
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
		button1.addActionListener(e -> frame.setTitle("单击了确定按钮"));
		button2.addActionListener(e -> frame.setTitle("单击了取消按钮"));
	}

}

public class Q1 {

	public static void main(String[] args) {
		new Event5();
	}

}
