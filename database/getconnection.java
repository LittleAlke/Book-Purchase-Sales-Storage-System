package ���ݿ�;
import java.sql.*;
public class getconnection {
   public static Connection getconn() {
	Connection conn =null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://local"
				+ "host:3306/alke?userUnicode=true&characterEncoding=utf-8","root","");
		                      //������Ϊ�գ�Ҳ����ˣ����ܴ��ո񣩡�Ҳ��null
	} catch (ClassNotFoundException  e) {
		System.err.println(e.toString());
	}catch (SQLException ex) {
		System.err.println(ex.toString());
	}
	return conn;
}
}
