package ��Ա;

import ���ݿ�.*;
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

public class ��������� extends JPanel implements ActionListener{
	private JTextField gsmc,yx,gsdz,yb,gsdh,name,name2,tel,bankID;
	private JComboBox bank;
	private JButton �����������Ϣ,����,����;
	private JRadioButton ��,Ů;
	private ButtonGroup sex;
	 public ���������() {
		this.setLayout(null);	
      	this.setBounds(10, 67, 1153, 732);     	
      	Font f1=new Font(null, 0, 20);
      	
      	�����������Ϣ=new JButton("�����������Ϣ");
      	�����������Ϣ.setBounds(50, 30, 120, 35);
      	�����������Ϣ.addActionListener(this);
      	
      	JLabel ����1=new JLabel("--------------------------------------------------------------�����������--------------------------------------------------------------");  
      	����1.setBounds(50, 62, 1056, 35);
   	    ����1.setFont(f1);
      	
   	    JLabel ��˾����=new JLabel("��˾����:");
   	    ��˾����.setFont(f1);
   	    ��˾����.setBounds(117, 130, 125, 35);
	    gsmc=new JTextField();
	    gsmc.setFont(f1);
	    gsmc.setBounds(227, 130, 200, 35);
	
	    JLabel ����=new JLabel("����:");
	    ����.setFont(f1);
	    ����.setBounds(580, 130, 85, 35);
	    yx=new JTextField();
	    yx.setFont(f1);
	    yx.setBounds(680, 130, 200, 35);
	    
	    JLabel ��˾��ַ=new JLabel("��˾��ַ:");
	    ��˾��ַ.setFont(f1);
	    ��˾��ַ.setBounds(117, 190, 125, 35);
	    gsdz=new JTextField();
	    gsdz.setFont(f1);
	    gsdz.setBounds(227, 190, 200, 35);
	    
	    JLabel �ʱ�=new JLabel("�ʱ�:");
	    �ʱ�.setFont(f1);
	    �ʱ�.setBounds(580, 190, 85, 35);
	    yb=new JTextField();
	    yb.setFont(f1);
	    yb.setBounds(680, 190, 200, 35);
	    
	    JLabel ��˾�绰=new JLabel("��˾�绰:");
   	    ��˾�绰.setFont(f1);
   	    ��˾�绰.setBounds(117, 250, 125, 35);
   	    gsdh=new JTextField();
   	    gsdh.setFont(f1);
   	    gsdh.setBounds(227, 250, 200, 35);

   	    JLabel ����������=new JLabel("����������:");
   	    ����������.setFont(f1);
     	����������.setBounds(117, 310, 125, 35);
	    name=new JTextField();
	    name.setFont(f1);
	    name.setBounds(227, 310, 200, 35);    
   	    
	    JLabel �Ա�=new JLabel("�������Ա�:");
   	    �Ա�.setFont(f1);
     	�Ա�.setBounds(580, 310, 125, 35);
     	��=new JRadioButton("��");
     	��.setFont(f1);
     	Ů=new JRadioButton("Ů");
     	Ů.setFont(f1);     
     	��.setBounds(700, 310, 100, 35);
     	Ů.setBounds(800, 310, 100, 35);
     	sex=new ButtonGroup();
     	sex.add(��);
     	sex.add(Ů);
     	
     	JLabel �����˳�ν=new JLabel("�����˳�ν:");
   	    �����˳�ν.setFont(f1);
     	�����˳�ν.setBounds(117, 370, 125, 35);
	    name2=new JTextField();
	    name2.setFont(f1);
	    name2.setBounds(227, 370, 200, 35);
	    
	    JLabel �����˵绰=new JLabel("�����˵绰:");
   	    �����˵绰.setFont(f1);
     	�����˵绰.setBounds(580, 370, 125, 35);
	    tel=new JTextField();
	    tel.setFont(f1);
	    tel.setBounds(690, 370, 200, 35);
	    
	    JLabel �տ�����=new JLabel("�տ�����:");
	    �տ�����.setFont(f1);
	    �տ�����.setBounds(117, 430, 125, 35);	    
	    String[]banktype= {"��������","��������","ũҵ����","�й�����","�ʴ�����","��ͨ����"};
   	    bank=new JComboBox(banktype);
        bank.setFont(f1);
     	bank.setBounds(227, 430, 200, 35);
        
     	JLabel ���п���=new JLabel("���п���:");
   	    ���п���.setFont(f1);
     	���п���.setBounds(580, 430, 125, 35);
	    bankID=new JTextField();
	    bankID.setFont(f1);
	    bankID.setBounds(690, 430, 200, 35);
		   
   	    ����=new JButton("����");
	    ����.setBounds(617, 643, 85, 35);
	    ����=new JButton("����");
	    ����.addActionListener(this);
	    ����.setBounds(217, 643, 85, 35);
	    
	    this.add(�����������Ϣ);
		this.add(����1);
		this.add(��˾��ַ);
		this.add(gsmc);
		this.add(��˾����);
		this.add(yx);
		this.add(�ʱ�);
		this.add(gsdz);
		this.add(����);
		this.add(yb);
		this.add(��˾�绰);
		this.add(gsdh);
		this.add(����������);
		this.add(name);
		this.add(�Ա�);
		this.add(��);
		this.add(Ů);
		this.add(�����˳�ν);
		this.add(name2);
		this.add(�����˵绰);
		this.add(tel);
		//this.add(�տ�����);
		//this.add(bank);
		//this.add(���п���);
		//this.add(bankID);
		this.add(����);
   	    this.add(����);
      	this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);   
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==����) {
			String xb = null;
			if (��.isSelected()) {
				xb=��.getText();}		
			if (Ů.isSelected()) {
				xb=Ů.getText();}					
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
			String Name =��¼.name;
		    String sqlstr1="insert into sellerinfo"
					+ "(�����̱��,����������,����,��ַ,�ʱ�,�����̵绰,����������,�Ա�,��ν,�绰)"
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
		    JOptionPane.showMessageDialog(null, "��ӳɹ���");			
			}
		if (e.getSource()==�����������Ϣ) {
			������.pCenter.setVisible(false);			
			������.pCenter.removeAll();			              
			������.pCenter.add(new ��������Ϣ());		           
			������.pCenter.setVisible(true);	
		}
	}

}
