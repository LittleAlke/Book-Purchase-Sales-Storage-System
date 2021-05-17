package 人员;

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

import Alke.主界面;
import Alke.登录;
import 数据库.Query;

public class 供货商信息 extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton 添加,导出,查询;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  供货商信息() {
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
        JLabel 查询0= new JLabel("查看内容：按月查询：");
        查询0.setFont(f1);
        查询0.setBounds(40, 30, 180, 35); 
        //双重循环给数组分配空间（假设从2018年1月投入使用）
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
		//年份外循环，月份内循环给数组赋值
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
   	    查询=new JButton("查询");
        查询.setBounds(340, 30, 85, 35);
        查询.addActionListener(this);
   	    
        添加=new JButton("添加新供货商");
        添加.addActionListener(this);
        添加.setBounds(40, 70, 120, 35);
        导出=new JButton("导出");
        导出.setBounds(130, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("供货商信息");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        
        
        //this.add(cx);
        //this.add(查询0);
        //this.add(查询);
        //this.add(导出);
        this.add(添加);
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {					
		if (e.getSource()==添加) {
			主界面.pCenter.setVisible(false);			
			主界面.pCenter.removeAll();			              
			主界面.pCenter.add(new 添加供货商());		           
			主界面.pCenter.setVisible(true);		
			}
		}



	private String toString(Object selectedItem) {
		// TODO Auto-generated method stub
		return null;
	}

}


//System.out.println(cx.getSelectedItem());     //object类型输出
//System.out.println(toString(cx.getSelectedItem()));//强制转换失败，值变为null
//System.out.println((String)cx.getSelectedItem());  //强制转换成功
//System.out.println(String.valueOf(cx.getSelectedItem()));//强制转换成功
