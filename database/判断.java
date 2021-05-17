package 数据库;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class 判断 {
	//判断是否库存足够（销售时）
	public static boolean isEnough(String ISBN,int number){
		boolean isenough=true;
		//获取库存中相应的书的数目
		String sql="select 现库存量 from inventoryinfo where ISBN='"+ISBN+"'";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getconnection.getconn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);/////////////////
			while(rs.next()){
				int all=rs.getInt(1);
	System.out.println(all );
  System.out.println(number);
			if(all-number<0)
				isenough=false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (Exception e) {e.printStackTrace();}
			try {
				if(stmt!=null)
					stmt.close();
			} catch (Exception e) {e.printStackTrace();}
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e) {e.printStackTrace();}
		}
		return isenough;
	}
	//判断是否需要报警
	public static boolean isBaojing(String ISBN,int number){ 
		boolean isbaojing=true;
		String sql="select inventoryinfo.现库存量,alarm.报警数量 from alarm,inventoryinfo where alarm.ISBN="+ISBN+" and inventoryinfo.ISBN="+ISBN;		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getconnection.getconn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
			int all=rs.getInt(1);
			int baojing=rs.getInt(2);
	System.out.println(all );
	System.out.println(baojing);
	System.out.println(number);
			if(all-number<=baojing)
				isbaojing=true;
			else
				isbaojing=false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (Exception e) {e.printStackTrace();}
			try {
				if(stmt!=null)
					stmt.close();
			} catch (Exception e) {e.printStackTrace();}
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e) {e.printStackTrace();}
		}
		return isbaojing;
	}
	
}
