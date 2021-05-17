package Alke;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import 数据库.Query;
import 数据库.getconnection;

public class Alke {
	DefaultTableModel model1;
    private JTable table1;
public  Alke() {
	String sql1="select ISBN from inventoryinfo ";
    model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
    table1 = new JTable(model1);
    int rows = table1.getRowCount();//获取表的行数
    String []s1 = new String[rows];
     boolean b1=false;
    String 接收="5"; 
    for (int j=0;j<rows;j++) {
    	System.out.println(table1.getValueAt(j,0).toString());
    	if (table1.getValueAt(j,0).toString().equals(接收)) {//读取你获取行号的某一列的值（也就是字段
			b1=true;
			break;
		}
  }
		System.out.println(b1);
}
	public static void main(String[] args) {
		new Alke();
	}
	
}



