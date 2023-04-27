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
				
				//2.查询书名
				System.out.println("1.请输入要查询的书名：");
				Scanner inputScanner= new Scanner(System.in);
				String booknameString=inputScanner.next();
				
				String sql="select * from book where bookName='"+booknameString+"'";
				ResultSet rSet=sta.executeQuery(sql);
				if(rSet.equals(null)) {
					System.out.print("Not Find Book");
				}
				else {
					System.out.println(booknameString+"的信息：");
					while(rSet.next()) {
						String nameString=rSet.getString("bookName");
						String priceString=rSet.getString("bookPrice");
						String autherString=rSet.getString("bookAuthor");
						System.out.println("书名："+nameString+"  价格:"+priceString+"  作者:"+autherString);
					}
				}
				
				//3新增一本书
				System.out.println("2.添加一本书");
				sql="INSERT INTO book VALUES ('如何成为学霸', 20, '我是爸爸')";
				sta.execute(sql);
				//4删除价格大于30的所有图书
				System.out.println("3.删除价格大于30的所有图书");
				sql="DELETE FROM book WHERE bookPrice>30";
				sta.execute(sql);
				//5.作者的名字由峰改为锋
				System.out.println("4.作者的名字由峰改为锋");
				sql="update book set bookAuthor=replace(bookAuthor,'峰','锋') where bookAuthor='*峰*'";
				
				
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
