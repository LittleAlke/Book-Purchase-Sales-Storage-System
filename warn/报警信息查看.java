package ����;

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

import Alke.������;
import Alke.��¼;
import ����.������;
import ���ݿ�.Query;

public class ������Ϣ�鿴 extends JPanel implements ActionListener {
      private JScrollPane p1,p2;
      private JPanel pz;
      private JButton ���,����,��ѯ;
      private JComboBox cx;
      DefaultTableModel model1,model2;
  	  private JTable table1,table2;
	  public  ������Ϣ�鿴() {
		this.setLayout(null);
		this.setBounds(10, 67, 1153, 732);
		this.setOpaque(false);
		String sql1="select inventoryinfo.ISBN,bookinfo.bookName,bookinfo.press,inventoryinfo.�ֿ����,"
				+ "alarm.��������   from inventoryinfo,alarm,bookinfo where inventoryinfo.ISBN=alarm.ISBN and "
				+ "bookinfo.ISBN=alarm.ISBN and inventoryinfo.�ֿ����<=alarm.��������";
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
        ����=new JButton("����");
        ����.addActionListener(this);
        ����.setBounds(40, 70, 85, 35);
        Font f2=new Font(null, 0, 30);
        JLabel title =new JLabel("������Ϣ");
        title.setFont(f2);
        title.setBounds(446, 74, 260, 36);
        this.add(����);    
		this.add(pz);
		this.add(title);
		this.setOpaque(false);
		this.setBackground(Color.red);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {					
		if (e.getSource()==����) {	
			Frame f5=new Frame();
			     FileDialog fd =new FileDialog(f5, "������ˮ��¼", FileDialog.SAVE);
				 //FileDialog fd = new FileDialog(this, "������ˮ��¼", FileDialog.SAVE);
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
