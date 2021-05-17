package 数据库;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Add {

public ResultSet rs;
public Add(String sql) throws SQLException{
	Connection conn=null;
	Statement stmt=null;
	//rs=stmt.executeQuery(sql);
	try { 
    conn=new getconnection().getconn();
    stmt=conn.createStatement();
    stmt.executeUpdate(sql);
    stmt.close();
    conn.close();
    //JOptionPane.showMessageDialog(null, "一条语句已经插入");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
