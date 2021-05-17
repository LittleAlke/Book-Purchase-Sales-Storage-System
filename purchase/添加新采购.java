package 采购;
import 数据库.*;
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

public class 添加新采购 extends JPanel implements ActionListener{
	private JButton 保存,返回,供货商查询,库号查询,总金额;
	private JTextField bh,sm,zz,cbs,fy,dj,cbsj,jhl,jj,je,ghs,kh;
	private JComboBox hj,lb;
	Frame app = null;
	private JDialog ghsbh,kuhao;
	DefaultTableModel model1,model2,model9;
	JTable table1,table2,table9;
	public String hao1,hao2;
         public 添加新采购() {       	        	
        	 this.setLayout(null);   
        	 //位置（数字增大右下移动）（定的是左上角）、大小（右下拉伸）
        	 this.setBounds(10, 67, 1153, 732);
        	 Font f1=new Font(null, 0, 20);
        	 
        	 JLabel 线条1=new JLabel("----------------------------------------------------------------图书信息--------------------------------------------------------------");
        	 线条1.setBounds(50, 12, 1056, 35);
        	 线条1.setFont(f1);
        	 
        	 JLabel 编号=new JLabel("ISBN:");
        	 编号.setFont(f1);
        	 编号.setBounds(117, 80, 85, 35);
        	 bh=new JTextField();
        	 bh.setFont(f1);
        	 //bh.setOpaque(false);       	 
        	 bh.setBounds(187, 80, 200, 35);
        	
        	 JLabel 书名=new JLabel("书名:");
        	 书名.setFont(f1);
        	 书名.setBounds(117, 140, 85, 35);
        	 sm=new JTextField();
        	 sm.setFont(f1);
        	 sm.setBounds(187, 140, 200, 35);
        	 
        	 JLabel 作者=new JLabel("作者:");
        	 作者.setFont(f1);
        	 作者.setBounds(117, 200, 85, 35);
        	 zz=new JTextField();
        	 zz.setFont(f1);
        	 zz.setBounds(187, 200, 200, 35);
        	 
        	 JLabel 出版社=new JLabel("出版社:");
        	 出版社.setFont(f1);
        	 出版社.setBounds(117, 260, 85, 35);
        	 cbs=new JTextField();
        	 cbs.setFont(f1);
        	 cbs.setBounds(187, 260, 200, 35);
        	 
        	 JLabel 翻译=new JLabel("翻译:");
        	 翻译.setFont(f1);
        	 翻译.setBounds(500, 80, 85, 35);
        	 fy=new JTextField();
        	 fy.setFont(f1);
        	 fy.setBounds(600, 80, 200, 35);
        	 
        	 JLabel 定价=new JLabel("定价:");
        	 定价.setFont(f1);
        	 定价.setBounds(500, 140, 85, 35);
        	 dj=new JTextField();
        	 dj.setFont(f1);
        	 dj.setBounds(600, 140, 200, 35);
        	 
        	 JLabel 出版时间=new JLabel("出版时间:");
        	 出版时间.setFont(f1);
        	 出版时间.setBounds(500, 200, 100, 35);
        	 cbsj=new JTextField();
        	 cbsj.setFont(f1);
        	 cbsj.setBounds(600, 200, 200, 35);
        	 
        	 JLabel 图书类别=new JLabel("图书类别:");
        	 图书类别.setFont(f1);
        	 图书类别.setBounds(500, 260, 100, 35);
        	 String[]s= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        	 lb=new JComboBox(s);
        	 lb.setFont(f1);
        	 lb.setBounds(600, 260, 200, 35);     	 
        	 JLabel 线条2=new JLabel("----------------------------------------------------------------入库信息--------------------------------------------------------------");
        	 线条2.setBounds(50, 373, 1056, 35);
        	 线条2.setFont(f1);
        	 
        	 JLabel 进货量=new JLabel("采购进货量:");
        	 进货量.setFont(f1);
        	 进货量.setBounds(57, 420, 110, 35);
        	 jhl=new JTextField("0");
        	 jhl.setFont(f1);
        	 jhl.setBounds(177, 420, 100, 35);
        	 
        	 JLabel 进价=new JLabel("进价（元）:");
        	 进价.setFont(f1);
        	 进价.setBounds(426, 420, 110, 35);
        	 jj=new JTextField("0");
        	 jj.setFont(f1);
        	 jj.setBounds(546, 420, 100, 35);
          	         	         	         
        	 总金额=new JButton("总金额");
        	 总金额.setBounds(789, 420, 110, 35);
        	 总金额.addActionListener(this);
        	 je=new JTextField();
        	 je.setFont(f1);
        	 je.setBounds(909, 420, 100, 35);
        	 je.setEditable(false);
        	 
        	 JLabel 供货商=new JLabel("供货商编号:");
        	 供货商.setFont(f1);
        	 供货商.setBounds(57, 500, 110, 35);       	 
        	 ghs=new JTextField();
        	 ghs.setFont(f1);
        	 ghs.setBounds(177, 500, 100, 35);
        	 ghs.setEditable(false);
        	 
        	 JLabel 库号=new JLabel("库号:");
        	 库号.setFont(f1);
        	 库号.setBounds(426, 500, 110, 35);
        	 kh=new JTextField();
        	 kh.setFont(f1);
        	 kh.setBounds(546, 500, 100, 35);
        	 kh.setEditable(false);
        	 
        	 JLabel 货架=new JLabel("货架:");
        	 货架.setFont(f1);
        	 货架.setBounds(789, 500, 110, 35);
        	 String[]s1= {"1","2","3","4","5","6"};
        	 hj=new JComboBox(s1);
        	 hj.setFont(f1);
        	 hj.setBounds(909, 500, 100, 35);
        	 
        	 供货商查询=new JButton("选择");
        	 供货商查询.setBounds(281, 500, 85, 35);
        	 供货商查询.addActionListener(this);
        	 库号查询=new JButton("选择");
        	 库号查询.setBounds(650, 500, 85, 35);
        	 库号查询.addActionListener(this);
        	 返回=new JButton("返回");
        	 返回.setBounds(617, 643, 85, 35);
        	 保存=new JButton("保存");
        	 保存.addActionListener(this);
        	 保存.setBounds(217, 643, 85, 35);
        	       	 
      	     this.add(线条1);
        	 this.add(编号);
        	 this.add(bh);
        	 this.add(书名);
        	 this.add(sm);
        	 this.add(作者);
        	 this.add(zz);
        	 this.add(出版社);
        	 this.add(cbs);
        	 this.add(翻译);
        	 this.add(fy);
        	 this.add(定价);
        	 this.add(dj);
        	 this.add(出版时间);
        	 this.add(cbsj);
        	 this.add(图书类别);
        	 this.add(lb);
        	 this.add(线条2);
        	 this.add(进货量);
        	 this.add(jhl);
        	 this.add(进价);
        	 this.add(jj);
        	 this.add(总金额);
        	 this.add(je);
        	 this.add(供货商);
        	 this.add(ghs);
        	 this.add(库号);
        	 this.add(kh);
        	 this.add(货架);
        	 this.add(hj);
        	 this.add(供货商查询);
        	 this.add(库号查询);
        	 this.add(返回);
        	 this.add(保存);
        	this.setOpaque(false);
			this.setBackground(Color.red);
			this.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==供货商查询) {				
				JDialog ghsbh =new JDialog(app,"供货商选择",true);
				ghsbh.setSize(280,361);
				ghsbh.setLocation(770, 500);			
				String sql1="select 供货商名称,供货商编号 from providerinfo";
                 model1 = new  DefaultTableModel(new Query(sql1).getData(),new Query(sql1).getColName());  
                 table1 = new JTable(model1);
                 table1.setRowHeight(30);
                 table1.getTableHeader().setFont(new Font("Dialog", 0, 20));
                
                 JScrollPane sp=new JScrollPane(table1);          
                 table1.addMouseListener(new MouseAdapter() {
         			public void mouseClicked(MouseEvent e){
         				if (e.getButton() == MouseEvent.BUTTON1){
                      //获取你选中的行号（记录）
                      int count=table1.getSelectedRow();
                       //读取你获取行号的某一列的值（也就是字段）
                       hao1= table1.getValueAt(count, 1).toString(); 
                       ghsbh.dispose();
         				}
         			}
         		});
                 ghsbh.add(sp,BorderLayout.CENTER);
                 ghsbh.setVisible(true);      
                 ghs.setText(hao1);				
			}
			if (e.getSource()==库号查询 ) {				
				JDialog kuhao =new JDialog(app,"库号选择",true);
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
                      //获取你选中的行号（记录）
                      int count=table2.getSelectedRow();
                       //读取你获取行号的某一列的值（也就是字段）
                       hao1= table2.getValueAt(count, 0).toString();  
                       kuhao.dispose();
         				}
         			}
         		});
                 kuhao.add(sp,BorderLayout.CENTER);
                 kuhao.setVisible(true);
                 kh.setText(hao1);				
			}
			if (e.getSource()==总金额) {
			   int a = Integer.parseInt(jhl.getText())*Integer.parseInt(jj.getText());
				je.setText(""+a+"");	
			}
			if (e.getSource()==保存) {			
				String Name =登录.name;
				
				//增添采购单
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
						+ "(采购单号,图书编号,采购数量,进价,采购金额,采购日期,供货商编号,经办人,库号,货架)"
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
				
			    //判断新增的采购书以前有没有采购过
			    String sql9="select ISBN from inventoryinfo ";
			    model9 = new  DefaultTableModel(new Query(sql9).getData(),new Query(sql9).getColName());  
			    table9 = new JTable(model9);
			    int rows9 = table9.getRowCount();//获取表的行数
			    boolean b1=false;
			    String 接收=bh.getText(); 
			    for (int j=0;j<rows9;j++) {
			    	System.out.println(table9.getValueAt(j,0).toString());
			    	if (table9.getValueAt(j,0).toString().equals(接收)) {//读取你获取行号的某一列的值（也就是字段
						b1=true;
						break;
					}
			  }
			    System.out.println(b1);
			    //如果采购过
			    if (b1) {	    			    	    
				    //增添库存
				    Connection con12;
					Statement stmt12;
					String sqlstr12="update inventoryinfo set 历史库存量=历史库存量+"+jhl.getText()+" ,现库存量=现库存量+"+jhl.getText()+",库号="+kh.getText()+",货架="+hj.getSelectedItem()+" where inventoryinfo.ISBN ="+bh.getText()+"";				  
				   
					try {
						Add a3=new Add(sqlstr12);
					
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			    	
			    	
				} else {
					//增添图书信息
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
				    //增添库存
				    Connection con2;
					Statement stmt2;			   
				    String sqlstr2="insert into inventoryinfo"
							+ "(ISBN,书名,历史库存量,销售数量,现库存量,采购日期,库号,货架)"
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
			    	    
			    
			    //增添采购明细
			    Connection con3;
				Statement stmt3;
			    String sqlstr3="insert into buy"
						+ "(采购单单号,图书类别,书名,进价,数量,总金额,采购日期,是否付款,员工姓名)"
						+ "values("
						+ "'"+dh+"'"
								+ ","+"'"+lb.getSelectedItem()+"'"
								+ ","+"'"+sm.getText()+"'"
								+ ","+"'"+jj.getText()+"'"
								+ ","+"'"+jhl.getText()+"'"
								+ ","+"'"+je.getText()+"'"
								+ ","+"'"+date+"'"
								+ ","+"'"+"是"+"'"
								+ ","+"'"+Name+"'"								
								+ ")";
			    try {
					Add a4=new Add(sqlstr3);
				
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			    
			    JOptionPane.showMessageDialog(null, "添加成功！");			
				}
			
			
		}
}
