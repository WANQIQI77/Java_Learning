package homework17;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Pipe.SourceChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;
/*1�������ݿ�������һ�ű��е�������JTable����ʾ��
2��������Ʊ������ɾ���Ĳ�����ʽ���������Ӧ�Ĺ��ܡ�*/
class myFrame implements ActionListener{
	JFrame frame;
	DefaultTableModel tableModel;
	JTable table;
	Vector vdata=new Vector<>();
	Vector vcolumn=new Vector<>();
	Connection conn=null;
	java.sql.Statement stmt=null;
	ResultSet rs=null;
	JButton buttonAddRow,buttonDeleteRow,buttonChangeRow;
	JPanel panel;
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String URL="jdbc:mysql://localhost:3306/homework?serverTimezone=UTC";
	static final String USER="root";
	static final String PASSWORD="1234";
	public myFrame() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from book");
			while(rs.next()) {
				Vector vrow = new Vector<>();
				vrow.add(rs.getString(1));//����ǰ��¼�ĵ�һ���ֶ�ֵ��������
				vrow.add(rs.getString(2));//����ǰ��¼�ĵڶ����ֶ�ֵ��������
				vdata.add(vrow);//�����м�¼���뵽vdata��
				
			}
			//�����ֶα���
			vcolumn.add("����");
			vcolumn.add("�۸�");
			tableModel=new DefaultTableModel(vdata,vcolumn);
			table=new JTable(tableModel);
			JScrollPane sPane=new JScrollPane(table);
			
			frame=new JFrame();
			frame.add(sPane);
			
			
			//������ť����ӵ�������
			buttonAddRow = new JButton("������");
			buttonDeleteRow = new JButton("ɾ����");
			buttonChangeRow = new JButton("�ı���");
			panel=new JPanel();
			panel.add(buttonAddRow);
			panel.add(buttonChangeRow);
			panel.add(buttonDeleteRow);
			frame.add(panel,BorderLayout.SOUTH);
			frame.setSize(300,200);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//��ť�¼�ע��
			buttonAddRow.addActionListener( this);
			buttonDeleteRow.addActionListener( this);
			buttonChangeRow.addActionListener( this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonAddRow) {
				//����һ������
				System.out.println("���������ͼ۸�");
				Scanner scanner=new Scanner(System.in);
				Vector vrow = new Vector<>();
				vrow.add(scanner.next());
				vrow.add(scanner.next());
				tableModel.addRow(vrow);
				System.out.println("�����ӳɹ���");
		    }else if (e.getSource()==buttonChangeRow) {
		    	//�޸�����
				System.out.println("���������ͼ۸�");
				Scanner scanner=new Scanner(System.in);
				Vector vrow = new Vector<>();
				String bookName=scanner.next();
				String bookPrice=scanner.next();
				int selectRow=table.getSelectedRow();
				tableModel.setValueAt(bookName, selectRow, 0);//�޸�ĳ��Ԫ���ֵ
				tableModel.setValueAt(bookPrice, selectRow, 1);
				System.out.println("���޸ĳɹ���");
		    }else if (e.getSource()==buttonDeleteRow) {
		    	//ɾ��һ��
		    	
		    	//��ȡ��ѡ�е���
		    	int selectRow[]=table.getSelectedRows();
		    	//ɾ����ѡ�е���
		    	for (int i=0;i<selectRow.length;i++) {
		    		selectRow[i]-=i;
		    		tableModel.removeRow(selectRow[i]);
		    	}
				
			}
			
		}
	
	
}
public class Q12 {
	public static void main(String[] args) {
		new myFrame();
	}
}
