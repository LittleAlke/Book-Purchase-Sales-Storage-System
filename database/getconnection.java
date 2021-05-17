package 数据库;
import java.sql.*;
public class getconnection {
   public static Connection getconn() {
	Connection conn =null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://local"
				+ "host:3306/alke?userUnicode=true&characterEncoding=utf-8","root","");
		                      //若密码为空，也可如此（不能带空格）。也可null
	} catch (ClassNotFoundException  e) {
		System.err.println(e.toString());
	}catch (SQLException ex) {
		System.err.println(ex.toString());
	}
	return conn;
}
}
