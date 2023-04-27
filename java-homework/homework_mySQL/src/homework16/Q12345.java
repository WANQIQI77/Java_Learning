package homework16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Q12345 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework?serverTimezone=UTC","root","1234");
			if (conn!=null) {
				System.out.println("connection success!!!!!!");
				Statement sta = conn.createStatement();
				
				//2.��ѯ����
				System.out.println("1.������Ҫ��ѯ��������");
				Scanner inputScanner= new Scanner(System.in);
				String booknameString=inputScanner.next();
				
				String sql="select * from book where bookName='"+booknameString+"'";
				ResultSet rSet=sta.executeQuery(sql);
				if(rSet.equals(null)) {
					System.out.print("Not Find Book");
				}
				else {
					System.out.println(booknameString+"����Ϣ��");
					while(rSet.next()) {
						String nameString=rSet.getString("bookName");
						String priceString=rSet.getString("bookPrice");
						String autherString=rSet.getString("bookAuthor");
						System.out.println("������"+nameString+"  �۸�:"+priceString+"  ����:"+autherString);
					}
				}
				
				//3����һ����
				System.out.println("2.���һ����");
				sql="INSERT INTO book VALUES ('��γ�Ϊѧ��', 20, '���ǰְ�')";
				sta.execute(sql);
				//4ɾ���۸����30������ͼ��
				System.out.println("3.ɾ���۸����30������ͼ��");
				sql="DELETE FROM book WHERE bookPrice>30";
				sta.execute(sql);
				//5.���ߵ������ɷ��Ϊ��
				System.out.println("4.���ߵ������ɷ��Ϊ��");
				sql="update book set bookAuthor=replace(bookAuthor,'��','��') where bookAuthor='*��*'";
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
