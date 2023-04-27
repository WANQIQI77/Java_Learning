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
		frame = new JFrame("双十一调查问卷");
		frame.setLayout(new GridLayout(9, 1));
		frame.setSize(500, 800);
		// 姓名
		panelName = new JPanel();
		labelName = new JLabel("姓名:");
		textName = new JTextField(10);
		panelName.add(labelName);
		panelName.add(textName);
		frame.add(panelName);
		// 性别
		panelGender = new JPanel();
		labelGender = new JLabel("性别:");
		comboxGender = new JComboBox<>();
		comboxGender.addItem("男");
		comboxGender.addItem("女");
		panelGender.add(labelGender);
		panelGender.add(comboxGender);
		frame.add(panelGender);
		// 年龄
		panelAge = new JPanel();
		labelAge = new JLabel("年龄:");
		textAge = new JTextField(5);
		panelAge.add(labelAge);
		panelAge.add(textAge);
		frame.add(panelAge);
		// 年级
		panelGrade = new JPanel();
		labelGrade = new JLabel("年级:");
		comboxGrade = new JComboBox<>();
		comboxGrade.addItem("大一");
		comboxGrade.addItem("大二");
		comboxGrade.addItem("大三");
		panelGrade.add(labelGrade);
		panelGrade.add(comboxGrade);
		frame.add(panelGrade);
		// 是否购物
		panelisBuy = new JPanel();
		labelisBuy = new JLabel("是否在双十一购买物品:");
		comboxisBuy = new JComboBox<Object>();
		comboxisBuy.addItem("是");
		comboxisBuy.addItem("否");
		panelisBuy.add(labelisBuy);
		panelisBuy.add(comboxisBuy);
		frame.add(panelisBuy);
		// 商品种类
		panelProduct = new JPanel();
		labelProduct = new JLabel("购买的商品种类：");
		checkBoxProduct1 = new JCheckBox("美妆服饰");
		checkBoxProduct2 = new JCheckBox("数码家电");
		checkBoxProduct3 = new JCheckBox("日常生活");
		panelProduct.add(labelProduct);
		panelProduct.add(checkBoxProduct1);
		panelProduct.add(checkBoxProduct2);
		panelProduct.add(checkBoxProduct3);
		frame.add(panelProduct);
		// 预算范围
		panelMoney = new JPanel();
		labelMoney = new JLabel("预算范围： ");
		label_ = new JLabel("~");
		textMoneyLow = new JTextField(5);
		textMoneyHigh = new JTextField(5);
		panelMoney.add(labelMoney);
		panelMoney.add(textMoneyLow);
		panelMoney.add(label_);
		panelMoney.add(textMoneyHigh);
		frame.add(panelMoney);
		// 购物目的
		panelPurpose = new JPanel();
		labelPurpose = new JLabel("购物目的：");
		textPurpose = new JTextField(20);
		panelPurpose.add(labelPurpose);
		panelPurpose.add(textPurpose);
		frame.add(panelPurpose);
		// 确认按钮
		panelOK = new JPanel();
		buttonOK = new JButton("确定提交信息");
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
					// 信息不完整提示框
					JOptionPane.showMessageDialog(frame, "信息不完整", "提示", JOptionPane.WARNING_MESSAGE);
					System.out.println("123");
				} else {
					// 信息列表
					// double11.list();
					System.out.println("信息列表");
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
		frame = new JFrame("您的调查问卷结果");
		frame.setLayout(new GridLayout(9, 1));
		frame.setSize(500, 700);
		// 姓名
		panelName.remove(textName);
		panelName.add(new JLabel(textName.getText()));
		frame.add(panelName);
		// 性别
		panelGender.remove(comboxGender);
		panelGender.add(new JLabel((String) comboxGender.getSelectedItem()));
		frame.add(panelGender);
		// 年龄
		panelAge.remove(textAge);
		panelAge.add(new JLabel(textAge.getText()));
		frame.add(panelAge);
		// 年级
		panelGrade.remove(comboxGrade);
		panelGrade.add(new JLabel((String) comboxGrade.getSelectedItem()));
		frame.add(panelGrade);
		// 是否购物
		panelisBuy.remove(comboxisBuy);
		panelisBuy.add(new JLabel((String) comboxisBuy.getSelectedItem()));
		frame.add(panelisBuy);
		// 商品种类
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
		// 预算范围
		panelMoney.remove(label_);
		panelMoney.remove(textMoneyLow);
		panelMoney.remove(textMoneyHigh);
		panelMoney.add(new JLabel(textMoneyLow.getText() + "~" + textMoneyHigh.getText()));
		frame.add(panelMoney);
		// 购物目的
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
