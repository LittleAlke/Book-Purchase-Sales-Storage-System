package 报警;

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

import Alke.主界面;
import Alke.登录;
import 报表.导出表;
import 数据库.Query;

public class 报警信息查看 extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton 添加,导出,查询;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  报警信息查看() {
		this.setLayout(null);
		this.setBounds(10, 67, 1153, 732);
		this.setOpaque(false);
		String sql1="select inventoryinfo.ISBN,bookinfo.bookName,bookinfo.press,inventoryinfo.现库存量,"
				+ "alarm.报警数量   from inventoryinfo,alarm,bookinfo where inventoryinfo.ISBN=alarm.ISBN and "
				+ "bookinfo.ISBN=alarm.ISBN and inventoryinfo.现库存量<=alarm.报警数量";
        model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
        table1 = new JTable(model1);
        table1.setEnabled(false);
        table1.setOpaque(false); 
        table1.setRowHeight(30);
        int rows = table1.getRowCount();
        int rowz1;
        if (26+rows*31<508) {
        	rowz1=(29+rows*31);
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
        导出=new JButton("导出");
        导出.addActionListener(this);
        导出.setBounds(40, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("报警信息");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        this.add(导出);    
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {					
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
