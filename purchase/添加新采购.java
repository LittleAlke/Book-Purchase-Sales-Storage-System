package �ɹ�;
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

public class ����²ɹ� extends JPanel implements ActionListener{
	private JButton ����,����,�����̲�ѯ,��Ų�ѯ,�ܽ��;
	private JTextField bh,sm,zz,cbs,fy,dj,cbsj,jhl,jj,je,ghs,kh;
	private JComboBox hj,lb;
	Frame app = null;
	private JDialog ghsbh,kuhao;
	DefaultTableModel model1,model2,model9;
	JTable table1,table2,table9;
	public String hao1,hao2;
         public ����²ɹ�() {       	        	
        	 this.setLayout(null);   
        	 //λ�ã��������������ƶ��������������Ͻǣ�����С���������죩
        	 this.setBounds(10, 67, 1153, 732);
        	 Font f1=new Font(null, 0, 20);
        	 
        	 JLabel ����1=new JLabel("----------------------------------------------------------------ͼ����Ϣ--------------------------------------------------------------");
        	 ����1.setBounds(50, 12, 1056, 35);
        	 ����1.setFont(f1);
        	 
        	 JLabel ���=new JLabel("ISBN:");
        	 ���.setFont(f1);
        	 ���.setBounds(117, 80, 85, 35);
        	 bh=new JTextField();
        	 bh.setFont(f1);
        	 //bh.setOpaque(false);       	 
        	 bh.setBounds(187, 80, 200, 35);
        	
        	 JLabel ����=new JLabel("����:");
        	 ����.setFont(f1);
        	 ����.setBounds(117, 140, 85, 35);
        	 sm=new JTextField();
        	 sm.setFont(f1);
        	 sm.setBounds(187, 140, 200, 35);
        	 
        	 JLabel ����=new JLabel("����:");
        	 ����.setFont(f1);
        	 ����.setBounds(117, 200, 85, 35);
        	 zz=new JTextField();
        	 zz.setFont(f1);
        	 zz.setBounds(187, 200, 200, 35);
        	 
        	 JLabel ������=new JLabel("������:");
        	 ������.setFont(f1);
        	 ������.setBounds(117, 260, 85, 35);
        	 cbs=new JTextField();
        	 cbs.setFont(f1);
        	 cbs.setBounds(187, 260, 200, 35);
        	 
        	 JLabel ����=new JLabel("����:");
        	 ����.setFont(f1);
        	 ����.setBounds(500, 80, 85, 35);
        	 fy=new JTextField();
        	 fy.setFont(f1);
        	 fy.setBounds(600, 80, 200, 35);
        	 
        	 JLabel ����=new JLabel("����:");
        	 ����.setFont(f1);
        	 ����.setBounds(500, 140, 85, 35);
        	 dj=new JTextField();
        	 dj.setFont(f1);
        	 dj.setBounds(600, 140, 200, 35);
        	 
        	 JLabel ����ʱ��=new JLabel("����ʱ��:");
        	 ����ʱ��.setFont(f1);
        	 ����ʱ��.setBounds(500, 200, 100, 35);
        	 cbsj=new JTextField();
        	 cbsj.setFont(f1);
        	 cbsj.setBounds(600, 200, 200, 35);
        	 
        	 JLabel ͼ�����=new JLabel("ͼ�����:");
        	 ͼ�����.setFont(f1);
        	 ͼ�����.setBounds(500, 260, 100, 35);
        	 String[]s= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        	 lb=new JComboBox(s);
        	 lb.setFont(f1);
        	 lb.setBounds(600, 260, 200, 35);     	 
        	 JLabel ����2=new JLabel("----------------------------------------------------------------�����Ϣ--------------------------------------------------------------");
        	 ����2.setBounds(50, 373, 1056, 35);
        	 ����2.setFont(f1);
        	 
        	 JLabel ������=new JLabel("�ɹ�������:");
        	 ������.setFont(f1);
        	 ������.setBounds(57, 420, 110, 35);
        	 jhl=new JTextField("0");
        	 jhl.setFont(f1);
        	 jhl.setBounds(177, 420, 100, 35);
        	 
        	 JLabel ����=new JLabel("���ۣ�Ԫ��:");
        	 ����.setFont(f1);
        	 ����.setBounds(426, 420, 110, 35);
        	 jj=new JTextField("0");
        	 jj.setFont(f1);
        	 jj.setBounds(546, 420, 100, 35);
          	         	         	         
        	 �ܽ��=new JButton("�ܽ��");
        	 �ܽ��.setBounds(789, 420, 110, 35);
        	 �ܽ��.addActionListener(this);
        	 je=new JTextField();
        	 je.setFont(f1);
        	 je.setBounds(909, 420, 100, 35);
        	 je.setEditable(false);
        	 
        	 JLabel ������=new JLabel("�����̱��:");
        	 ������.setFont(f1);
        	 ������.setBounds(57, 500, 110, 35);       	 
        	 ghs=new JTextField();
        	 ghs.setFont(f1);
        	 ghs.setBounds(177, 500, 100, 35);
        	 ghs.setEditable(false);
        	 
        	 JLabel ���=new JLabel("���:");
        	 ���.setFont(f1);
        	 ���.setBounds(426, 500, 110, 35);
        	 kh=new JTextField();
        	 kh.setFont(f1);
        	 kh.setBounds(546, 500, 100, 35);
        	 kh.setEditable(false);
        	 
        	 JLabel ����=new JLabel("����:");
        	 ����.setFont(f1);
        	 ����.setBounds(789, 500, 110, 35);
        	 String[]s1= {"1","2","3","4","5","6"};
        	 hj=new JComboBox(s1);
        	 hj.setFont(f1);
        	 hj.setBounds(909, 500, 100, 35);
        	 
        	 �����̲�ѯ=new JButton("ѡ��");
        	 �����̲�ѯ.setBounds(281, 500, 85, 35);
        	 �����̲�ѯ.addActionListener(this);
        	 ��Ų�ѯ=new JButton("ѡ��");
        	 ��Ų�ѯ.setBounds(650, 500, 85, 35);
        	 ��Ų�ѯ.addActionListener(this);
        	 ����=new JButton("����");
        	 ����.setBounds(617, 643, 85, 35);
        	 ����=new JButton("����");
        	 ����.addActionListener(this);
        	 ����.setBounds(217, 643, 85, 35);
        	       	 
      	     this.add(����1);
        	 this.add(���);
        	 this.add(bh);
        	 this.add(����);
        	 this.add(sm);
        	 this.add(����);
        	 this.add(zz);
        	 this.add(������);
        	 this.add(cbs);
        	 this.add(����);
        	 this.add(fy);
        	 this.add(����);
        	 this.add(dj);
        	 this.add(����ʱ��);
        	 this.add(cbsj);
        	 this.add(ͼ�����);
        	 this.add(lb);
        	 this.add(����2);
        	 this.add(������);
        	 this.add(jhl);
        	 this.add(����);
        	 this.add(jj);
        	 this.add(�ܽ��);
        	 this.add(je);
        	 this.add(������);
        	 this.add(ghs);
        	 this.add(���);
        	 this.add(kh);
        	 this.add(����);
        	 this.add(hj);
        	 this.add(�����̲�ѯ);
        	 this.add(��Ų�ѯ);
        	 this.add(����);
        	 this.add(����);
        	this.setOpaque(false);
			this.setBackground(Color.red);
			this.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==�����̲�ѯ) {				
				JDialog ghsbh =new JDialog(app,"������ѡ��",true);
				ghsbh.setSize(280,361);
				ghsbh.setLocation(770, 500);			
				String sql1="select ����������,�����̱�� from providerinfo";
                 model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
                 table1 = new JTable(model1);
                 table1.setRowHeight(30);
                 table1.getTableHeader().setFont(new Font("Dialog", 0, 20));
                
                 JScrollPane sp=new JScrollPane(table1);          
                 table1.addMouseListener(new MouseAdapter() {
         			public void mouseClicked(MouseEvent e){
         				if (e.getButton() == MouseEvent.BUTTON1){
                      //��ȡ��ѡ�е��кţ���¼��
                      int count=table1.getSelectedRow();
                       //��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                       hao1= table1.getValueAt(count, 1).toString(); 
                       ghsbh.dispose();
         				}
         			}
         		});
                 ghsbh.add(sp,BorderLayout.CENTER);
                 ghsbh.setVisible(true);      
                 ghs.setText(hao1);				
			}
			if (e.getSource()==��Ų�ѯ ) {				
				JDialog kuhao =new JDialog(app,"���ѡ��",true);
				kuhao.setSize(280,361);
				kuhao.setLocation(770, 500);			
				String sql2="select * from storehouse";
                 model2 = new  DefaultTableModel(new Query(sql2).getData(),new Query(sql2).getColName());  
                 table2 = new JTable(model2);
                 table2.setRowHeight(30);
                 JScrollPane sp=new JScrollPane(table2);          
                 table2.addMouseListener(new MouseAdapter() {
         			public void mouseClicked(MouseEvent e){
         				if (e.getButton() == MouseEvent.BUTTON1){
                      //��ȡ��ѡ�е��кţ���¼��
                      int count=table2.getSelectedRow();
                       //��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                       hao1= table2.getValueAt(count, 0).toString();  
                       kuhao.dispose();
         				}
         			}
         		});
                 kuhao.add(sp,BorderLayout.CENTER);
                 kuhao.setVisible(true);
                 kh.setText(hao1);				
			}
			if (e.getSource()==�ܽ��) {
			   int a = Integer.parseInt(jhl.getText())*Integer.parseInt(jj.getText());
				je.setText(""+a+"");	
			}
			if (e.getSource()==����) {			
				String Name =��¼.name;
				
				//����ɹ���
			    Connection con1;
				Statement stmt1;
				Calendar cal=Calendar.getInstance();      
				int y=cal.get(Calendar.YEAR);      
				int m=cal.get(Calendar.MONTH)+1;      
				int d=cal.get(Calendar.DATE);      
				int h=cal.get(Calendar.HOUR_OF_DAY);      
				int mi=cal.get(Calendar.MINUTE);      
				int s=cal.get(Calendar.SECOND);
				String dh="P"+m+d+h+mi+s;
				String date=y+"-"+m+"-"+d;
			    String sqlstr1="insert into purchasedetail"
						+ "(�ɹ�����,ͼ����,�ɹ�����,����,�ɹ����,�ɹ�����,�����̱��,������,���,����)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+bh.getText()+"'"
								+ ","+"'"+jhl.getText()+"'"
								+ ","+"'"+jj.getText()+"'"
								+ ","+"'"+je.getText()+"'"
								+ ","+"'"+date+"'"
								+ ","+"'"+ghs.getText()+"'"
								+ ","+"'"+Name+"'"
								+ ","+"'"+kh.getText()+"'"
								+ ","+"'"+hj.getSelectedItem()+"'"
								+ ")";
			    try {
					Add a2=new Add(sqlstr1);
				
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				
			    //�ж������Ĳɹ�����ǰ��û�вɹ���
			    String sql9="select ISBN from inventoryinfo ";
			    model9 = new  DefaultTableModel(new Query(sql9).getData(),new Query(sql9).getColName());  
			    table9 = new JTable(model9);
			    int rows9 = table9.getRowCount();//��ȡ�������
			    boolean b1=false;
			    String ����=bh.getText(); 
			    for (int j=0;j<rows9;j++) {
			    	System.out.println(table9.getValueAt(j,0).toString());
			    	if (table9.getValueAt(j,0).toString().equals(����)) {//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶ�
						b1=true;
						break;
					}
			  }
			    System.out.println(b1);
			    //����ɹ���
			    if (b1) {	    			    	    
				    //������
				    Connection con12;
					Statement stmt12;
					String sqlstr12="update inventoryinfo set ��ʷ�����=��ʷ�����+"+jhl.getText()+" ,�ֿ����=�ֿ����+"+jhl.getText()+",���="+kh.getText()+",����="+hj.getSelectedItem()+" where inventoryinfo.ISBN ="+bh.getText()+"";				  
				   
					try {
						Add a3=new Add(sqlstr12);
					
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			    	
			    	
				} else {
					//����ͼ����Ϣ
					Connection con;
					Statement stmt;			   
				    String sqlstr="insert into bookinfo"
							+ "(ISBN,bookName,author,translator,press,publicationDate,classification,pricing)"
							+ "values("
							+ "'"+bh.getText()+"'"
									+ ","+"'"+sm.getText()+"'"
									+ ","+"'"+zz.getText()+"'"
									+ ","+"'"+fy.getText()+"'"
									+ ","+"'"+cbs.getText()+"'"
									+ ","+"'"+cbsj.getText()+"'"
									+ ","+"'"+lb.getSelectedItem()+"'"
									+ ","+"'"+dj.getText()+"'"
									+ ")";
				    try {
						Add a1=new Add(sqlstr);
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		    	    
				    //������
				    Connection con2;
					Statement stmt2;			   
				    String sqlstr2="insert into inventoryinfo"
							+ "(ISBN,����,��ʷ�����,��������,�ֿ����,�ɹ�����,���,����)"
							+ "values("
							+ "'"+bh.getText()+"'"
									+ ","+"'"+sm.getText()+"'"
									+ ","+"'"+jhl.getText()+"'"
									+ ","+"'"+0+"'"
									+ ","+"'"+jhl.getText()+"'"
									+ ","+"'"+date+"'"
									+ ","+"'"+kh.getText()+"'"
									+ ","+"'"+hj.getSelectedItem()+"'"								
									+ ")";
				    try {
						Add a3=new Add(sqlstr2);
					
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				}
			    	    
			    
			    //����ɹ���ϸ
			    Connection con3;
				Statement stmt3;
			    String sqlstr3="insert into buy"
						+ "(�ɹ�������,ͼ�����,����,����,����,�ܽ��,�ɹ�����,�Ƿ񸶿�,Ա������)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+lb.getSelectedItem()+"'"
								+ ","+"'"+sm.getText()+"'"
								+ ","+"'"+jj.getText()+"'"
								+ ","+"'"+jhl.getText()+"'"
								+ ","+"'"+je.getText()+"'"
								+ ","+"'"+date+"'"
								+ ","+"'"+"��"+"'"
								+ ","+"'"+Name+"'"								
								+ ")";
			    try {
					Add a4=new Add(sqlstr3);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    
			    JOptionPane.showMessageDialog(null, "��ӳɹ���");			
				}
			
			
		}
}
