package homewrok13;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Double11 {
	JFrame frame;
	JPanel panelName, panelGender, panelAge, panelGrade, panelisBuy, panelProduct, panelMoney, panelPurpose, panelOK;
	JLabel labelName, labelGender, labelAge, labelGrade, labelisBuy, labelProduct, labelMoney, labelPurpose, label_;
	JTextField textName, textAge, textMoneyLow, textMoneyHigh, textPurpose;
	JComboBox<Object> comboxGender, comboxGrade, comboxisBuy;
	JCheckBox checkBoxProduct1, checkBoxProduct2, checkBoxProduct3;
	JButton buttonOK;
	String[] string = new String[100];

	public Double11() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("˫ʮһ�����ʾ�");
		frame.setLayout(new GridLayout(9, 1));
		frame.setSize(500, 800);
		// ����
		panelName = new JPanel();
		labelName = new JLabel("����:");
		textName = new JTextField(10);
		panelName.add(labelName);
		panelName.add(textName);
		frame.add(panelName);
		// �Ա�
		panelGender = new JPanel();
		labelGender = new JLabel("�Ա�:");
		comboxGender = new JComboBox<>();
		comboxGender.addItem("��");
		comboxGender.addItem("Ů");
		panelGender.add(labelGender);
		panelGender.add(comboxGender);
		frame.add(panelGender);
		// ����
		panelAge = new JPanel();
		labelAge = new JLabel("����:");
		textAge = new JTextField(5);
		panelAge.add(labelAge);
		panelAge.add(textAge);
		frame.add(panelAge);
		// �꼶
		panelGrade = new JPanel();
		labelGrade = new JLabel("�꼶:");
		comboxGrade = new JComboBox<>();
		comboxGrade.addItem("��һ");
		comboxGrade.addItem("���");
		comboxGrade.addItem("����");
		panelGrade.add(labelGrade);
		panelGrade.add(comboxGrade);
		frame.add(panelGrade);
		// �Ƿ���
		panelisBuy = new JPanel();
		labelisBuy = new JLabel("�Ƿ���˫ʮһ������Ʒ:");
		comboxisBuy = new JComboBox<Object>();
		comboxisBuy.addItem("��");
		comboxisBuy.addItem("��");
		panelisBuy.add(labelisBuy);
		panelisBuy.add(comboxisBuy);
		frame.add(panelisBuy);
		// ��Ʒ����
		panelProduct = new JPanel();
		labelProduct = new JLabel("�������Ʒ���ࣺ");
		checkBoxProduct1 = new JCheckBox("��ױ����");
		checkBoxProduct2 = new JCheckBox("����ҵ�");
		checkBoxProduct3 = new JCheckBox("�ճ�����");
		panelProduct.add(labelProduct);
		panelProduct.add(checkBoxProduct1);
		panelProduct.add(checkBoxProduct2);
		panelProduct.add(checkBoxProduct3);
		frame.add(panelProduct);
		// Ԥ�㷶Χ
		panelMoney = new JPanel();
		labelMoney = new JLabel("Ԥ�㷶Χ�� ");
		label_ = new JLabel("~");
		textMoneyLow = new JTextField(5);
		textMoneyHigh = new JTextField(5);
		panelMoney.add(labelMoney);
		panelMoney.add(textMoneyLow);
		panelMoney.add(label_);
		panelMoney.add(textMoneyHigh);
		frame.add(panelMoney);
		// ����Ŀ��
		panelPurpose = new JPanel();
		labelPurpose = new JLabel("����Ŀ�ģ�");
		textPurpose = new JTextField(20);
		panelPurpose.add(labelPurpose);
		panelPurpose.add(textPurpose);
		frame.add(panelPurpose);
		// ȷ�ϰ�ť
		panelOK = new JPanel();
		buttonOK = new JButton("ȷ���ύ��Ϣ");
		panelOK.add(buttonOK);
		frame.add(panelOK);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int f = check();
				if (f == 0) {
					// ��Ϣ��������ʾ��
					JOptionPane.showMessageDialog(frame, "��Ϣ������", "��ʾ", JOptionPane.WARNING_MESSAGE);
					System.out.println("123");
				} else {
					// ��Ϣ�б�
					// double11.list();
					System.out.println("��Ϣ�б�");
					method();
				}

			}
		});

	}

	int check() {
		// textName, textAge, textMoneyLow, textMoneyHigh, textPurpose;
		int flag = 1;
		if (textName.getText().equals(""))
			flag = 0;
		if (textAge.getText().equals(""))
			flag = 0;
		if (textMoneyLow.getText().equals(""))
			flag = 0;
		if (textMoneyHigh.getText().equals(""))
			flag = 0;
		if (textPurpose.getText().equals(""))
			flag = 0;
		return flag;
	}

	public void method() {
		frame.removeAll();
		frame = new JFrame("���ĵ����ʾ���");
		frame.setLayout(new GridLayout(9, 1));
		frame.setSize(500, 700);
		// ����
		panelName.remove(textName);
		panelName.add(new JLabel(textName.getText()));
		frame.add(panelName);
		// �Ա�
		panelGender.remove(comboxGender);
		panelGender.add(new JLabel((String) comboxGender.getSelectedItem()));
		frame.add(panelGender);
		// ����
		panelAge.remove(textAge);
		panelAge.add(new JLabel(textAge.getText()));
		frame.add(panelAge);
		// �꼶
		panelGrade.remove(comboxGrade);
		panelGrade.add(new JLabel((String) comboxGrade.getSelectedItem()));
		frame.add(panelGrade);
		// �Ƿ���
		panelisBuy.remove(comboxisBuy);
		panelisBuy.add(new JLabel((String) comboxisBuy.getSelectedItem()));
		frame.add(panelisBuy);
		// ��Ʒ����
		int count = panelProduct.getComponentCount();
		System.out.println("count = " + count);
		String string = "";
		for (int i = 0; i < count; i++)
			if (panelProduct.getComponent(i) instanceof JCheckBox cb) {
				if (cb.isSelected()) {
					string += cb.getText() + " ";
				}
			}
		System.out.println(string);
		panelProduct.remove(checkBoxProduct1);
		panelProduct.remove(checkBoxProduct2);
		panelProduct.remove(checkBoxProduct3);
		panelProduct.add(new JLabel(string));
		frame.add(panelProduct);
		// Ԥ�㷶Χ
		panelMoney.remove(label_);
		panelMoney.remove(textMoneyLow);
		panelMoney.remove(textMoneyHigh);
		panelMoney.add(new JLabel(textMoneyLow.getText() + "~" + textMoneyHigh.getText()));
		frame.add(panelMoney);
		// ����Ŀ��
		panelPurpose.remove(textPurpose);
		panelPurpose.add(new JLabel(textPurpose.getText()));
		frame.add(panelPurpose);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Double11();

	}

}
