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

public class �������� extends JPanel implements ActionListener{	
	private JComboBox sm,sl;
	private String ISBN0;
	private JButton ������Ϣ�鿴,����,����;
	DefaultTableModel model1,model9;
    private JTable table1,table9;	
	 public ��������() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);
      	Font f0=new Font(null, 0, 20);
      	Font f1=new Font(null, 0, 25);
      	Font f2=new Font(null, 0, 30);
      	������Ϣ�鿴=new JButton("������Ϣ�鿴");
      	������Ϣ�鿴.setBounds(50, 30, 120, 35);
      	������Ϣ�鿴.addActionListener(this);   	
      	JLabel ����1=new JLabel("--------------------------------------------��������------------------------------------------------");  
      	����1.setBounds(50, 62, 1056, 35);
   	    ����1.setFont(f2);
   	        
      	//Ϊ�����������ȡ����
   	   String sql1="select bookinfo.bookName,bookinfo.ISBN from inventoryinfo,bookinfo where bookinfo.ISBN=inventoryinfo.ISBN";
       model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
       table1 = new JTable(model1);
       int rows = table1.getRowCount();//��ȡ�������
       String []s1 = new String[rows];
       int k=0;
       for (int j=0;j<rows;j++) {			  
			s1[k]=table1.getValueAt(j,0).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
			k+=1;}      
	    JLabel one=new JLabel("������");
	    one.setFont(f1);
	    one.setBounds(120, 250, 110, 35);	     
   	    sm=new JComboBox(s1);
        sm.setFont(f0);
     	sm.setBounds(240, 250, 260, 35);
     	JLabel two=new JLabel("���������");
	    two.setFont(f1);
	    two.setBounds(525, 250, 125, 35);
	    String[]sl0= {"10","20","30","40","50","60","70","80","90","100"};
   	    sl=new JComboBox(sl0);
        sl.setFont(f1);
     	sl.setBounds(675, 250, 100, 35);
     	JLabel three=new JLabel("ʱ����");
     	three.setFont(f1);
     	three.setBounds(795, 250, 125, 35);
  	    
	    ����=new JButton("����");
	    ����.setFont(f0);
	    ����.addActionListener(this);
	    ����.setBounds(465, 420, 100, 35);
	    
	    this.add(������Ϣ�鿴);
		this.add(����1);
		this.add(one);
		this.add(two);
		this.add(three);
		this.add(sm);
		this.add(sl);
   	    this.add(����);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==����) {
					
	     ISBN0=table1.getValueAt(sm.getSelectedIndex(),1).toString();	
		    
			//�ж���ǰ�Ƿ����ù�
			String sql9="select ISBN from alarm ";
		    model9 = new  DefaultTableModel(new Query(sql9).getData(),new Query(sql9).getColName());  
		    table9 = new JTable(model9);
		    int rows9 = table9.getRowCount();//��ȡ�������
		    boolean b1=false;
		    String ����=ISBN0; 
		    for (int j=0;j<rows9;j++) {
		    	if (table9.getValueAt(j,0).toString().equals(����)) {//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶ�
					b1=true;
					break;
				}
		  }
		    if (b1) {
		    	//������
			    Connection con12;
				Statement stmt12;
				String sqlstr12="update alarm set ��������="+sl.getSelectedItem()+" where alarm.ISBN ="+ISBN0+"";				  
			   
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
						+ "(ISBN,��������)"
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
		    JOptionPane.showMessageDialog(null, "���óɹ���");			
			}
		if (e.getSource()==������Ϣ�鿴) {
			������.pCenter.setVisible(false);			
			������.pCenter.removeAll();			              
			������.pCenter.add(new ������Ϣ�鿴());		           
			������.pCenter.setVisible(true);	
		}
	}

}
