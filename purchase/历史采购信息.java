package �ɹ�;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ����.������;
import ���ݿ�.Query;

public class ��ʷ�ɹ���Ϣ extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton ��ӡ,����,��ѯ;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  ��ʷ�ɹ���Ϣ() {
		this.setLayout(null);
		this.setBounds(10, 67, 1153, 732);
		this.setOpaque(false);
		String sql1="select * from purchasedetail";
        model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
        table1 = new JTable(model1);
        table1.setEnabled(false);
        table1.setOpaque(false);
        table1.setRowHeight(30);
        //��ȡ�������
        int rows = table1.getRowCount();
        int rowz1;
        if (26+rows*31<508) {
        	rowz1=(26+rows*31);
		}else {rowz1=508;}        		                 
        p1 =new JScrollPane(table1);
		p1.setBounds(0, 0, 1073,rowz1);
		p1.setOpaque(false);
		p1.getViewport().setOpaque(false);
		
		pz=new JPanel();
		pz.setLayout(null);
		pz.setBounds(40, 110, 1073, 508);
		pz.setOpaque(false);
		pz.add(p1);
		
        Font f1=new Font(null, 0, 18);
        JLabel ��ѯ0= new JLabel("�鿴���ݣ����²�ѯ��");
        ��ѯ0.setFont(f1);
        ��ѯ0.setBounds(40, 30, 180, 35); 
        //˫��ѭ�����������ռ䣨�����2018��1��Ͷ��ʹ�ã�
        Calendar cal=Calendar.getInstance();      
		int y=cal.get(Calendar.YEAR);      
		int m=cal.get(Calendar.MONTH)+1;           		
		int hangshu=0,m0=m,y0=y;   
        for (int i=0;i<=y-2018;i++) {
			for (int j = 0; m0>0&&j<m0;) {
				m0--;
				hangshu +=1;}	
			m0=12;
			y0--;}		
		int k=0,m1=m,y1=y; 
		//�����ѭ�����·���ѭ�������鸳ֵ
        String []s1 = new String[hangshu];
        for (int i=0;i<=y-2018;i++) {
			for (int j = 0; m1>0&&j<m1;) {			  
				s1[k]= y1+"-"+m1;
				m1--;
				k+=1;}			
			m1=12;
			y1--;} 		   
   	    cx=new JComboBox(s1);
   	    cx.setFont(f1);
   	    cx.setBounds(230,30,100, 35); 
   	    ��ѯ=new JButton("��ѯ");
        ��ѯ.setBounds(340, 30, 85, 35);
        ��ѯ.addActionListener(this);
   	    
        ��ӡ=new JButton("��ӡ");
        ��ӡ.setBounds(40, 70, 85, 35);
        ��ӡ.addActionListener(this);
        ����=new JButton("����");
        ����.addActionListener(this);
        ����.setBounds(130, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("��ʷ�ɹ���Ϣ");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        
        
        this.add(cx);
        this.add(��ѯ0);
        this.add(��ѯ);
        this.add(����);
        this.add(��ӡ);
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {					
		if (e.getSource()==��ѯ) {
			pz.setVisible(false);
			pz.removeAll();
			String s1= (String)cx.getSelectedItem();//ǿ��ת��Ϊ�ַ�������
			String nian=s1.substring(0,s1.indexOf('-'));//��ȡ���
			String yue=s1.substring(s1.indexOf('-')+1);//��ȡ�·�	
			String sql2=" SELECT*  FROM purchasedetail where Year(�ɹ�����)="+nian+"&&Month(�ɹ�����) ="+yue+"  ";
	        model2 = new  DefaultTableModel(new Query(sql2).getData(),new Query(sql2).getColName());  
	        table2 = new JTable(model2);
	        table2.setEnabled(false);
	        table2.setOpaque(false);
	        table2.setRowHeight(30);
	        p2 =new JScrollPane(table2);
	        int rows2 = table2.getRowCount();
	        int rowz2;
	        if (26+rows2*31<508) {
	        	rowz2=(26+rows2*31);
			}else {rowz2=508;}        
			p2.setBounds(0, 0, 1073,rowz2);//508
			p2.setOpaque(false);
			p2.getViewport().setOpaque(false);
			p2.setVisible(true);
			pz.add(p2);
			pz.setVisible(true);
			}
		if (e.getSource()==����) {	
			Frame f5=new Frame();
			     FileDialog fd =new FileDialog(f5, "������ˮ��¼", FileDialog.SAVE);	
				 fd.setLocation(400, 250);
			     fd.setVisible(true);  
			     String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
		         try {
		        	 ������ oDao = new ������();
		        	 oDao.exportTable(table1, new File(stringfile));
		         } catch (IOException ex) {
		             System.out.println(ex.getMessage());
		             ex.printStackTrace();
		         }		
		}
		if (e.getSource()==��ӡ) {				
			try {
				table1.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}		
		}
	}



	private String toString(Object selectedItem) {
		// TODO Auto-generated method stub
		return null;
	}

}


//System.out.println(cx.getSelectedItem());     //object�������
//System.out.println(toString(cx.getSelectedItem()));//ǿ��ת��ʧ�ܣ�ֵ��Ϊnull
//System.out.println((String)cx.getSelectedItem());  //ǿ��ת���ɹ�
//System.out.println(String.valueOf(cx.getSelectedItem()));//ǿ��ת���ɹ�
