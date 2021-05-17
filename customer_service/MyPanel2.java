package 客服;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class MyPanel2 extends JPanel {	
    //北区域
    protected int size;
    protected JLabel labels[];
    protected JTextField fields[];
    //“确定”，由派生子类根据具体要求实现
    protected JButton doTask1;
    protected JLabel  promptLabel;
    //中区域：文本区
    protected JTextArea textArea;
    //南区域：由派生子类根据具体要求放置不同的图形组建
    JPanel  southPanel;
    public MyPanel2(){
    	
    	/*
    	//使界面更圆润
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
    	*/
    	
    	this.setOpaque(false);
        setLayout(new BorderLayout());
        //北区域
        int size = 1;
       // labels = new JLabel[size];
        fields = new JTextField[size];
        
      //  for (int count = 0; count < labels.length; count++)
         //   labels[count] = new JLabel("",SwingConstants.RIGHT);//"标签"+count
       // for (int count = 0; count < fields.length; count++)
        //    fields[count] = new JTextField(12);
        JPanel innerPanelCenter = new JPanel();
        innerPanelCenter.setOpaque(false);
        for (int count = 0; count < size; count++) {
            JPanel innerPanel=new JPanel();
          //  innerPanel.add(labels[count]);
       //     innerPanel.add(fields[count]);
            innerPanelCenter.add(innerPanel);
        }
        doTask1 = new JButton("开始聊天");
        innerPanelCenter.add(doTask1);
       // promptLabel=new JLabel("设置提示！");
      //  promptLabel.setForeground(Color.red);
      //  promptLabel.setBorder(BorderFactory.createTitledBorder("提示"));
        JPanel northPanel=new JPanel(new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.add(innerPanelCenter, BorderLayout.CENTER);
      //  northPanel.add(promptLabel, BorderLayout.SOUTH);
        add(northPanel,BorderLayout.NORTH);
        //中区域
        textArea=new JTextArea();
        
        //设置自动换行
        textArea.setLineWrap(true);
        //字边界换行
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("幼圆", Font.PLAIN, 16));
        textArea.setOpaque(false);
        JScrollPane js1=new JScrollPane(textArea);
        js1.setOpaque(false);
        this.add(js1,BorderLayout.CENTER);
        //南区域
        //调用本类方法初始化南边图形界面组件
        southPanel=this.setSouthPanel();
        southPanel.setOpaque(false);
        add(this.setSouthPanel(),BorderLayout.SOUTH);
    }
    //该方法创建南边的图形界面组件，子类可根据需要覆盖它
    protected JPanel setSouthPanel(){
        JPanel panelSouth=new JPanel();
        panelSouth.setOpaque(false);
        panelSouth.add(new JLabel("子类中需重写南边的图形组件，以满足不同要求！"));
        return panelSouth;
    }
    //测试类
    public static void main(String args[]) {
        JFrame app= new JFrame("通用图形界面--父类MyPanel2");
        MyPanel2 p=new MyPanel2();
        p.labels[0].setText("");
        app.getContentPane().add(p,BorderLayout.CENTER);
        app.setSize(777, 470);
        app.setLocation(550, 300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
