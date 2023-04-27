package 上机2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Student implements Serializable {

	private String num;

	private String name;

	private String gender;

	Student(String num, String name, String gender) {

		this.num = num;

		this.name = name;

		this.gender = gender;

	}

	void getInfo() {

		System.out.println("学号: " + num);

		System.out.println("姓名: " + name);

		System.out.println("性别: " + gender);

		System.out.println("-------------------");

	}

}

class myFrame {

	JFrame frame;

	JPanel panel1, panel2, panel3, panel4;

	JLabel labelNum, labelName, labelGender;

	JButton buttonSave, buttonOpen, buttonlast, buttonnext;

	JRadioButton Man, Woman;

	JTextField textName, textNum;

	public int index;
	ArrayList<Student> students = new ArrayList<Student>();

	myFrame() {

		frame = new JFrame("学生信息管理系统");

		frame.setLayout(new GridLayout(4, 1));

		frame.setSize(500, 500);

		// 学号

		panel1 = new JPanel();

		labelNum = new JLabel("学号：");

		textNum = new JTextField(30);

		panel1.add(labelNum);

		panel1.add(textNum);

		frame.add(panel1);

		// 姓名

		panel2 = new JPanel();

		labelName = new JLabel("姓名：");

		textName = new JTextField(30);

		panel2.add(labelName);

		panel2.add(textName);

		frame.add(panel2);

		// 性别

		panel3 = new JPanel();

		labelGender = new JLabel("性别：");

		Man = new JRadioButton("男");

		Woman = new JRadioButton("女");

		ButtonGroup bgroup = new ButtonGroup();

		bgroup.add(Man);

		bgroup.add(Woman);

		panel3.add(labelGender);

		panel3.add(Man);

		panel3.add(Woman);

		frame.add(panel3);

		// 按钮

		panel4 = new JPanel();

		buttonSave = new JButton("保存");

		buttonOpen = new JButton("打开");

		buttonlast = new JButton("上一个学生");

		buttonnext = new JButton("下一个学生");

		panel4.add(buttonSave);

		panel4.add(buttonOpen);

		panel4.add(buttonlast);

		panel4.add(buttonnext);

		frame.add(panel4);

		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonSave.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub

				saveToFile();

				System.out.println("文件保存成功");

			}

		});

		buttonOpen.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub

				openFileChooser();

			}

		});

		buttonlast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				index--;
				lookLast(index);
			}
		});
		buttonnext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				index++;
				lookNext(index);
			}
		});

	}

	protected void lookNext(int index) {
		// TODO Auto-generated method stub
		File datapathFile = new File("data.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
			ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
			Student student = list.get(index - 1);
			student.getInfo();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void lookLast(int index) {
		// TODO Auto-generated method stub
		File datapathFile = new File("data.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
			ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
			Student student = list.get(index - 1);
			student.getInfo();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void saveToFile() {
		String gender = "男";
		if (Man.isSelected()) {

			gender = "男";

		}

		if (Woman.isSelected()) {

			gender = "女";

		}
		students.add(new Student(textNum.getText(), textName.getText(), gender));
		ObjectOutputStream oos;
		File data = new File("data.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(data));
			oos.writeObject(students);
			oos.close();
		} catch (FileNotFoundException e) {

			System.out.println("文件打开失败");

		} catch (IOException e) {

			// TODO: handle exception

			System.out.println("文件输入异常");

		}

	}

	void openFileChooser() {

		JFileChooser chooser = new JFileChooser("D:\\Project\\eclipse\\上机");

		chooser.showOpenDialog(null);

		try {

			File filedata = chooser.getSelectedFile();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filedata));
			ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
			Student student = list.get(list.size() - 1);
			student.getInfo();
			index = list.size();
			ois.close();

		} catch (FileNotFoundException e) {

			System.out.println("文件打开失败");

		} catch (IOException e) {

			// TODO: handle exception

			System.out.println("文件输出异常");

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}

public class Q1 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		new myFrame();

	}
}
