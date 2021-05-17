package 客服;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ChatPanel extends MyPanel2 implements ActionListener{
    //南边的图形界面
    //文本框：输入聊天内容
    protected JTextField southField;
    //“发送”按钮：发送聊天内容
    protected JButton sendButton;
    //“离线”按钮，断开连接
    protected JButton exitButton;
    //昵称
    protected String nickname="我们";
    //初始化面板中的图形组件
    public ChatPanel() {
    	this.setOpaque(false);
        //图形界面继承自父类
        //调用父类构造方法，参数1表示有1个标签labels【0】，1个文本框fields【0】
       // super(1);
        //设置第1个标签的提示文字
      //  labels[0].setText(" ");//输入昵称
   //     promptLabel.setText("单击\"确定\"按钮，若服务器和客户连接后，可开始聊天！");
        //为北边的“确定”按钮添加监听
        doTask1.addActionListener(this);
        //为南边的“发送”按钮添加监听
        sendButton.addActionListener(this);
        //为南边的“离线”按钮添加监听
        exitButton.addActionListener(this);
    }
    //“确定”、“发送”、“离线”3按钮单击时将执行的任务
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==doTask1){//北边“确定”按钮
            doTask1Button();
        }
        if(e.getSource()==sendButton){//南边“发送”按钮
            sendButton();
        }
        if(e.getSource()==exitButton){//南边“离线”按钮
            exitButton();
        }
    }
    //单击北边“确定”按钮执行的动作。只提供空方法体，由子类实现具体功能
    protected void doTask1Button(){
    } 
    //单击南边“发送”按钮执行的动作。只提供空方法体，由子类实现具体功能
    protected void sendButton(){
    }
    //单击南边“离线”按钮执行的动作。只提供空方法体，由子类实现具体功能
    protected void exitButton(){
    }
    //覆盖父类同名方法，重新绘制聊天室南边的GUI
    protected JPanel setSouthPanel() {
    	
        //聊天面板南边，一个文本框用于输入聊天内容，两个按钮
        //放置南边组件的面板对象
        JPanel southPanel = new JPanel(); 
        //输入聊天内容的文本框
        southPanel.setOpaque(false);
        southField = new JTextField(20);
        southField.setOpaque(false);
        southField.setFont(new Font(null, 0, 20));
        southPanel.add(southField);
        //“发送”按钮
        sendButton = new JButton("发送");
        //初始设置为不可用
        sendButton.setEnabled(false);
        southPanel.add(sendButton);
        //“离线”按钮
        exitButton = new JButton("离线");
         //初始设置为不可用
        exitButton.setEnabled(false);
        southPanel.add(exitButton);
        //返回包含上述组件的面板对象
        return southPanel;
    }
    //测试chatpanel类
    public static void main(String args[]){
        JFrame app= new JFrame("聊天界面");
        app.getContentPane().add(new ChatPanel());
        app.setSize(777, 470);
        app.setLocation(550, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

