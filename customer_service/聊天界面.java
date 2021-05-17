package 客服;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

//import java网络编程.ChatServer;

public class 聊天界面 extends JFrame{
     public 聊天界面() {   	
    	 this.setTitle("客服小黑");
    	 this.setLayout(null);
    	 
    	 
    	 JTextArea 对话=new JTextArea();
    	 对话.setBounds(10, 10, 530, 470);
    	
    	 
    	 
         this.setSize(570, 725);
         this.setLocation(683, 141);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     }
     
     
     
     
     
     public static void main(String[] args) {
    	 new 聊天界面();
	}
}
