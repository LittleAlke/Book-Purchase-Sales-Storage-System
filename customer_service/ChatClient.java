package 客服;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;

import Alke.登录;
public class ChatClient extends ChatPanelSocket{
    public ChatClient(){
        super();
        this.setBounds(10, 67, 1123, 702);
        this.setOpaque(false);
    }
    protected void doTask1Button(){
        textArea.append("连接服务器\n");
        try {
        	nickname=登录.name;
            textArea.append(nickname+"连接服务器\n");
            socket = new Socket("127.0.0.1", 7500);      
            input = new DataInputStream(socket.getInputStream());//从套接字读数据的流           
            output = new DataOutputStream(socket.getOutputStream());//向套接字写数据的流           
            thread = new Thread(this);//创建线程对象：在run方法中接收对方发送的字符串
            thread.start();
            doTask1.setEnabled(false); 
            sendButton.setEnabled(true); //发送消息
            exitButton.setEnabled(true);                  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
