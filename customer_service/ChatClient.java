package �ͷ�;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;

import Alke.��¼;
public class ChatClient extends ChatPanelSocket{
    public ChatClient(){
        super();
        this.setBounds(10, 67, 1123, 702);
        this.setOpaque(false);
    }
    protected void doTask1Button(){
        textArea.append("���ӷ�����\n");
        try {
        	nickname=��¼.name;
            textArea.append(nickname+"���ӷ�����\n");
            socket = new Socket("127.0.0.1", 7500);      
            input = new DataInputStream(socket.getInputStream());//���׽��ֶ����ݵ���           
            output = new DataOutputStream(socket.getOutputStream());//���׽���д���ݵ���           
            thread = new Thread(this);//�����̶߳�����run�����н��նԷ����͵��ַ���
            thread.start();
            doTask1.setEnabled(false); 
            sendButton.setEnabled(true); //������Ϣ
            exitButton.setEnabled(true);                  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
