package Alke;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;

import 人员.添加供货商;
import 人员.销售商信息;
import 客服.ChatClient;
import 客服.ChatServer;
import 人员.供货商信息;
import 库存.图书库存信息;
import 报表.库存报表;
import 报表.采购报表;
import 报表.销售报表;
import 报警.报警信息查看;
import 报警.报警设置;
import 账款.采购费用明细;
import 账款.销售费用明细;
import 采购.历史采购信息;
import 采购.添加新采购;
import 销售.历史销售信息;
import 销售.添加新销售;

public class 主界面  implements ActionListener{
	public static  JPanel pCenter;
	private JPanel p5;
	private JButton 采购1,采购2,销售1,销售2,库存1,人员1,人员2,账款1,账款2,报警1,报警2,报表1,报表2,报表3,客服;
	public 主界面 () {
		//使界面更圆润
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }	
		JFrame app=new JFrame();
		
		app.setTitle("潘黎明旗下潘氏集团图书馆管理系统");
		Container c=app.getContentPane(); 
		  //背景图片
		    ImageIcon img=new ImageIcon("G:/图书进销存管理系统/图片/烟雨1.jpg");
		    JLabel jll=new JLabel(img);
		    jll.setBounds(0,-275, img.getIconWidth(),img.getIconWidth());//2：（0,-195）3：（0,-300）
		    app.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
		    ((JPanel)c).setOpaque(false);
		  //设置图标
		    Image icon = Toolkit.getDefaultToolkit().getImage("G:/图书进销存管理系统/图片/神盾局2.jpg");
		    app.setIconImage(icon);
		   //容器布局
		  c.setLayout(new BorderLayout());
		  //最上面放图的面板
		  JPanel ps=new JPanel();
		 // ps.add(new Label(""));
		  ps.setOpaque(false);		  
		  c.add(ps,BorderLayout.NORTH);  
		  //最下面的东西
		  JPanel px=new JPanel(new GridLayout(1,1));
		  px.setOpaque(false);
		  //px.setBackground(Color.LIGHT_GRAY);
		  c.add(px,BorderLayout.SOUTH);
		  px.add(new Label("                 郑州轻工业大学",JLabel.CENTER));
		  px.add(new Label("              软件学院",JLabel.CENTER));
		  px.add(new Label("              卡拉肖可潘",JLabel.CENTER));
		  //左边
		  JPanel pLeft =new JPanel(new GridLayout(10,1,0,25));
		  pLeft.setOpaque(false);
		  //各个按钮及其菜单选项
		  JPopupMenu 采购菜单=new JPopupMenu();
		  采购1=new JButton("添加新采购    ");     //此处若为jbutton 采购1=....则下面的事件监听不到
		  采购1.addActionListener(this);
		  采购2=new JButton("历史采购信息");
		  采购2.addActionListener(this);
		  采购菜单.add(采购1);
		  采购菜单.add(采购2);
		  MyMenuButton 采购=new MyMenuButton("采购管理");
		  //采购.setOpaque(false);
		  //采购.setBorder(BorderFactory.createRaisedBevelBorder());//按钮凸出来
		  采购.addMenu(采购菜单);	
		  
		  JPopupMenu 销售菜单=new JPopupMenu();
		  销售1=new JButton("添加新销售    ");     
		  销售1.addActionListener(this);
		  销售2=new JButton("历史销售信息");
		  销售2.addActionListener(this);
		  销售菜单.add(销售1);
		  销售菜单.add(销售2);
		  MyMenuButton 销售=new MyMenuButton("销售管理");
		  销售.addMenu(销售菜单);
		  
		  JPopupMenu 库存菜单=new JPopupMenu();
		  库存1=new JButton("图书库存信息");     
		  库存1.addActionListener(this);
		  库存菜单.add(库存1);		 
		  MyMenuButton 库存=new MyMenuButton("库存管理");
		  库存.addMenu(库存菜单);
		  
