package 人员;

import 数据库.*;
import Alke.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class 添加销售商 extends JPanel implements ActionListener{
	private JTextField gsmc,yx,gsdz,yb,gsdh,name,name2,tel,bankID;
	private JComboBox bank;
	private JButton 浏览销售商信息,保存,返回;
	private JRadioButton 男,女;
	private ButtonGroup sex;
	 public 添加销售商() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);     	
      	Font f1=new Font(null, 0, 20);
      	
      	浏览销售商信息=new JButton("浏览销售商信息");
      	浏览销售商信息.setBounds(50, 30, 120, 35);
      	浏览销售商信息.addActionListener(this);
      	
      	JLabel 线条1=new JLabel("--------------------------------------------------------------添加新销售商--------------------------------------------------------------");  
      	线条1.setBounds(50, 62, 1056, 35);
   	    线条1.setFont(f1);
      	
   	    JLabel 公司名称=new JLabel("公司名称:");
   	    公司名称.setFont(f1);
   	    公司名称.setBounds(117, 130, 125, 35);
	    gsmc=new JTextField();
	    gsmc.setFont(f1);
	    gsmc.setBounds(227, 130, 200, 35);
	
	    JLabel 邮箱=new JLabel("邮箱:");
	    邮箱.setFont(f1);
	    邮箱.setBounds(580, 130, 85, 35);
	    yx=new JTextField();
	    yx.setFont(f1);
	    yx.setBounds(680, 130, 200, 35);
	    
	    JLabel 公司地址=new JLabel("公司地址:");
	    公司地址.setFont(f1);
	    公司地址.setBounds(117, 190, 125, 35);
	    gsdz=new JTextField();
	    gsdz.setFont(f1);
	    gsdz.setBounds(227, 190, 200, 35);
	    
	    JLabel 邮编=new JLabel("邮编:");
	    邮编.setFont(f1);
	    邮编.setBounds(580, 190, 85, 35);
	    yb=new JTextField();
	    yb.setFont(f1);
	    yb.setBounds(680, 190, 200, 35);
	    
	    JLabel 公司电话=new JLabel("公司电话:");
   	    公司电话.setFont(f1);
   	    公司电话.setBounds(117, 250, 125, 35);
   	    gsdh=new JTextField();
   	    gsdh.setFont(f1);
   	    gsdh.setBounds(227, 250, 200, 35);

   	    JLabel 负责人姓名=new JLabel("负责人姓名:");
   	    负责人姓名.setFont(f1);
     	负责人姓名.setBounds(117, 310, 125, 35);
	    name=new JTextField();
	    name.setFont(f1);
	    name.setBounds(227, 310, 200, 35);    
   	    
	    JLabel 性别=new JLabel("负责人性别:");
   	    性别.setFont(f1);
     	性别.setBounds(580, 310, 125, 35);
     	男=new JRadioButton("男");
     	男.setFont(f1);
     	女=new JRadioButton("女");
     	女.setFont(f1);     
     	男.setBounds(700, 310, 100, 35);
     	女.setBounds(800, 310, 100, 35);
     	sex=new ButtonGroup();
     	sex.add(男);
     	sex.add(女);
     	
     	JLabel 负责人称谓=new JLabel("负责人称谓:");
   	    负责人称谓.setFont(f1);
     	负责人称谓.setBounds(117, 370, 125, 35);
	    name2=new JTextField();
	    name2.setFont(f1);
	    name2.setBounds(227, 370, 200, 35);
	    
	    JLabel 负责人电话=new JLabel("负责人电话:");
   	    负责人电话.setFont(f1);
     	负责人电话.setBounds(580, 370, 125, 35);
	    tel=new JTextField();
	    tel.setFont(f1);
	    tel.setBounds(690, 370, 200, 35);
	    
	    JLabel 收款银行=new JLabel("收款银行:");
	    收款银行.setFont(f1);
	    收款银行.setBounds(117, 430, 125, 35);	    
	    String[]banktype= {"工商银行","建设银行","农业银行","中国银行","邮储银行","交通银行"};
   	    bank=new JComboBox(banktype);
        bank.setFont(f1);
     	bank.setBounds(227, 430, 200, 35);
        
     	JLabel 银行卡号=new JLabel("银行卡号:");
   	    银行卡号.setFont(f1);
     	银行卡号.setBounds(580, 430, 125, 35);
	    bankID=new JTextField();
	    bankID.setFont(f1);
	    bankID.setBounds(690, 430, 200, 35);
		   
   	    返回=new JButton("返回");
	    返回.setBounds(617, 643, 85, 35);
	    保存=new JButton("保存");
	    保存.addActionListener(this);
	    保存.setBounds(217, 643, 85, 35);
	    
	    this.add(浏览销售商信息);
		this.add(线条1);
		this.add(公司地址);
		this.add(gsmc);
		this.add(公司名称);
		this.add(yx);
		this.add(邮编);
		this.add(gsdz);
		this.add(邮箱);
		this.add(yb);
		this.add(公司电话);
		this.add(gsdh);
		this.add(负责人姓名);
		this.add(name);
		this.add(性别);
		this.add(男);
		this.add(女);
		this.add(负责人称谓);
		this.add(name2);
		this.add(负责人电话);
		this.add(tel);
		//this.add(收款银行);
		//this.add(bank);
		//this.add(银行卡号);
		//this.add(bankID);
		this.add(返回);
   	    this.add(保存);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==保存) {
			String xb = null;
			if (男.isSelected()) {
				xb=男.getText();}		
			if (女.isSelected()) {
				xb=女.getText();}					
		    Connection con1;
			Statement stmt1;
			Calendar cal=Calendar.getInstance();      
			int y=cal.get(Calendar.YEAR);      
			int m=cal.get(Calendar.MONTH);      
			int d=cal.get(Calendar.DATE);      
			int h=cal.get(Calendar.HOUR_OF_DAY);      
			int mi=cal.get(Calendar.MINUTE);      
			int s=cal.get(Calendar.SECOND);
			String dh="A"+m+d+h+mi+s;
			String date=y+"-"+m+"-"+d;
			String Name =登录.name;
		    String sqlstr1="insert into sellerinfo"
					+ "(销售商编号,销售商名称,邮箱,地址,邮编,销售商电话,负责人姓名,性别,称谓,电话)"
					+ "values("
					+ "'"+dh+"'"
							+ ","+"'"+gsmc.getText()+"'"
							+ ","+"'"+yx.getText()+"'"
							+ ","+"'"+gsdz.getText()+"'"
							+ ","+"'"+yb.getText()+"'"
							+ ","+"'"+gsdh.getText()+"'"
							+ ","+"'"+name.getText()+"'"
							+ ","+"'"+xb+"'"
							+ ","+"'"+name2.getText()+"'"		
							+ ","+"'"+tel.getText()+"'"																							
							+ ")";
		    try {
				Add a2=new Add(sqlstr1);			
			} catch (SQLException e1) {			
				e1.printStackTrace();
			}   
		    JOptionPane.showMessageDialog(null, "添加成功！");			
			}
		if (e.getSource()==浏览销售商信息) {
			主界面.pCenter.setVisible(false);			
			主界面.pCenter.removeAll();			              
			主界面.pCenter.add(new 销售商信息());		           
			主界面.pCenter.setVisible(true);	
		}
	}

}
