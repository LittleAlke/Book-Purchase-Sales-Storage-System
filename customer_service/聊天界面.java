package �ͷ�;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

//import java������.ChatServer;

public class ������� extends JFrame{
     public �������() {   	
    	 this.setTitle("�ͷ�С��");
    	 this.setLayout(null);
    	 
    	 
    	 JTextArea �Ի�=new JTextArea();
    	 �Ի�.setBounds(10, 10, 530, 470);
    	
    	 
    	 
         this.setSize(570, 725);
         this.setLocation(683, 141);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     }
     
     
     
     
     
     public static void main(String[] args) {
    	 new �������();
	}
}
