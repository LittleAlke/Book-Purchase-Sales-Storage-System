package 客服;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import javax.swing.JFrame;

import Alke.登录;
public class ChatServer extends ChatPanelSocket{
    public ChatServer(){
        super();
        this.setBounds(10, 67, 1123, 702);
        this.setOpaque(false);
    }
    protected void doTask1Button(){
        textArea.append("启动服务器！\n");
        nickname="客服"+登录.name;
        textArea.append(nickname+"等待客户连接...\n");
        try {
            ServerSocket server = new ServerSocket(7500);         
            socket = server.accept();//等待客户连接，连接上后才能执行下面语句           
            input = new DataInputStream(socket.getInputStream());//从套接字读数据的流         
            output = new DataOutputStream(socket.getOutputStream());//向套接字写数据的流        
            thread = new Thread(this);//创建线程对象在run方法中接收对方发送的字符串      
            thread.start();//启动线程，执行run方法       
            doTask1.setEnabled(false);       
            sendButton.setEnabled(true);        
            exitButton.setEnabled(true);         
            output.writeUTF("(客服)"+nickname + "\n请问我能帮您什么？ "); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
