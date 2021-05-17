package 销售;

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

public class 添加新销售 extends JPanel implements ActionListener{
	private JTextField bh,xss,sj,sl,zje;
	private JButton 保存,返回,总金额;
	 public 添加新销售() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);     	
      	Font f1=new Font(null, 0, 20);
      	
      	JLabel 线条1=new JLabel("--------------------------------------------------------------添加销售单--------------------------------------------------------------");  
      	线条1.setBounds(50, 62, 1056, 35);
   	    线条1.setFont(f1);
      	
   	    JLabel 销售商=new JLabel("销售商编号:");
   	    销售商.setFont(f1);
   	    销售商.setBounds(117, 130, 125, 35);
	    xss=new JTextField();
	    xss.setFont(f1);
	    xss.setBounds(227, 130, 200, 35);
	
	    JLabel 编号=new JLabel("ISBN:");
	    编号.setFont(f1);
	    编号.setBounds(580, 130, 85, 35);
	    bh=new JTextField();
	    bh.setFont(f1);
	    bh.setBounds(680, 130, 200, 35);
	    
	    JLabel 售价=new JLabel("售价:");
   	    售价.setFont(f1);
   	    售价.setBounds(117, 190, 125, 35);
	    sj=new JTextField();
	    sj.setFont(f1);
	    sj.setBounds(227, 190, 200, 35);
	    
	    JLabel 数量=new JLabel("数量:");
	    数量.setFont(f1);
	    数量.setBounds(580, 190, 85, 35);
	    sl=new JTextField();
	    sl.setFont(f1);
	    sl.setBounds(680, 190, 200, 35);
	    
	    总金额=new JButton("总金额");
   	    总金额.setBounds(117, 250, 110, 35);
   	    总金额.addActionListener(this);
   	    zje=new JTextField();
   	    zje.setFont(f1);
   	    zje.setBounds(227, 250, 200, 35);
   	    zje.setEditable(false);
		   
   	    返回=new JButton("返回");
	    返回.setBounds(617, 643, 85, 35);
	    保存=new JButton("保存");
	    保存.addActionListener(this);
	    保存.setBounds(217, 643, 85, 35);
	    
		this.add(线条1);
		this.add(销售商);
		this.add(xss);
		this.add(编号);
		this.add(bh);
		this.add(售价);
		this.add(sj);
		this.add(数量);
		this.add(sl);
		this.add(总金额);
		this.add(zje);
		this.add(返回);
   	    this.add(保存);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==总金额) {
			   int a = Integer.parseInt(sj.getText())*Integer.parseInt(sl.getText());
				zje.setText(""+a+"");	
			}
		if (e.getSource()==保存) {		
			int number =Integer.parseInt(sl.getText());
			//判断库存是否出售
			if (判断.isEnough(bh.getText(),number)) {
				//更新库存
				Connection con2;
				Statement stmt2;			   
			    String sqlstr2="update inventoryinfo set 销售数量=销售数量+"+sl.getText()+" ,现库存量=现库存量-"+sl.getText()+" where inventoryinfo.ISBN ="+bh.getText()+"";
			    try {
					Add a3=new Add(sqlstr2);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    //增添销售单
			    Connection con1;
				Statement stmt1;
				Calendar cal=Calendar.getInstance();      
				int y=cal.get(Calendar.YEAR);      
				int m=cal.get(Calendar.MONTH)+1;      
				int d=cal.get(Calendar.DATE);      
				int h=cal.get(Calendar.HOUR_OF_DAY);      
				int mi=cal.get(Calendar.MINUTE);      
				int s=cal.get(Calendar.SECOND);
				String dh="S"+y+m+d+h+mi+s;
				String date=y+"-"+m+"-"+d;
				String Name =登录.name;
			    String sqlstr1="insert into salesdetail"
						+ "(销售单单号,ISBN,销售数量,售价,销售金额,销售日期,销售商编号,经办人)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+bh.getText()+"'"
								+ ","+"'"+sl.getText()+"'"
								+ ","+"'"+sj.getText()+"'"
								+ ","+"'"+zje.getText()+"'"
								+ ","+"'"+date+"'"
								+ ","+"'"+xss.getText()+"'"
								+ ","+"'"+Name+"'"							
								+ ")";
			    try {
					Add a2=new Add(sqlstr1);			
				} catch (SQLException e1) {			
					e1.printStackTrace();
				}  

			    
			    //获取所销售书对应的书类别和书名以增添销售明细
			    Connection conn4=null;
				Statement stmt4=null;
				ResultSet rs;
				String type = null;
				String bookname = null;
			    try {
			    	String sql4="select * from bookinfo where bookinfo.ISBN="+bh.getText();	    	
			    	conn4=new getconnection().getconn();
					stmt4=conn4.createStatement();
					rs=stmt4.executeQuery(sql4);
					while (rs.next()) {
						type=rs.getString("classification");
					bookname=rs.getString("bookName");
						break;
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	  System.out.print(type  +   bookname);
			    //增添销售明细
			    Connection con3;
				Statement stmt3;			   
			    String sqlstr3="insert into sell"
						+ "(销售单单号,图书类别,书名,销售价,数量,总金额,销售日期,是否收费,员工姓名)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+type+"'"
								+ ","+"'"+bookname+"'"
								+ ","+"'"+sj.getText()+"'"
								+ ","+"'"+sl.getText()+"'"
								+ ","+"'"+zje.getText()+"'"
										+ ","+"'"+date+"'"
										+ ","+"'"+"是"+"'"
								+ ","+"'"+Name+"'"								
								+ ")";
			    try {
					Add a3=new Add(sqlstr3);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    JOptionPane.showMessageDialog(null, "保存成功","提示",JOptionPane.INFORMATION_MESSAGE);	
              //判断是否需要报警
			   if (判断.isBaojing(bh.getText(), number)) {     
				   JOptionPane.showConfirmDialog(null,"货存低于报警下限！请及时进货",
						   "提示",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			   } else {}
		 //库存不足无法出售时
		   } else {
			   Toolkit.getDefaultToolkit().beep();//使系统发出~嘟~的一声
         	  JOptionPane.showMessageDialog(null,"货物不足，保存失败！",
                       "系统提示",JOptionPane.INFORMATION_MESSAGE);
		   }
					    			
		}
	}

}
