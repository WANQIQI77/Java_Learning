package �ϻ�2;

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

		System.out.println("ѧ��: " + num);

		System.out.println("����: " + name);

		System.out.println("�Ա�: " + gender);

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

		frame = new JFrame("ѧ����Ϣ����ϵͳ");

		frame.setLayout(new GridLayout(4, 1));

		frame.setSize(500, 500);

		// ѧ��

		panel1 = new JPanel();

		labelNum = new JLabel("ѧ�ţ�");

		textNum = new JTextField(30);

		panel1.add(labelNum);

		panel1.add(textNum);

		frame.add(panel1);

		// ����

		panel2 = new JPanel();

		labelName = new JLabel("������");

		textName = new JTextField(30);

		panel2.add(labelName);

		panel2.add(textName);

		frame.add(panel2);

		// �Ա�

		panel3 = new JPanel();

		labelGender = new JLabel("�Ա�");

		Man = new JRadioButton("��");

		Woman = new JRadioButton("Ů");

		ButtonGroup bgroup = new ButtonGroup();

		bgroup.add(Man);

		bgroup.add(Woman);

		panel3.add(labelGender);

		panel3.add(Man);

		panel3.add(Woman);

		frame.add(panel3);

		// ��ť

		panel4 = new JPanel();

		buttonSave = new JButton("����");

		buttonOpen = new JButton("��");

		buttonlast = new JButton("��һ��ѧ��");

		buttonnext = new JButton("��һ��ѧ��");

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

				System.out.println("�ļ�����ɹ�");

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
		String gender = "��";
		if (Man.isSelected()) {

			gender = "��";

		}

		if (Woman.isSelected()) {

			gender = "Ů";

		}
		students.add(new Student(textNum.getText(), textName.getText(), gender));
		ObjectOutputStream oos;
		File data = new File("data.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(data));
			oos.writeObject(students);
			oos.close();
		} catch (FileNotFoundException e) {

			System.out.println("�ļ���ʧ��");

		} catch (IOException e) {

			// TODO: handle exception

			System.out.println("�ļ������쳣");

		}

	}

	void openFileChooser() {

		JFileChooser chooser = new JFileChooser("D:\\Project\\eclipse\\�ϻ�");

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

			System.out.println("�ļ���ʧ��");

		} catch (IOException e) {

			// TODO: handle exception

			System.out.println("�ļ�����쳣");

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
