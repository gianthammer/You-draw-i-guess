package 你画我猜;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;


public class room {
	 static JFrame room;
   public static void main(String[] args) {
	     JFrame room=new JFrame("房间选择");
		room.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon roomimg = new ImageIcon(startgame.class.getResource("./icon/room.jpg"));//这是背景图片
		JLabel roomimgLabel = new JLabel(roomimg);//将背景图放在标签里。

		room.getLayeredPane().add(roomimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		roomimgLabel.setBounds(0,0,1000, 600);//设置背景标签的位置
		JPanel roomcp=(JPanel) room.getContentPane();
		room.getContentPane().setLayout(null);
		
		JLabel roomlabel1 = new JLabel("\u623F\u95F41\uFF1A0\u4EBA");
		roomlabel1.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		roomlabel1.setBounds(79, 438, 145, 45);
		room.getContentPane().add(roomlabel1);
		
		JLabel roomlabel2 = new JLabel("\u623F\u95F42");
		roomlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		roomlabel2.setBounds(342, 438, 145, 45);
		room.getContentPane().add(roomlabel2);
		
		JLabel roomlabel3 = new JLabel("\u623F\u95F43");
		roomlabel3.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		roomlabel3.setBounds(583, 438, 145, 45);
		room.getContentPane().add(roomlabel3);
		
		JLabel roomlabel4 = new JLabel("\u623F\u95F44");
		roomlabel4.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		roomlabel4.setBounds(829, 438, 145, 45);
		room.getContentPane().add(roomlabel4);
		
		JButton roomButton1 = new JButton("");
		roomButton1.setIcon(new ImageIcon(room.class.getResource("./icon/room1.jpg")));
		roomButton1.setBounds(27, 76, 231, 341);
		room.getContentPane().add(roomButton1);
		
		JButton roomButton2 = new JButton("New button");
		roomButton2.setIcon(new ImageIcon(room.class.getResource("./icon/room2.jpg")));
		roomButton2.setBounds(268, 76, 231, 341);
		room.getContentPane().add(roomButton2);
		
		JButton roomButton3 = new JButton("New button");
		roomButton3.setIcon(new ImageIcon(room.class.getResource("./icon/room3.jpg")));
		roomButton3.setBounds(509, 76, 231, 341);
		room.getContentPane().add(roomButton3);
		
		JButton roomButton4 = new JButton("New button");
		roomButton4.setIcon(new ImageIcon(room.class.getResource("./icon/room4.jpg")));
		roomButton4.setBounds(750, 76, 231, 341);
		room.getContentPane().add(roomButton4);
		
		JLabel roomButton5 = new JLabel("\u6E38 \u620F \u623F \u95F4");
		roomButton5.setFont(new Font("微软雅黑", Font.BOLD, 39));
		roomButton5.setBounds(416, 10, 338, 62);
		room.getContentPane().add(roomButton5);
		
		((JPanel)roomcp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

		room.setBounds(280, 40, 1000,640);
		room.setVisible(true);
		
}
}
