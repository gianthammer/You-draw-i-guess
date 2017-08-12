package 你画我猜;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class startgame {
	private static JTextField registertextField;
	private static JTextField registertextField2;
	private static JTextField registertextField3;
	private static JTextField registertextField1;
	private static JTextField registertextField4;
	private static JTextField registertextField5;
	
  public static void main(String[] args) {
	  JFrame register=new JFrame("注册界面");
	  register.setIconImage(Toolkit.getDefaultToolkit().getImage(startgame.class.getResource("./icon/\u89D2\u56FE.jpg")));
		ImageIcon registerimg = new ImageIcon(startgame.class.getResource("./icon/register1.jpg"));//这是背景图片
		JLabel registerimgLabel = new JLabel(registerimg);//将背景图放在标签里。

		register.getLayeredPane().add(registerimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		registerimgLabel.setBounds(0,0,600, 600);//设置背景标签的位置
		JPanel registercp=(JPanel) register.getContentPane();
		register.getContentPane().setLayout(null);
		
		JLabel registerlabel = new JLabel("用户名");
		registerlabel.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabel.setBounds(288, 126, 106, 37);
		register.getContentPane().add(registerlabel);
		
		registertextField = new JTextField();
		registertextField.setBounds(383, 126, 149, 37);
		register.getContentPane().add(registertextField);
		registertextField.setColumns(10);
		
		JLabel registerlabe2 = new JLabel("密 码");
		registerlabe2.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe2.setBounds(288, 199, 106, 37);
		register.getContentPane().add(registerlabe2);
		
		JLabel registerlabe3 = new JLabel("性 别");
		registerlabe3.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe3.setBounds(288, 404, 106, 37);
		register.getContentPane().add(registerlabe3);
		
		JLabel registerlabe4 = new JLabel("昵 称");
		registerlabe4.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe4.setBounds(288, 263, 106, 37);
		register.getContentPane().add(registerlabe4);
		
		registertextField2 = new JTextField();
		registertextField2.setColumns(10);
		registertextField2.setBounds(383, 266, 149, 37);
		register.getContentPane().add(registertextField2);
		
		registertextField3 = new JTextField();
		registertextField3.setColumns(10);
		registertextField3.setBounds(383, 338, 149, 37);
		register.getContentPane().add(registertextField3);
		
		JLabel registerlabe5 = new JLabel("年 龄");
		registerlabe5.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe5.setBounds(288, 335, 106, 37);
		register.getContentPane().add(registerlabe5);
		
		registertextField1 = new JTextField();
		registertextField1.setColumns(10);
		registertextField1.setBounds(383, 404, 149, 37);
		register.getContentPane().add(registertextField1);
		
		JLabel registerlabe6 = new JLabel("\u5F97\u5206\uFF1A");
		registerlabe6.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe6.setBounds(288, 527, 106, 37);
		register.getContentPane().add(registerlabe6);
		
		JLabel registerlabe7 = new JLabel("0");
		registerlabe7.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe7.setBounds(383, 527, 149, 37);
		register.getContentPane().add(registerlabe7);
		
		JLabel registerlabe8 = new JLabel("\u7528 \u6237 \u6CE8 \u518C");
		registerlabe8.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		registerlabe8.setBounds(216, 44, 205, 54);
		register.getContentPane().add(registerlabe8);
		
		JLabel registerlabe9 = new JLabel("\u661F\u5EA7\uFF1A");
		registerlabe9.setFont(new Font("仿宋", Font.PLAIN, 22));
		registerlabe9.setBounds(288, 469, 106, 37);
		register.getContentPane().add(registerlabe9);
		
		registertextField4 = new JTextField();
		registertextField4.setColumns(10);
		registertextField4.setBounds(383, 472, 149, 37);
		register.getContentPane().add(registertextField4);
		
		registertextField5 = new JTextField();
		registertextField5.setColumns(10);
		registertextField5.setBounds(383, 199, 149, 37);
		register.getContentPane().add(registertextField5);
		
		JLabel registerlabe10 = new JLabel("\u4F60\u753B\u6211\u731C");
		registerlabe10.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		registerlabe10.setBounds(231, 10, 185, 42);
		register.getContentPane().add(registerlabe10);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registerButton.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		registerButton.setBounds(197, 558, 134, 44);
		register.getContentPane().add(registerButton);
		
		JButton registerButton2 = new JButton("\u767B\u9646");
		registerButton2.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		registerButton2.setBounds(414, 558, 134, 44);
		register.getContentPane().add(registerButton2);
		
		((JPanel)registercp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

		register.setBounds(280, 40, 620,640);
		register.setVisible(true);
		
}
}