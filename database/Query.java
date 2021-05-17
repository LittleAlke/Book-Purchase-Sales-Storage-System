package Êý¾Ý¿â;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;

public class Query {
	
	private Vector<String> colname = new Vector<String>(); 
	private Vector<Object> data = new Vector<Object>();

	
	public ResultSet rs;

	public Query(String sql){
		Connection conn=null;
		Statement stmt=null;
		rs=null;
		try {
			conn=new getconnection().getconn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			rs.last();
			int rowCount=rs.getRow();
			int columnCount=rs.getMetaData().getColumnCount();
	    //	String date=rs.getString(columnLabel);
			for(int j=0;j<columnCount;j++)
				colname.add(rs.getMetaData().getColumnLabel(j+1));
		        
			rs.first();
			for(int i=0;i<rowCount;i++,rs.next()){
				Vector<Object> onerow = new Vector<Object>();
				for( int k=0;k<columnCount;k++)
					{onerow.add(rs.getString(k+1));					
				     }		
				data.add(onerow);							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Vector<String> getColName(){
		return colname;
	}
	public Vector<Object> getData(){
		return data;
	}

}
