package �㻭�Ҳ�;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class room1 {
//	    static JFrame chair;
	public static void main (String[] args) {
		JFrame chair=new JFrame("ѡ�����");
		chair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon chairimg = new ImageIcon(startgame.class.getResource("./icon/room1photo.jpg"));//���Ǳ���ͼƬ
		JLabel chairimgLabel = new JLabel(chairimg);//������ͼ���ڱ�ǩ�

		chair.getLayeredPane().add(chairimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
		chairimgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
		JPanel chaircp=(JPanel) chair.getContentPane();
		chair.getContentPane().setLayout(null);
		
		JLabel chairlabel = new JLabel("\u4F60\u753B\u6211\u731C\u623F\u95F41");
		chairlabel.setFont(new Font("΢���ź�", Font.PLAIN, 42));
		chairlabel.setBounds(176, 30, 292, 59);
		chair.getContentPane().add(chairlabel);
		
		JLabel lblPlayer1 = new JLabel("һ ��");
		lblPlayer1.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		lblPlayer1.setBounds(71, 82, 82, 51);
		chair.getContentPane().add(lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel("�� ��");
		lblPlayer2.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		lblPlayer2.setBounds(326, 82, 118, 51);
		chair.getContentPane().add(lblPlayer2);
		
		JLabel lblPlayer3 = new JLabel("�� ��");
		lblPlayer3.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		lblPlayer3.setBounds(71, 349, 82, 51);
		chair.getContentPane().add(lblPlayer3);
		
		JLabel lblPlayer4 = new JLabel("�� ��");
		lblPlayer4.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		lblPlayer4.setBounds(326, 349, 94, 51);
		chair.getContentPane().add(lblPlayer4);
		
		JButton chairButton1 = new JButton("");
		chairButton1.setIcon(new ImageIcon(room1.class.getResource("./icon/\u5934\u50CF1.jpg")));
		chairButton1.setBounds(71, 127, 185, 188);
		chair.getContentPane().add(chairButton1);
		
		JButton chairButton2 = new JButton("New button");
		chairButton2.setIcon(new ImageIcon(room1.class.getResource("./icon/\u5934\u50CF2.jpg")));
		chairButton2.setBounds(326, 127, 185, 188);
		chair.getContentPane().add(chairButton2);
		
		JButton chairButton3 = new JButton("New button");
		chairButton3.setIcon(new ImageIcon(room1.class.getResource("./icon/\u5934\u50CF3.jpg")));
		chairButton3.setBounds(71, 404, 185, 188);
		chair.getContentPane().add(chairButton3);
		
		JButton chairButton4 = new JButton("New button");
		chairButton4.setIcon(new ImageIcon(room1.class.getResource("./icon/\u5934\u50CF4.jpg")));
		chairButton4.setBounds(326, 404, 185, 188);
		chair.getContentPane().add(chairButton4);
		
		JLabel chairlabel1 = new JLabel("����");
		chairlabel1.setFont(new Font("΢���ź�", Font.BOLD, 18));
		chairlabel1.setBounds(163, 82, 118, 51);
		chair.getContentPane().add(chairlabel1);
		
		JLabel chairlabel2 = new JLabel("����");
		chairlabel2.setFont(new Font("΢���ź�", Font.BOLD, 18));
		chairlabel2.setBounds(418, 84, 118, 51);
		chair.getContentPane().add(chairlabel2);
		
		JLabel chairlabel3 = new JLabel("����");
		chairlabel3.setFont(new Font("΢���ź�", Font.BOLD, 18));
		chairlabel3.setBounds(177, 351, 118, 51);
		chair.getContentPane().add(chairlabel3);
		
		JLabel chairlabel4 = new JLabel("����");
		chairlabel4.setFont(new Font("΢���ź�", Font.BOLD, 18));
		chairlabel4.setBounds(418, 349, 118, 51);
		chair.getContentPane().add(chairlabel4);
		
		((JPanel)chaircp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

		chair.setBounds(280, 40, 620,640);
		chair.setVisible(true);
}
}
