package �ͷ�;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import javax.swing.JFrame;

import Alke.��¼;
public class ChatServer extends ChatPanelSocket{
    public ChatServer(){
        super();
        this.setBounds(10, 67, 1123, 702);
        this.setOpaque(false);
    }
    protected void doTask1Button(){
        textArea.append("������������\n");
        nickname="�ͷ�"+��¼.name;
        textArea.append(nickname+"�ȴ��ͻ�����...\n");
        try {
            ServerSocket server = new ServerSocket(7500);         
            socket = server.accept();//�ȴ��ͻ����ӣ������Ϻ����ִ���������           
            input = new DataInputStream(socket.getInputStream());//���׽��ֶ����ݵ���         
            output = new DataOutputStream(socket.getOutputStream());//���׽���д���ݵ���        
            thread = new Thread(this);//�����̶߳�����run�����н��նԷ����͵��ַ���      
            thread.start();//�����̣߳�ִ��run����       
            doTask1.setEnabled(false);       
            sendButton.setEnabled(true);        
            exitButton.setEnabled(true);         
            output.writeUTF("(�ͷ�)"+nickname + "\n�������ܰ���ʲô�� "); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