		  JPopupMenu 人员菜单=new JPopupMenu();
		  人员1=new JButton("供货商管理    ");     
		  人员1.addActionListener(this);
		  人员2=new JButton("销售商管理    ");
		  人员2.addActionListener(this);
		  人员菜单.add(人员1);
		  人员菜单.add(人员2);
		  MyMenuButton 人员=new MyMenuButton("人员管理");
		  人员.addMenu(人员菜单);
		  		  
		  JPopupMenu 账款菜单=new JPopupMenu();
		  账款1=new JButton("采购费用明细");     
		  账款1.addActionListener(this);
		  账款2=new JButton("销售费用明细");
		  账款2.addActionListener(this);
		  账款菜单.add(账款1);
		  账款菜单.add(账款2);
		  MyMenuButton 账款=new MyMenuButton("账款管理");
		  账款.addMenu(账款菜单);
		  
		  JPopupMenu 报警菜单=new JPopupMenu();
		  报警1=new JButton("报警设置       ");     
		  报警1.addActionListener(this);
		  报警2=new JButton("报警信息查看");
		  报警2.addActionListener(this);
		  报警菜单.add(报警1);
		  报警菜单.add(报警2);
		  MyMenuButton 报警=new MyMenuButton("报警管理");
		  报警.addMenu(报警菜单);
		  
		  JPopupMenu 报表菜单=new JPopupMenu();
		  报表1=new JButton("图书库存报表");     
		  报表1.addActionListener(this);
		  报表2=new JButton("图书采购报表");
		  报表2.addActionListener(this);
		  报表3=new JButton("图书销售报表");
		  报表3.addActionListener(this);
		  报表菜单.add(报表1);
		  报表菜单.add(报表2);
		  报表菜单.add(报表3);
		  MyMenuButton 报表=new MyMenuButton("报表管理");
		  报表.addMenu(报表菜单);
		  
		  客服=new JButton("客服");
		  客服.addActionListener(this);
		  
		  
		  Dimension preferredSize = new Dimension(120,80);//设置尺寸一排按钮设置一个即可
		  报警.setPreferredSize(preferredSize );
		  pLeft.add(new JLabel(""));
		  pLeft.add(采购);
		  pLeft.add(销售);
		  pLeft.add(库存);
		  pLeft.add(人员);
		  pLeft.add(账款);
		  pLeft.add(报警);
		  pLeft.add(报表);
		  pLeft.add(客服);
		  c.add(pLeft,"West");
		  
		  
		  
		  pCenter =new JPanel();
		  pCenter.setLayout(null);
		  pCenter.setOpaque(false);
		  pCenter.setBackground(Color.GRAY);
		  c.add(pCenter,BorderLayout.CENTER);
		  
		  JFrame.setDefaultLookAndFeelDecorated(true);//确保一个漂亮的外观风格(好像没差呀)
		  app.setSize(1300, 850);
		  app.setLocationRelativeTo(null);
		  app.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==采购1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 添加新采购());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==采购2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 历史采购信息());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==销售1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 添加新销售());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==销售2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 历史销售信息());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==库存1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 图书库存信息());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==人员1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 供货商信息());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==人员2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 销售商信息());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==账款1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 采购费用明细());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==账款2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 销售费用明细());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==报警1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 报警设置());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==报警2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 报警信息查看());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==报表1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 库存报表());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==报表2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 采购报表());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==报表3) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new 销售报表());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==客服) {	
	        if (登录.name.equals("小潘")||登录.name.equals("小戴")) {
	        	pCenter.setVisible(false);			
				pCenter.removeAll();			              
				pCenter.add(new ChatServer());		           
				pCenter.setVisible(true);
			} else {
				pCenter.setVisible(false);			
				pCenter.removeAll();			              
				pCenter.add(new ChatClient());		           
				pCenter.setVisible(true);
			}
				          
			
		}
	}
}


