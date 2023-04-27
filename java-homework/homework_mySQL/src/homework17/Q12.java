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
/*1、将数据库中任意一张表中的内容在JTable中显示。
2、自行设计表的增、删、改操作方式，并完成相应的功能。*/
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
				vrow.add(rs.getString(1));//将当前记录的第一列字段值填入向量
				vrow.add(rs.getString(2));//将当前记录的第二列字段值填入向量
				vdata.add(vrow);//将整行记录加入到vdata中
				
			}
			//设置字段标题
			vcolumn.add("书名");
			vcolumn.add("价格");
			tableModel=new DefaultTableModel(vdata,vcolumn);
			table=new JTable(tableModel);
			JScrollPane sPane=new JScrollPane(table);
			
			frame=new JFrame();
			frame.add(sPane);
			
			
			//创建按钮并添加到窗口中
			buttonAddRow = new JButton("增加行");
			buttonDeleteRow = new JButton("删除行");
			buttonChangeRow = new JButton("改变行");
			panel=new JPanel();
			panel.add(buttonAddRow);
			panel.add(buttonChangeRow);
			panel.add(buttonDeleteRow);
			frame.add(panel,BorderLayout.SOUTH);
			frame.setSize(300,200);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//按钮事件注册
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
				//输入一行数据
				System.out.println("输入书名和价格：");
				Scanner scanner=new Scanner(System.in);
				Vector vrow = new Vector<>();
				vrow.add(scanner.next());
				vrow.add(scanner.next());
				tableModel.addRow(vrow);
				System.out.println("行增加成功：");
		    }else if (e.getSource()==buttonChangeRow) {
		    	//修改数据
				System.out.println("输入书名和价格：");
				Scanner scanner=new Scanner(System.in);
				Vector vrow = new Vector<>();
				String bookName=scanner.next();
				String bookPrice=scanner.next();
				int selectRow=table.getSelectedRow();
				tableModel.setValueAt(bookName, selectRow, 0);//修改某单元格的值
				tableModel.setValueAt(bookPrice, selectRow, 1);
				System.out.println("行修改成功：");
		    }else if (e.getSource()==buttonDeleteRow) {
		    	//删除一行
		    	
		    	//获取被选中的行
		    	int selectRow[]=table.getSelectedRows();
		    	//删除被选中的行
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
