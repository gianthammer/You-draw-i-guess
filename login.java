package �㻭�Ҳ�;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class login {
//	private static JTextField textField;
//	private static JPasswordField passwordField;
  public static void main(String[] args) {
	  JFrame login=new JFrame("����ͼ����");
	  login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon loginimg = new ImageIcon("/icon/login.jpg");//���Ǳ���ͼƬ
		JLabel loginimgLabel = new JLabel(loginimg);//������ͼ���ڱ�ǩ�

		login.getLayeredPane().add(loginimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
		loginimgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
		JPanel logincp=(JPanel) login.getContentPane();
		login.getContentPane().setLayout(null);
		
		JLabel loginlabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		loginlabel.setFont(new Font("����", Font.PLAIN, 26));
		loginlabel.setBounds(153, 268, 106, 41);
		login.getContentPane().add(loginlabel);
		
		JTextField logintextField = new JTextField();
		logintextField.setBounds(284, 268, 156, 41);
		login.getContentPane().add(logintextField);
		logintextField.setColumns(10);
		
		JLabel loginlabel1 = new JLabel("\u5BC6\u7801\uFF1A");
		loginlabel1.setFont(new Font("����", Font.PLAIN, 26));
		loginlabel1.setBounds(153, 347, 106, 41);
		login.getContentPane().add(loginlabel1);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(284, 349, 156, 39);
		login.getContentPane().add(passwordField);
		
		JLabel loginlabel2 = new JLabel("\u7528\u6237\u767B\u9646");
		loginlabel2.setFont(new Font("΢���ź�", Font.PLAIN, 36));
		loginlabel2.setBounds(214, 195, 188, 46);
		login.getContentPane().add(loginlabel2);
		
		JButton loginbutton1 = new JButton("\u767B\u9646");
		loginbutton1.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		loginbutton1.setBounds(230, 423, 133, 46);
		login.getContentPane().add(loginbutton1);
		
		JLabel loginlabel3 = new JLabel("\u8FD8\u6CA1\u6709\u7528\u6237\u540D\uFF0C\u8D76\u5FEB\u6CE8\u518C\u5427\uFF01\uFF01");
		loginlabel3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		loginlabel3.setBounds(214, 479, 281, 32);
		login.getContentPane().add(loginlabel3);
		
		JButton loginbutton2 = new JButton("\u6CE8\u518C");
		loginbutton2.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		loginbutton2.setBounds(230, 521, 133, 46);
		login.getContentPane().add(loginbutton2);
		
		((JPanel)logincp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

		login.setBounds(280, 40, 620,640);
		login.setVisible(true);
}
}
