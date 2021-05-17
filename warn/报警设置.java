package 报警;

import 数据库.*;
import Alke.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class 报警设置 extends JPanel implements ActionListener{	
	private JComboBox sm,sl;
	private String ISBN0;
	private JButton 报警信息查看,保存,返回;
	DefaultTableModel model1,model9;
    private JTable table1,table9;	
	 public 报警设置() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);
      	Font f0=new Font(null, 0, 20);
      	Font f1=new Font(null, 0, 25);
      	Font f2=new Font(null, 0, 30);
      	报警信息查看=new JButton("报警信息查看");
      	报警信息查看.setBounds(50, 30, 120, 35);
      	报警信息查看.addActionListener(this);   	
      	JLabel 线条1=new JLabel("--------------------------------------------报警设置------------------------------------------------");  
      	线条1.setBounds(50, 62, 1056, 35);
   	    线条1.setFont(f2);
   	        
      	//为书名下拉框获取数据
   	   String sql1="select bookinfo.bookName,bookinfo.ISBN from inventoryinfo,bookinfo where bookinfo.ISBN=inventoryinfo.ISBN";
       model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
       table1 = new JTable(model1);
       int rows = table1.getRowCount();//获取表的行数
       String []s1 = new String[rows];
       int k=0;
       for (int j=0;j<rows;j++) {			  
			s1[k]=table1.getValueAt(j,0).toString();//读取你获取行号的某一列的值（也就是字段）
			k+=1;}      
	    JLabel one=new JLabel("当库存的");
	    one.setFont(f1);
	    one.setBounds(120, 250, 110, 35);	     
   	    sm=new JComboBox(s1);
        sm.setFont(f0);
     	sm.setBounds(240, 250, 260, 35);
     	JLabel two=new JLabel("库存量少于");
	    two.setFont(f1);
	    two.setBounds(525, 250, 125, 35);
	    String[]sl0= {"10","20","30","40","50","60","70","80","90","100"};
   	    sl=new JComboBox(sl0);
        sl.setFont(f1);
     	sl.setBounds(675, 250, 100, 35);
     	JLabel three=new JLabel("时报警");
     	three.setFont(f1);
     	three.setBounds(795, 250, 125, 35);
  	    
	    保存=new JButton("保存");
	    保存.setFont(f0);
	    保存.addActionListener(this);
	    保存.setBounds(465, 420, 100, 35);
	    
	    this.add(报警信息查看);
		this.add(线条1);
		this.add(one);
		this.add(two);
		this.add(three);
		this.add(sm);
		this.add(sl);
   	    this.add(保存);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==保存) {
					
	     ISBN0=table1.getValueAt(sm.getSelectedIndex(),1).toString();	
		    
			//判断以前是否设置过
			String sql9="select ISBN from alarm ";
		    model9 = new  DefaultTableModel(new Query(sql9).getData(),new Query(sql9).getColName());  
		    table9 = new JTable(model9);
		    int rows9 = table9.getRowCount();//获取表的行数
		    boolean b1=false;
		    String 接收=ISBN0; 
		    for (int j=0;j<rows9;j++) {
		    	if (table9.getValueAt(j,0).toString().equals(接收)) {//读取你获取行号的某一列的值（也就是字段
					b1=true;
					break;
				}
		  }
		    if (b1) {
		    	//增添库存
			    Connection con12;
				Statement stmt12;
				String sqlstr12="update alarm set 报警数量="+sl.getSelectedItem()+" where alarm.ISBN ="+ISBN0+"";				  
			   
				try {
					Add a3=new Add(sqlstr12);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			} else {
				Connection con3;
				Statement stmt3;			
			    String sqlstr3="insert into alarm"
						+ "(ISBN,报警数量)"
						+ "values("	
						+ "'"+ISBN0+"'"
								+ ","+"'"+sl.getSelectedItem()+"'"																		
								+ ")";
			    try {
					Add a3=new Add(sqlstr3);			
				} catch (SQLException e1) {			
					e1.printStackTrace();
				}
			}
		    JOptionPane.showMessageDialog(null, "设置成功！");			
			}
		if (e.getSource()==报警信息查看) {
			主界面.pCenter.setVisible(false);			
			主界面.pCenter.removeAll();			              
			主界面.pCenter.add(new 报警信息查看());		           
			主界面.pCenter.setVisible(true);	
		}
	}

}
