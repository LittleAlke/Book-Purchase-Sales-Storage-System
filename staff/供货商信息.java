package ��Ա;

import java.awt.*;
import java.awt.event.*;
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

import Alke.������;
import Alke.��¼;
import ���ݿ�.Query;

public class ��������Ϣ extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton ���,����,��ѯ;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  ��������Ϣ() {
		this.setLayout(null);
		this.setBounds(10, 67, 1153, 732);
		this.setOpaque(false);
		String sql1="select * from providerinfo";
        model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
        table1 = new JTable(model1);
        table1.setEnabled(false);
        table1.setOpaque(false); 
        table1.setRowHeight(30);
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
		int m=cal.get(Calendar.MONTH);           		
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
   	    
        ���=new JButton("����¹�����");
        ���.addActionListener(this);
        ���.setBounds(40, 70, 120, 35);
        ����=new JButton("����");
        ����.setBounds(130, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("��������Ϣ");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        
        
        //this.add(cx);
        //this.add(��ѯ0);
        //this.add(��ѯ);
        //this.add(����);
        this.add(���);
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {					
		if (e.getSource()==���) {
			������.pCenter.setVisible(false);			
			������.pCenter.removeAll();			              
			������.pCenter.add(new ��ӹ�����());		           
			������.pCenter.setVisible(true);		
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
