package qq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database  {
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String URL="jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	static final String USER="root";
	static final String PASSWORD="1234";
	public static void main(String[] args) {
		try {
			Class.forName(JDBC_DRIVER);//�������ݿ�����
			try (Connection connection=DriverManager.getConnection(URL,USER,PASSWORD)){//�������ݿ�����
				//����statement���󣬷���sql���
				Statement stmt=(Statement) connection.createStatement();
				
				String mysql="select * from book";
				//ִ��select��䣬���ؽ����
				ResultSet rSet =stmt.executeQuery(mysql);
				while (rSet.next()) {
					String nameString=rSet.getString("bookName");
			
				}
					
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		}
	}

