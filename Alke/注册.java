package Alke;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import ���ݿ�.getconnection;
import ���ݿ�.Add;
 public class ע�� extends JFrame implements ActionListener,ItemListener{
private JFrame app;
 private JTextField �û���,����,����,�绰;                                              
 private JButton ��һ��,������д;
 private Dialog dialog;   
public  ע��() {
	//ʹ�����Բ��
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
	this.setTitle("����ע��");
    this.setSize(700,750);
    this.setLocation(200,140);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    Container c=getContentPane();
    //����
    ImageIcon img=new ImageIcon("G:/JAVA/ͼ����������ϵͳ/ͼƬ/shine.jpg");
    JLabel jll=new JLabel(img);
    jll.setBounds(-200, -600, img.getIconWidth(),img.getIconWidth());
    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
    ((JPanel)c).setOpaque(false);
    //����ͼ��
    Image icon = Toolkit.getDefaultToolkit().getImage("G:/JAVA/ͼ����������ϵͳ/ͼƬ/��ܾ�2.jpg");
    this.setIconImage(icon);
    
    Font f1=new Font("�����п�", Font.PLAIN, 30);
    Font f2=new Font("����", Font.BOLD,30);
    
    c.setLayout(new GridLayout(1,3));                    //���񲼾֣��У��У�
    JPanel p1=new JPanel();
    p1.setOpaque(false);////////  
    p1.setLayout(new GridLayout(12,1,0,10));            
    p1.add(new JLabel(""));
    JLabel j1=new JLabel("ע�Ჽ��:");
    j1.setFont(f1);
    p1.add(j1);
    JLabel j2=new JLabel("һ����д��");
    j2.setFont(f1);
    p1.add(j2);
    JLabel j3=new JLabel("�������ע��");
    j3.setFont(f1);
    p1.add(j3);
    JLabel j4=new JLabel("�������ע��");
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
    
    JLabel yhm=new JLabel("�û���",JLabel.CENTER);
    yhm.setFont(f1);
    p2.add(new JLabel(""));
    p2.add(new JLabel(""));
    p2.add(yhm);
    �û���=new JTextField(10);
    �û���.setFont(f2);
    �û���.setOpaque(false);
    p3.add(new JLabel(""));
    p3.add(new JLabel(""));
    p3.add(�û���);
    
    JLabel mm=new JLabel("����",JLabel.CENTER);
    mm.setFont(f1);
    p2.add(mm);
    ����=new JPasswordField(10);
    ����.setFont(f2);
    ����.setOpaque(false);
    p3.add(����);
    
    JLabel xm=new JLabel("����",JLabel.CENTER);
    xm.setFont(f1);
    p2.add(xm);
    ����=new JTextField(10);
    ����.setFont(f2);
    ����.setOpaque(false);                                              //�ı���͸��
    p3.add(����);
    
    JLabel dh=new JLabel("�绰",JLabel.CENTER);
    dh.setFont(f1);
    p2.add(dh);
    �绰=new JTextField(10);
    �绰.setFont(f2);
    �绰.setOpaque(false);                                              //�ı���͸��
    p3.add(�绰);
    
    //Icon i=new ImageIcon("G:/ͼ����������ϵͳ/ͼƬ/��һ����ť.png");  
    ��һ��=new JButton("��һ��"); 
    ��һ��.setFont(f1);
    //��һ��.setContentAreaFilled(false);                               //��ť͸��
    p2.add(��һ��);
    ��һ��.addActionListener(this);
     
    //Icon i2=new ImageIcon("G:/ͼ����������ϵͳ/ͼƬ/�������밴ť.png");
    ������д=new JButton("������д");
    //������д.setContentAreaFilled(false);                                //��ť͸��
    ������д.setFont(f1);
    p2.add(������д);
    ������д.addActionListener(this);
    
    this.setVisible(true);
    }

public void itemStateChanged(ItemEvent e) {
}
public void actionPerformed(ActionEvent e) {	
		if (e.getSource()==��һ��) {
			Connection con;
			Statement stmt;
		    System.out.println("��׼��ע��");                          //������
		    String sqlstr="insert into login"
					+ "(userName,passWord,name,tel)"
					+ "values("
					+ "'"+�û���.getText()+"'"
							+ ","+"'"+����.getText()+"'"
							+ ","+"'"+����.getText()+"'"
							+ ","+"'"+�绰.getText()+"'"
							+ ")";
		    try {
				Add a1=new Add(sqlstr);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    JOptionPane.showMessageDialog(null, "ע��ɹ���");
		    this.setVisible(false);
			new ��¼();
		}
	if (e.getSource()==������д) {
		�û���.setText("");
		����.setText("");
		����.setText("");
		�绰.setText("");
	}
}
}
 
 
 
	/*try {
	con=new getconnection().getconn();				
	stmt=con.createStatement();				                             
	String sqlstr="insert into login"
			+ "(userName,passWord,name,tel)"
			+ "values("
			+ "'"+�û���.getText()+"'"
					+ ","+"'"+����.getText()+"'"
					+ ","+"'"+����.getText()+"'"
					+ ","+"'"+�绰.getText()+"'"
					+ ")";			                             
	stmt.executeUpdate(sqlstr);
	System.out.println("ע��ɹ�");
	stmt.close();
	con.close();
	this.setVisible(false);
	new ��¼();
} catch (SQLException f) {
	System.out.println("SQLException:"+f.getLocalizedMessage());
}*/
