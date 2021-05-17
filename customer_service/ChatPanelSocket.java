package 客服;
/*
 * 
 * 继承自聊天室图形界面类ChatPanel，增加了通信功能并实现线程接口Runnable
 * 
 * */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.JFrame;
public class ChatPanelSocket extends ChatPanel implements Runnable{ 
    //客户端socket对象
    protected Socket socket;
    //读数据
    protected DataInputStream input;
    //写数据
    protected DataOutputStream output;
    //线程对象，用于接收对方发送的字符串
    protected Thread thread;  
    public ChatPanelSocket( ){
    
    	super();   
    	this.setOpaque(false);
    }
    /*本类没有覆盖doTask1Button方法，交由其子类服务器端程序和客户端程序分别覆盖，具体实现
         发送按钮执行的动作*/

    Calendar cal=Calendar.getInstance();      
	int y=cal.get(Calendar.YEAR);      
	int m=cal.get(Calendar.MONTH);      
	int d=cal.get(Calendar.DATE);      
	int h=cal.get(Calendar.HOUR_OF_DAY);      
	int mi=cal.get(Calendar.MINUTE);      
	int s=cal.get(Calendar.SECOND);
	String time=y+"/"+m+"/"+d+"/"+h+":"+mi+":"+s;
    protected void sendButton() {
        try {
            //发送聊天内容，对方在run方法中接收
            output.writeUTF("("+nickname+")  "+time+"\n"+southField.getText());
            //在文本区中显示
            textArea.append("("+nickname+")  "+time+"\n"+southField.getText()+"\n"); 
            //清空南边输入发送内容的文本框
           // southField.setText("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //覆盖父类方法实现离线按钮执行的动作
    protected void exitButton(){
        try {
            //向对方发送字符串“bye”，然后关闭连接
            output.writeUTF("bye");
            sendButton.setEnabled(false);
            exitButton.setEnabled(false); 
            textArea.append("连接断开！"); 
            socketClosing();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    //接收对方发送过来的字符串
    public void run(){
        System.out.println("线程启动！");
        //保存对方发送过来的字符串
        String inStr = ""; 
        while (true) {
            try {
                //读取对方发送的字符串，根据不同内容分别处理
                inStr = input.readUTF();
                if(inStr.equals("bye")){
                    sendButton.setEnabled(false);
                    exitButton.setEnabled(false);
                    textArea.append("连接断开！");
                    socketClosing();
                    break;
                }else{
                    //如果对方发送的不是bye，则在本方文本区追加显示聊天内容
                    textArea.append(inStr+"\n");
                }
            } catch (Exception e) {
                socketClosing();
                System.out.println("有异常，连接中断！");
                break;
            }
        }
        System.out.println("线程结束！");
    }
    //关闭所有连接
    private void socketClosing() {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (Exception e){
            System.out.println("关闭socket和流时，发生异常！");
        }
    }
    public static void main(String[] args) {
        JFrame app= new JFrame("具有通信功能的聊天界面");
        app.getContentPane().add(new ChatPanelSocket());
        app.setSize(777, 470);
        app.setLocation(550, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

