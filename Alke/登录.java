package Alke;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.jar.Attributes.Name;

import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

//import ȫ����ͼ���.GetConnection;
import ���ݿ�.getconnection;

public class ��¼ extends JFrame implements ActionListener {
	private JFrame app;
	private JButton ��¼,���,ע��,��������,�˳�;
	private JLabel �û�����,�û�����;
	private JTextField �û���;
	private JPasswordField �û�����;
	private JDialog ��ʾ;  //�Ի���
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	private int massage=0;
	public  static String  ID,name;	
 public ��¼ () {	 
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
	 Container c=getContentPane();
	     //���ñ���ͼƬ
	    ImageIcon img=new ImageIcon("G:/JAVA/ͼ����������ϵͳ/ͼƬ/shine.jpg");
	    JLabel jll=new JLabel(img);
	    jll.setBounds(-500, -800, img.getIconWidth(),img.getIconWidth());
	    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
	    ((JPanel)c).setOpaque(false); 
	    //����ͼ��
	    Image icon = Toolkit.getDefaultToolkit().getImage("G:/JAVA/ͼ����������ϵͳ/ͼƬ/��ܾ�2.jpg");
        this.setIconImage(icon);
     �û�����=new JLabel("�û��˺�");           //newһ����ǩ      
     �û���=new JTextField(10);           //����Ϊ10���ı���
     �û���.setOpaque(false); 
    
     �û�����=new JLabel("�û�����");   
     �û�����=new JPasswordField(10);
     �û�����.setOpaque(false);
     
     ��¼=new JButton("��¼");  
     ��¼.addActionListener(this);  //������
     ���=new JButton("���"); 
     ���.addActionListener(this);
     
     ��ʾ=new JDialog(); //�Ի���
     ��ʾ.setTitle("�Ƿ��������룿");
     ��ʾ.setSize(340,80);
     ��ʾ.setLocation(this.getX()+500, this.getY()+500);
     ��ʾ.setLayout(new FlowLayout());
     
     ��������=new JButton("��������");
     ��������.addActionListener(this);
     ��ʾ.add(��������);
     
     �˳�=new JButton("�˳�");
     ��ʾ.add(�˳�);
     �˳�.addActionListener(this);
        
     ע��=new JButton("ע��");  
     ע��.addActionListener(this);
     
     p1=new JPanel();
     p1.setOpaque(false);
     p2=new JPanel();
     p2.setOpaque(false);
     p3=new JPanel();
     p3.setOpaque(false);
     p4=new JPanel();
     p4.setOpaque(false);
     p5=new JPanel();
     p5.setOpaque(false);
     p6=new JPanel();
     p6.setOpaque(false);
     p7=new JPanel();
     p7.setOpaque(false);
     p8=new JPanel();
     p8.setOpaque(false);
     
     this.setLayout(new GridLayout(10,1));
     
     p4.add(�û�����);
     p4.add(�û���);
     p5.add(�û�����);
     p5.add(�û�����);
     p6.add(��¼);
     p6.add(���);
     p7.add(new JLabel("����㻹û��ע�ᣬ��ע��"));
     p8.add(ע��);
     
     this.add(p1);
     this.add(p2);
     this.add(p3);
     this.add(p4);
     this.add(p5);
     this.add(p6);
     this.add(p7);
     this.add(p8);
     
     this.setTitle("��¼");
     this.setSize(626,461);
     this.setLocation(360,240);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
     
     
 }

public void actionPerformed(ActionEvent e) {      //�ж�ִ��
	if(e.getSource()==��¼) {
		Connection con;  //
		Statement stmt;   //mysql���ݿ�
		ResultSet rs;   //�����
		try {
			con=new getconnection().getconn();			
			stmt=con.createStatement();                                          
			rs=stmt.executeQuery("select * from login");
			while(rs.next()) {
				 String st1=rs.getString("username");
				String st2=rs.getString("password");
				ID=st1;
			   name=rs.getString("name");
				char[] ps=�û�����.getPassword();
				String st3="";
				for (int i = 0; i < ps.length; i++) 
					st3+=ps[i];
					if ((�û���.getText().equals(st1))&&(st3.equals(st2))) {
						massage=1;						
						new ������();						
						this.setVisible(false);
						rs.close();
						stmt.close();
						con.close();
						break;
					}
				}
				if (massage==0) {
					JOptionPane.showMessageDialog(app, "��������˺Ż��������󣬻��˺Ų����ڣ����������룡","ϵͳ��ʾ",
							JOptionPane.ERROR_MESSAGE);
				}
				con.close();
			}catch (SQLException f) {
		     System.out.println(f);
		 }
	}	
	if (e.getSource()==���) {		
		��ʾ.setVisible(true);
	}
	if(e.getSource()==�˳�)
		System.exit(0);
	if (e.getSource()==��������) {
		�û���.setText("");
		�û�����.setText("");
		��ʾ.setVisible(false);
	}
	if (e.getSource()==ע��) {
		new ע��();
		this.setVisible(false);
	}
	
}

public static void main(String[] args) {
	new ��¼();
}

}
