package Alke;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;

import ��Ա.��ӹ�����;
import ��Ա.��������Ϣ;
import �ͷ�.ChatClient;
import �ͷ�.ChatServer;
import ��Ա.��������Ϣ;
import ���.ͼ������Ϣ;
import ����.��汨��;
import ����.�ɹ�����;
import ����.���۱���;
import ����.������Ϣ�鿴;
import ����.��������;
import �˿�.�ɹ�������ϸ;
import �˿�.���۷�����ϸ;
import �ɹ�.��ʷ�ɹ���Ϣ;
import �ɹ�.����²ɹ�;
import ����.��ʷ������Ϣ;
import ����.���������;

public class ������  implements ActionListener{
	public static  JPanel pCenter;
	private JPanel p5;
	private JButton �ɹ�1,�ɹ�2,����1,����2,���1,��Ա1,��Ա2,�˿�1,�˿�2,����1,����2,����1,����2,����3,�ͷ�;
	public ������ () {
		//ʹ�����Բ��
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
		
		app.setTitle("�������������ϼ���ͼ��ݹ���ϵͳ");
		Container c=app.getContentPane(); 
		  //����ͼƬ
		    ImageIcon img=new ImageIcon("G:/ͼ����������ϵͳ/ͼƬ/����1.jpg");
		    JLabel jll=new JLabel(img);
		    jll.setBounds(0,-275, img.getIconWidth(),img.getIconWidth());//2����0,-195��3����0,-300��
		    app.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
		    ((JPanel)c).setOpaque(false);
		  //����ͼ��
		    Image icon = Toolkit.getDefaultToolkit().getImage("G:/ͼ����������ϵͳ/ͼƬ/��ܾ�2.jpg");
		    app.setIconImage(icon);
		   //��������
		  c.setLayout(new BorderLayout());
		  //�������ͼ�����
		  JPanel ps=new JPanel();
		 // ps.add(new Label(""));
		  ps.setOpaque(false);		  
		  c.add(ps,BorderLayout.NORTH);  
		  //������Ķ���
		  JPanel px=new JPanel(new GridLayout(1,1));
		  px.setOpaque(false);
		  //px.setBackground(Color.LIGHT_GRAY);
		  c.add(px,BorderLayout.SOUTH);
		  px.add(new Label("                 ֣���Ṥҵ��ѧ",JLabel.CENTER));
		  px.add(new Label("              ���ѧԺ",JLabel.CENTER));
		  px.add(new Label("              ����Ф����",JLabel.CENTER));
		  //���
		  JPanel pLeft =new JPanel(new GridLayout(10,1,0,25));
		  pLeft.setOpaque(false);
		  //������ť����˵�ѡ��
		  JPopupMenu �ɹ��˵�=new JPopupMenu();
		  �ɹ�1=new JButton("����²ɹ�    ");     //�˴���Ϊjbutton �ɹ�1=....��������¼���������
		  �ɹ�1.addActionListener(this);
		  �ɹ�2=new JButton("��ʷ�ɹ���Ϣ");
		  �ɹ�2.addActionListener(this);
		  �ɹ��˵�.add(�ɹ�1);
		  �ɹ��˵�.add(�ɹ�2);
		  MyMenuButton �ɹ�=new MyMenuButton("�ɹ�����");
		  //�ɹ�.setOpaque(false);
		  //�ɹ�.setBorder(BorderFactory.createRaisedBevelBorder());//��ť͹����
		  �ɹ�.addMenu(�ɹ��˵�);	
		  
		  JPopupMenu ���۲˵�=new JPopupMenu();
		  ����1=new JButton("���������    ");     
		  ����1.addActionListener(this);
		  ����2=new JButton("��ʷ������Ϣ");
		  ����2.addActionListener(this);
		  ���۲˵�.add(����1);
		  ���۲˵�.add(����2);
		  MyMenuButton ����=new MyMenuButton("���۹���");
		  ����.addMenu(���۲˵�);
		  
		  JPopupMenu ���˵�=new JPopupMenu();
		  ���1=new JButton("ͼ������Ϣ");     
		  ���1.addActionListener(this);
		  ���˵�.add(���1);		 
		  MyMenuButton ���=new MyMenuButton("������");
		  ���.addMenu(���˵�);
		  
		  JPopupMenu ��Ա�˵�=new JPopupMenu();
		  ��Ա1=new JButton("�����̹���    ");     
		  ��Ա1.addActionListener(this);
		  ��Ա2=new JButton("�����̹���    ");
		  ��Ա2.addActionListener(this);
		  ��Ա�˵�.add(��Ա1);
		  ��Ա�˵�.add(��Ա2);
		  MyMenuButton ��Ա=new MyMenuButton("��Ա����");
		  ��Ա.addMenu(��Ա�˵�);
		  		  
		  JPopupMenu �˿�˵�=new JPopupMenu();
		  �˿�1=new JButton("�ɹ�������ϸ");     
		  �˿�1.addActionListener(this);
		  �˿�2=new JButton("���۷�����ϸ");
		  �˿�2.addActionListener(this);
		  �˿�˵�.add(�˿�1);
		  �˿�˵�.add(�˿�2);
		  MyMenuButton �˿�=new MyMenuButton("�˿����");
		  �˿�.addMenu(�˿�˵�);
		  
		  JPopupMenu �����˵�=new JPopupMenu();
		  ����1=new JButton("��������       ");     
		  ����1.addActionListener(this);
		  ����2=new JButton("������Ϣ�鿴");
		  ����2.addActionListener(this);
		  �����˵�.add(����1);
		  �����˵�.add(����2);
		  MyMenuButton ����=new MyMenuButton("��������");
		  ����.addMenu(�����˵�);
		  
		  JPopupMenu ����˵�=new JPopupMenu();
		  ����1=new JButton("ͼ���汨��");     
		  ����1.addActionListener(this);
		  ����2=new JButton("ͼ��ɹ�����");
		  ����2.addActionListener(this);
		  ����3=new JButton("ͼ�����۱���");
		  ����3.addActionListener(this);
		  ����˵�.add(����1);
		  ����˵�.add(����2);
		  ����˵�.add(����3);
		  MyMenuButton ����=new MyMenuButton("�������");
		  ����.addMenu(����˵�);
		  
		  �ͷ�=new JButton("�ͷ�");
		  �ͷ�.addActionListener(this);
		  
		  
		  Dimension preferredSize = new Dimension(120,80);//���óߴ�һ�Ű�ť����һ������
		  ����.setPreferredSize(preferredSize );
		  pLeft.add(new JLabel(""));
		  pLeft.add(�ɹ�);
		  pLeft.add(����);
		  pLeft.add(���);
		  pLeft.add(��Ա);
		  pLeft.add(�˿�);
		  pLeft.add(����);
		  pLeft.add(����);
		  pLeft.add(�ͷ�);
		  c.add(pLeft,"West");
		  
		  
		  
		  pCenter =new JPanel();
		  pCenter.setLayout(null);
		  pCenter.setOpaque(false);
		  pCenter.setBackground(Color.GRAY);
		  c.add(pCenter,BorderLayout.CENTER);
		  
		  JFrame.setDefaultLookAndFeelDecorated(true);//ȷ��һ��Ư������۷��(����û��ѽ)
		  app.setSize(1300, 850);
		  app.setLocationRelativeTo(null);
		  app.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==�ɹ�1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ����²ɹ�());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==�ɹ�2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��ʷ�ɹ���Ϣ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ���������());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��ʷ������Ϣ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==���1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ͼ������Ϣ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==��Ա1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��������Ϣ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==��Ա2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��������Ϣ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==�˿�1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new �ɹ�������ϸ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==�˿�2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ���۷�����ϸ());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��������());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ������Ϣ�鿴());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����1) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ��汨��());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����2) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new �ɹ�����());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==����3) {	
			pCenter.setVisible(false);			
			pCenter.removeAll();			              
			pCenter.add(new ���۱���());		           
			pCenter.setVisible(true);
		}
		if (e.getSource()==�ͷ�) {	
	        if (��¼.name.equals("С��")||��¼.name.equals("С��")) {
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


