package ����;

import ���ݿ�.*;
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

public class ��������� extends JPanel implements ActionListener{
	private JTextField bh,xss,sj,sl,zje;
	private JButton ����,����,�ܽ��;
	 public ���������() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);     	
      	Font f1=new Font(null, 0, 20);
      	
      	JLabel ����1=new JLabel("--------------------------------------------------------------������۵�--------------------------------------------------------------");  
      	����1.setBounds(50, 62, 1056, 35);
   	    ����1.setFont(f1);
      	
   	    JLabel ������=new JLabel("�����̱��:");
   	    ������.setFont(f1);
   	    ������.setBounds(117, 130, 125, 35);
	    xss=new JTextField();
	    xss.setFont(f1);
	    xss.setBounds(227, 130, 200, 35);
	
	    JLabel ���=new JLabel("ISBN:");
	    ���.setFont(f1);
	    ���.setBounds(580, 130, 85, 35);
	    bh=new JTextField();
	    bh.setFont(f1);
	    bh.setBounds(680, 130, 200, 35);
	    
	    JLabel �ۼ�=new JLabel("�ۼ�:");
   	    �ۼ�.setFont(f1);
   	    �ۼ�.setBounds(117, 190, 125, 35);
	    sj=new JTextField();
	    sj.setFont(f1);
	    sj.setBounds(227, 190, 200, 35);
	    
	    JLabel ����=new JLabel("����:");
	    ����.setFont(f1);
	    ����.setBounds(580, 190, 85, 35);
	    sl=new JTextField();
	    sl.setFont(f1);
	    sl.setBounds(680, 190, 200, 35);
	    
	    �ܽ��=new JButton("�ܽ��");
   	    �ܽ��.setBounds(117, 250, 110, 35);
   	    �ܽ��.addActionListener(this);
   	    zje=new JTextField();
   	    zje.setFont(f1);
   	    zje.setBounds(227, 250, 200, 35);
   	    zje.setEditable(false);
		   
   	    ����=new JButton("����");
	    ����.setBounds(617, 643, 85, 35);
	    ����=new JButton("����");
	    ����.addActionListener(this);
	    ����.setBounds(217, 643, 85, 35);
	    
		this.add(����1);
		this.add(������);
		this.add(xss);
		this.add(���);
		this.add(bh);
		this.add(�ۼ�);
		this.add(sj);
		this.add(����);
		this.add(sl);
		this.add(�ܽ��);
		this.add(zje);
		this.add(����);
   	    this.add(����);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==�ܽ��) {
			   int a = Integer.parseInt(sj.getText())*Integer.parseInt(sl.getText());
				zje.setText(""+a+"");	
			}
		if (e.getSource()==����) {		
			int number =Integer.parseInt(sl.getText());
			//�жϿ���Ƿ����
			if (�ж�.isEnough(bh.getText(),number)) {
				//���¿��
				Connection con2;
				Statement stmt2;			   
			    String sqlstr2="update inventoryinfo set ��������=��������+"+sl.getText()+" ,�ֿ����=�ֿ����-"+sl.getText()+" where inventoryinfo.ISBN ="+bh.getText()+"";
			    try {
					Add a3=new Add(sqlstr2);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    //�������۵�
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
				String Name =��¼.name;
			    String sqlstr1="insert into salesdetail"
						+ "(���۵�����,ISBN,��������,�ۼ�,���۽��,��������,�����̱��,������)"
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

			    
			    //��ȡ���������Ӧ������������������������ϸ
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
			    //����������ϸ
			    Connection con3;
				Statement stmt3;			   
			    String sqlstr3="insert into sell"
						+ "(���۵�����,ͼ�����,����,���ۼ�,����,�ܽ��,��������,�Ƿ��շ�,Ա������)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+type+"'"
								+ ","+"'"+bookname+"'"
								+ ","+"'"+sj.getText()+"'"
								+ ","+"'"+sl.getText()+"'"
								+ ","+"'"+zje.getText()+"'"
										+ ","+"'"+date+"'"
										+ ","+"'"+"��"+"'"
								+ ","+"'"+Name+"'"								
								+ ")";
			    try {
					Add a3=new Add(sqlstr3);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    JOptionPane.showMessageDialog(null, "����ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);	
              //�ж��Ƿ���Ҫ����
			   if (�ж�.isBaojing(bh.getText(), number)) {     
				   JOptionPane.showConfirmDialog(null,"������ڱ������ޣ��뼰ʱ����",
						   "��ʾ",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			   } else {}
		 //��治���޷�����ʱ
		   } else {
			   Toolkit.getDefaultToolkit().beep();//ʹϵͳ����~�~��һ��
         	  JOptionPane.showMessageDialog(null,"���ﲻ�㣬����ʧ�ܣ�",
                       "ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
		   }
					    			
		}
	}

}
