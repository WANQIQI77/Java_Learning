package qq;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class APP7_1 {

public static void main(String[] args) {
// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework?serverTimezone=UTC","root","1234");
		if(conn!=null) {
			System.out.println("success!!");
			String findid="006";
			Statement sta=conn.createStatement();
			String sql="select * from student where id="+findid;
			System.out.println(sql);
			ResultSet rs=sta.executeQuery(sql);
			if(rs.equals(null)) {
				System.out.println("Not Find");
			}
			while(rs.next()) {
				String sid=rs.getString("id");
				String sname=rs.getString("name");
				String sage=rs.getString("age");
				System.out.println("id:"+sid+"    name:"+sname+"    age:"+sage);
				
			}
			conn.close();
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