package 你画我猜;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainGame {
	 private static MultiDraw MD;
	private static JTextField maintextField;
	private static Graphics2D g2;
	private static JFrame maingame;
	public static void main (String[] args) {
        maingame=new JFrame("画板");
		maingame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon maingameimg = new ImageIcon(startgame.class.getResource("./icon/MainGame.jpg"));//这是背景图片
		JLabel maingameimgLabel = new JLabel(maingameimg);//将背景图放在标签里。

		maingame.getLayeredPane().add(maingameimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		maingameimgLabel.setBounds(0,0,1100, 700);//设置背景标签的位置
		JPanel maingamecp=(JPanel) maingame.getContentPane();
		maingame.getContentPane().setLayout(null);
		
		JPanel maingamepanel = new JPanel();
		maingamepanel.setBounds(0, 0, 792, 474);
		maingamepanel.setLayout(new BorderLayout());
		
		
		MD=new MultiDraw();//新加
   	    g2=MD.getG2();
   	    maingamepanel.add(MD);
   	    MD.setLayout(null);
   	    
   	    JButton pencil = new JButton("\u94C5\u7B14");
   	    pencil.setIcon(new ImageIcon(MainGame.class.getResource("./icon/pencil2.jpg")));
   	    pencil.setBounds(0, 0, 100, 100);
   	    pencil.addActionListener(new ActionListener(){
   	    	public void actionPerformed(ActionEvent e){
   	    		 g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
							BasicStroke.JOIN_ROUND));
   	    		 g2.setColor(Color.BLACK);
   	    		 System.out.println("haha");
   	    		 MultiDraw.type=0;
   	    		 System.out.println("!!!!!!!"+ MultiDraw.type+"!!!!!!!!");
   	    	}
   	    });
   	    MD.add(pencil);
   	    
   	    JButton eraser = new JButton("");
   	    eraser.setIcon(new ImageIcon(MainGame.class.getResource("./icon/eraser3.jpg")));
   	    eraser.setBounds(100, 0, 100, 100);
   	    eraser.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 g2.setColor(Color.WHITE);
					 g2.setStroke(new BasicStroke(12, BasicStroke.CAP_ROUND,
								BasicStroke.JOIN_ROUND));
   	    		 System.out.println("haha");
   	    		 System.out.println("!!!!!!!"+ MultiDraw.type+"!!!!!!!!");
   	    		 MultiDraw.type=1;
				}
			});
   	    MD.add(eraser);
   	    

		maingame.getContentPane().add(maingamepanel);
		
		JPanel mainpanel1 = new JPanel();
		mainpanel1.setBounds(0, 472, 197, 190);
		maingame.getContentPane().add(mainpanel1);
		mainpanel1.setLayout(new BorderLayout(0, 0));
		
		JLabel Main1 = new JLabel("");
		Main1.setIcon(new ImageIcon(MainGame.class.getResource("./icon/\u5934\u50CF1.jpg")));
		mainpanel1.add(Main1, BorderLayout.CENTER);
		
		JPanel mainpanel2 = new JPanel();
		mainpanel2.setBounds(198, 472, 197, 190);
		maingame.getContentPane().add(mainpanel2);
		mainpanel2.setLayout(new BorderLayout(0, 0));
		
		JLabel Main2 = new JLabel("");
		Main2.setIcon(new ImageIcon(MainGame.class.getResource("./icon/\u5934\u50CF2.jpg")));
		mainpanel2.add(Main2, BorderLayout.CENTER);
		
		JPanel mainpanel3 = new JPanel();
		mainpanel3.setBounds(397, 472, 197, 190);
		maingame.getContentPane().add(mainpanel3);
		mainpanel3.setLayout(new BorderLayout(0, 0));
		
		JLabel Main3 = new JLabel("");
		Main3.setIcon(new ImageIcon(MainGame.class.getResource("./icon/\u5934\u50CF3.jpg")));
		mainpanel3.add(Main3, BorderLayout.CENTER);
		
		JPanel mainpanel4 = new JPanel();
		mainpanel4.setBounds(595, 472, 197, 190);
		maingame.getContentPane().add(mainpanel4);
		mainpanel4.setLayout(new BorderLayout(0, 0));
		
		JLabel Main4 = new JLabel("");
		Main4.setIcon(new ImageIcon(MainGame.class.getResource("./icon/\u5934\u50CF4.jpg")));
		mainpanel4.add(Main4, BorderLayout.CENTER);
		
		maintextField = new JTextField();
		maintextField.setBounds(792, 366, 171, 46);
		maingame.getContentPane().add(maintextField);
		maintextField.setColumns(10);
		
		JButton mainButton1 = new JButton("go");
		mainButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mainButton1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		mainButton1.setBounds(973, 365, 51, 46);
		maingame.getContentPane().add(mainButton1);
		
		JTextArea maintextArea = new JTextArea();
		maintextArea.setBounds(792, 0, 232, 356);
		maingame.getContentPane().add(maintextArea);
		
		JButton mainButton2 = new JButton("\u51C6\u5907");
		mainButton2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		mainButton2.setBounds(835, 504, 120, 54);
		maingame.getContentPane().add(mainButton2);
		
		JLabel mainlabel4 = new JLabel("180");
		mainlabel4.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		mainlabel4.setBounds(874, 568, 110, 59);
		maingame.getContentPane().add(mainlabel4);
		
		JLabel mainlabel5 = new JLabel("\u8981\u731C\u7684\u8BCD\u8BED\uFF1A");
		mainlabel5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		mainlabel5.setBounds(771, 425, 120, 37);
		maingame.getContentPane().add(mainlabel5);
		
		JLabel mainlabel6 = new JLabel("New label");
		mainlabel6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mainlabel6.setBounds(890, 422, 134, 40);
		maingame.getContentPane().add(mainlabel6);
		
		JLabel mainlabel7 = new JLabel("\u4F60\u7684\u5F97\u5206\u662F\uFF1A");
		mainlabel7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		mainlabel7.setBounds(792, 472, 99, 30);
		maingame.getContentPane().add(mainlabel7);
		
		JLabel mainlabel8 = new JLabel("New label");
		mainlabel8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mainlabel8.setBounds(890, 468, 134, 40);
		maingame.getContentPane().add(mainlabel8);
		
		((JPanel)maingamecp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

		maingame.setBounds(200, 20, 1050,700);
		maingame.setVisible(true);
    }
}