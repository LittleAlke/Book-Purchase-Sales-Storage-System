package Alke;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import 数据库.getconnection;
import 数据库.Add;
 public class 注册 extends JFrame implements ActionListener,ItemListener{
private JFrame app;
 private JTextField 用户名,密码,姓名,电话;                                              
 private JButton 下一步,重新填写;
 private Dialog dialog;   
public  注册() {
	//使界面更圆润
			try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	this.setTitle("现在注册");
    this.setSize(700,750);
    this.setLocation(200,140);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    Container c=getContentPane();
    //背景
    ImageIcon img=new ImageIcon("G:/JAVA/图书进销存管理系统/图片/shine.jpg");
    JLabel jll=new JLabel(img);
    jll.setBounds(-200, -600, img.getIconWidth(),img.getIconWidth());
    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
    ((JPanel)c).setOpaque(false);
    //设置图标
    Image icon = Toolkit.getDefaultToolkit().getImage("G:/JAVA/图书进销存管理系统/图片/神盾局2.jpg");
    this.setIconImage(icon);
    
    Font f1=new Font("华文行楷", Font.PLAIN, 30);
    Font f2=new Font("宋体", Font.BOLD,30);
    
    c.setLayout(new GridLayout(1,3));                    //网格布局（行，列）
    JPanel p1=new JPanel();
    p1.setOpaque(false);////////  
    p1.setLayout(new GridLayout(12,1,0,10));            
    p1.add(new JLabel(""));
    JLabel j1=new JLabel("注册步骤:");
    j1.setFont(f1);
    p1.add(j1);
    JLabel j2=new JLabel("一、填写表单");
    j2.setFont(f1);
    p1.add(j2);
    JLabel j3=new JLabel("二、完成注册");
    j3.setFont(f1);
    p1.add(j3);
    JLabel j4=new JLabel("三、完成注册");
    j4.setFont(f1);
    //p1.add(j4);
    c.add(p1);
    
    JPanel p2=new JPanel();
    p2.setOpaque(false);/////////
    JPanel p3=new JPanel();
    p3.setOpaque(false);//////////
    c.add(p2);
    c.add(p3);
    p2.setLayout(new GridLayout(12,1,0,10));
    p3.setLayout(new GridLayout(12,1,0,10));
    
    JLabel yhm=new JLabel("用户名",JLabel.CENTER);
    yhm.setFont(f1);
    p2.add(new JLabel(""));
    p2.add(new JLabel(""));
    p2.add(yhm);
    用户名=new JTextField(10);
    用户名.setFont(f2);
    用户名.setOpaque(false);
    p3.add(new JLabel(""));
    p3.add(new JLabel(""));
    p3.add(用户名);
    
    JLabel mm=new JLabel("密码",JLabel.CENTER);
    mm.setFont(f1);
    p2.add(mm);
    密码=new JPasswordField(10);
    密码.setFont(f2);
    密码.setOpaque(false);
    p3.add(密码);
    
    JLabel xm=new JLabel("姓名",JLabel.CENTER);
    xm.setFont(f1);
    p2.add(xm);
    姓名=new JTextField(10);
    姓名.setFont(f2);
    姓名.setOpaque(false);                                              //文本域透明
    p3.add(姓名);
    
    JLabel dh=new JLabel("电话",JLabel.CENTER);
    dh.setFont(f1);
    p2.add(dh);
    电话=new JTextField(10);
    电话.setFont(f2);
    电话.setOpaque(false);                                              //文本域透明
    p3.add(电话);
    
    //Icon i=new ImageIcon("G:/图书进销存管理系统/图片/下一步按钮.png");  
    下一步=new JButton("下一步"); 
    下一步.setFont(f1);
    //下一步.setContentAreaFilled(false);                               //按钮透明
    p2.add(下一步);
    下一步.addActionListener(this);
     
    //Icon i2=new ImageIcon("G:/图书进销存管理系统/图片/重新输入按钮.png");
    重新填写=new JButton("重新填写");
    //重新填写.setContentAreaFilled(false);                                //按钮透明
    重新填写.setFont(f1);
    p2.add(重新填写);
    重新填写.addActionListener(this);
    
    this.setVisible(true);
    }

public void itemStateChanged(ItemEvent e) {
}
public void actionPerformed(ActionEvent e) {	
		if (e.getSource()==下一步) {
			Connection con;
			Statement stmt;
		    System.out.println("已准备注册");                          //测试行
		    String sqlstr="insert into login"
					+ "(userName,passWord,name,tel)"
					+ "values("
					+ "'"+用户名.getText()+"'"
							+ ","+"'"+密码.getText()+"'"
							+ ","+"'"+姓名.getText()+"'"
							+ ","+"'"+电话.getText()+"'"
							+ ")";
		    try {
				Add a1=new Add(sqlstr);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    JOptionPane.showMessageDialog(null, "注册成功！");
		    this.setVisible(false);
			new 登录();
		}
	if (e.getSource()==重新填写) {
		用户名.setText("");
		密码.setText("");
		姓名.setText("");
		电话.setText("");
	}
}
}
 
 
 
	/*try {
	con=new getconnection().getconn();				
	stmt=con.createStatement();				                             
	String sqlstr="insert into login"
			+ "(userName,passWord,name,tel)"
			+ "values("
			+ "'"+用户名.getText()+"'"
					+ ","+"'"+密码.getText()+"'"
					+ ","+"'"+姓名.getText()+"'"
					+ ","+"'"+电话.getText()+"'"
					+ ")";			                             
	stmt.executeUpdate(sqlstr);
	System.out.println("注册成功");
	stmt.close();
	con.close();
	this.setVisible(false);
	new 登录();
} catch (SQLException f) {
	System.out.println("SQLException:"+f.getLocalizedMessage());
}*/
