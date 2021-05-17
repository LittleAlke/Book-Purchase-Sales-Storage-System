package 报表;

import java.awt.*;
import java.awt.event.*;
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

import 数据库.Query;

public class 库存报表 extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton 打印,导出,查询;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  库存报表() {
		this.setLayout(null);
		this.setBounds(10, 67, 1153, 732);
		this.setOpaque(false);
		String sql1="select * from inventoryinfo";
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
		
        Font f1=new Font(null, 0, 20);
        JLabel 查询0= new JLabel("按仓库查询：");
        查询0.setFont(f1);
        查询0.setBounds(40, 30, 180, 35); 
        
        String []s1 = {"1","2","3","4"};  		   
   	    cx=new JComboBox(s1);
   	    cx.setFont(f1);
   	    cx.setBounds(230,30,100, 35); 
   	    查询=new JButton("查询");
        查询.setBounds(340, 30, 85, 35);
        查询.addActionListener(this);
   	    
        打印=new JButton("打印");
        打印.setBounds(40, 70, 85, 35);
        打印.addActionListener(this);
        导出=new JButton("导出");
        导出.addActionListener(this);
        导出.setBounds(130, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("图书库存信息");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        
        
        this.add(cx);
        this.add(查询0);
        this.add(查询);
        this.add(导出);
        this.add(打印);
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {					
		if (e.getSource()==查询) {
			pz.setVisible(false);
			pz.removeAll();
			String s1= (String)cx.getSelectedItem();//强制转换为字符串类型	
			String sql2=" SELECT*  FROM inventoryinfo where (库号)="+cx.getSelectedItem()+"";
	System.out.println(s1);
	System.out.println(cx.getSelectedItem());
			model2 = new  DefaultTableModel(new Query(sql2).getData(),new Query(sql2).getColName());  
	        table2 = new JTable(model2);
	        table2.setEnabled(false);
	        table2.setOpaque(false);
	        table2.setRowHeight(30);
	        p2 =new JScrollPane(table2);
	        int rows2 = table2.getRowCount();
	   System.out.println(table2.getRowCount());
	        int rowz2;
	        if (26+rows2*31<508) {
	        	rowz2=(26+rows2*31);
			}else {rowz2=508;}    
	   System.out.println(rowz2);
			p2.setBounds(0, 0, 1073,rowz2);//508
			p2.setOpaque(false);
			p2.getViewport().setOpaque(false);
			p2.setVisible(true);
			pz.add(p2);
			pz.setVisible(true);
			}
		if (e.getSource()==导出) {	
			Frame f5=new Frame();
			     FileDialog fd =new FileDialog(f5, "保存流水记录", FileDialog.SAVE);
				 //FileDialog fd = new FileDialog(this, "保存流水记录", FileDialog.SAVE);
				 fd.setLocation(400, 250);
			     fd.setVisible(true);  
			     String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
		         try {
		        	 导出表 oDao = new 导出表();
		        	 oDao.exportTable(table1, new File(stringfile));
		         } catch (IOException ex) {
		             System.out.println(ex.getMessage());
		             ex.printStackTrace();
		         }		
		}
		if (e.getSource()==打印) {	
			Frame f5=new Frame();
			     FileDialog fd =new FileDialog(f5, "保存流水记录", FileDialog.SAVE);
				 //FileDialog fd = new FileDialog(this, "保存流水记录", FileDialog.SAVE);
				 fd.setLocation(400, 250);
			     fd.setVisible(true);  
			     String stringfile = fd.getDirectory()+fd.getFile()+".txt";  
		         try {
		        	 导出表 oDao = new 导出表();
		        	 oDao.exportTable(table1, new File(stringfile));
		         } catch (IOException ex) {
		             System.out.println(ex.getMessage());
		             ex.printStackTrace();
		         }		
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
