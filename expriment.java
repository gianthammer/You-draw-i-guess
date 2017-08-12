package 你画我猜;

 
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class expriment  {
	private static JTextField registertextField;
	private static JTextField registertextField2;
	private static JTextField registertextField3;
	private static JTextField registertextField1;
	private static JTextField registertextField4;
	private static JTextField registertextField5;
	private static Socket s;
	static DataOutputStream os;//输出
	static DataInputStream is; //输入
	static int a;
	public static JLabel roomlabel1;
	public static JLabel roomlabel2;
	public static JLabel roomlabel3;
	public static JLabel roomlabel4;
	private static MultiDraw MD=new MultiDraw();//新加;
    private static JTextArea maintextField;
	private static Graphics2D  g2=MD.getG2();
	private static JFrame maingame;
	static JLabel mainlabel6;
	static JLabel mainlabel4;
	public static int count=0;
	public static int size=0;
	public static JTextArea maintextArea;
	public static JPanel maingamepanel;
	 public DataOutputStream getOS(){
	    	return os;
	    }
	 public DataInputStream getIS(){
	    	return is;
	    }
	 public JTextArea getTextArea(){
		 return maintextArea;
	 }
	 public MultiDraw getMD(){
		 return MD;
	 }
	
	 public JLabel getLabel(){
		 return mainlabel6;
	 }
	 public JLabel getMainLabel(){
		 return mainlabel4;
	 }
	 
	   
	 public void clean(){
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, 785, 470);

		}
	 
	public static void main (String[] args) {
		
    	try {
    		s=new Socket("127.0.0.1",8887);
			os=new DataOutputStream(s.getOutputStream());
			is=new DataInputStream(s.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
    
		
    	
    	
    	
    	
    	
		//在注册成功界面之前，要先得到注册成功后的界面（先让界面待命）
		final JFrame success =new JFrame();
		success.setResizable(false);
		success.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
		success.setBounds(280, 40, 660,520);
		success.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel successlabel = new JLabel("");
		successlabel.setIcon(new ImageIcon(registersuccess.class.getResource("./icon/注册成功.jpg")));
		success.getContentPane().add(successlabel, BorderLayout.CENTER);
//		success.setVisible(true);
		
		//以上是注册成功后显示的界面
	
		
		
		
		
		
		
		//先得到注册游戏的界面，而不显示出来
		 final JFrame register=new JFrame("注册界面");
		 register.setResizable(false);
		 register.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
		 //register.setIconImage(Toolkit.getDefaultToolkit().getImage("/icon/角图。jpg"));
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
			
			JLabel registerlabe2 = new JLabel("密码");
			registerlabe2.setFont(new Font("仿宋", Font.PLAIN, 22));
			registerlabe2.setBounds(288, 199, 106, 37);
			register.getContentPane().add(registerlabe2);
			
			JLabel registerlabe3 = new JLabel("性别");
			registerlabe3.setFont(new Font("仿宋", Font.PLAIN, 22));
			registerlabe3.setBounds(288, 404, 106, 37);
			register.getContentPane().add(registerlabe3);
			
			JLabel registerlabe4 = new JLabel("昵称");
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
			
			JLabel registerlabe5 = new JLabel("年龄");
			registerlabe5.setFont(new Font("仿宋", Font.PLAIN, 22));
			registerlabe5.setBounds(288, 335, 106, 37);
			register.getContentPane().add(registerlabe5);
			
			registertextField1 = new JTextField();
			registertextField1.setColumns(10);
			registertextField1.setBounds(383, 404, 149, 37);
			register.getContentPane().add(registertextField1);
			
			JLabel registerlabe6 = new JLabel("得分");
			registerlabe6.setFont(new Font("仿宋", Font.PLAIN, 22));
			registerlabe6.setBounds(288, 527, 106, 37);
			register.getContentPane().add(registerlabe6);
			
			JLabel registerlabe7 = new JLabel("0");
			registerlabe7.setFont(new Font("仿宋", Font.PLAIN, 22));
			registerlabe7.setBounds(383, 527, 149, 37);
			register.getContentPane().add(registerlabe7);
			
			JLabel registerlabe8 = new JLabel("用户注册");
			registerlabe8.setFont(new Font("微软雅黑", Font.PLAIN, 40));
			registerlabe8.setBounds(216, 54, 205, 54);
			register.getContentPane().add(registerlabe8);
			
			JLabel registerlabe9 = new JLabel("星座");
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
			
			JLabel registerlabe10 = new JLabel("你画我猜");
			registerlabe10.setFont(new Font("微软雅黑", Font.PLAIN, 40));
			registerlabe10.setBounds(216, 10, 205, 54);
			register.getContentPane().add(registerlabe10);
			
			JButton registerButton = new JButton("注册");
			registerButton.setFont(new Font("微软雅黑", Font.PLAIN, 27));
			registerButton.setBounds(329, 558, 134, 44);
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//要想得到从服务器的返回值，那么就要将所填写的传到服务器，通过数据库进行处理
					
					String name=registertextField.getText();
					String password=registertextField5.getText();
					String small=registertextField2.getText();
					String age=registertextField3.getText();
					String sex=registertextField1.getText();
					String bir=registertextField4.getText();
					//
					try {
	    				os.writeUTF("0");
						os.writeUTF(name);
						os.writeUTF(password);
						os.writeUTF(small);
						os.writeUTF(age);
						os.writeUTF(sex);
						os.writeUTF(bir);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	    			
	    			
	    			try {
						is=new DataInputStream(s.getInputStream());
						String str=is.readUTF();
						
						if(str.equals("无效的注册")){
							 JOptionPane.showMessageDialog(null, "用户名或密码不能为空，重新注册吧！", "警告", JOptionPane.ERROR_MESSAGE);    

							
						}
						else if(str.equals("注册成功")){
							success.setVisible(true);
							register.setVisible(false);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	         	
				}
			});
			register.getContentPane().add(registerButton);
			((JPanel)registercp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
			register.setBounds(280, 40, 620,640);
            //以上是注册游戏的界面
			
		
			
			
			
					
			//得到游戏规则介绍界面
			final JFrame rule=new JFrame();
			rule.setResizable(false);
			rule.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
			rule.setBounds(280, 40, 600,480);
			rule.getContentPane().setLayout(new BorderLayout(0, 0));
			
			JLabel rulelabel = new JLabel("");
			rulelabel.setIcon(new ImageIcon(rule.class.getResource("./icon/规则介绍 .jpg")));
			rule.getContentPane().add(rulelabel, BorderLayout.CENTER);
		    //以上是游戏规则介绍界面
			
			
	
			
			//在游戏房间1的界面显示出来之前，要先将正式游戏的界面初始化，但是不能让他显示出来
			maingame=new JFrame("游戏界面");
			maingame.setResizable(false);
			maingame.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
			maingame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon maingameimg = new ImageIcon(startgame.class.getResource("./icon/MainGame.jpg"));//这是背景图片
			JLabel maingameimgLabel = new JLabel(maingameimg);//将背景图放在标签里。

			maingame.getLayeredPane().add(maingameimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
			maingameimgLabel.setBounds(0,0,1100, 700);//设置背景标签的位置
			JPanel maingamecp=(JPanel) maingame.getContentPane();
			maingame.getContentPane().setLayout(null);
			
			 maingamepanel = new JPanel();
			maingamepanel.setBounds(0, 0, 792, 600);
			maingamepanel.setLayout(new BorderLayout());
			
			/*MD=new MultiDraw();//新加
	   	    g2=MD.getG2();*/
	   	    maingamepanel.add(MD);
	   	    MD.setLayout(null);
	   	
	   	    JButton pencil = new JButton("铅笔");
	   	    pencil.setIcon(new ImageIcon(MainGame.class.getResource("./icon/pencil2.jpg")));
	   	    pencil.setBounds(0, 0, 90, 100);
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
	   	    
	   	    JButton eraser = new JButton("橡皮");
	   	    eraser.setIcon(new ImageIcon(MainGame.class.getResource("./icon/eraser3.jpg")));
	   	    eraser.setBounds(87, 0, 90, 100);
	   	    eraser.addActionListener(new ActionListener() {
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
			
			
			JButton button1 = new JButton("铅笔");
			button1.setBounds(20, 620, 100, 35);
			button1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
		   	    		 g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
									BasicStroke.JOIN_ROUND));
		   	    		 g2.setColor(Color.BLACK);
		   	    		 System.out.println("haha");
		   	    		 MultiDraw.type=0;
		   	    		 System.out.println("!!!!!!!"+ MultiDraw.type+"!!!!!!!!");
					}
			});
			maingame.getContentPane().add(button1);
			
			JButton button2 = new JButton("粗细");
			button2.setBounds(145, 620, 100, 35);
			button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
				}
			});
			maingame.getContentPane().add(button2);
			
			JButton button3 = new JButton("颜色");
			button3.setBounds(270, 620, 100, 35);
			button3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
				}
			});
			maingame.getContentPane().add(button3);
			
			JButton button4 = new JButton("橡胶");
			button4.setBounds(395, 620, 100, 35);
			button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					 g2.setColor(Color.WHITE);
					 g2.setStroke(new BasicStroke(12, BasicStroke.CAP_ROUND,
								BasicStroke.JOIN_ROUND));
   	    		 System.out.println("haha");
   	    		 System.out.println("!!!!!!!"+ MultiDraw.type+"!!!!!!!!");
   	    		 MultiDraw.type=1;
				}
			});
			maingame.getContentPane().add(button4);
			
			JButton button5 = new JButton("重画");
			button5.setBounds(510, 620, 100, 35);
			button5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					MD.clean();
				}
			});
			maingame.getContentPane().add(button5);
			
			
			
			
			/*JPanel mainpanel1 = new JPanel();
			mainpanel1.setBounds(0, 472, 197, 190);
			maingame.getContentPane().add(mainpanel1);
			mainpanel1.setLayout(new BorderLayout(0, 0));
			
			final JLabel Main1 = new JLabel("");
			Main1.setIcon(new ImageIcon(MainGame.class.getResource("./icon/头像1.jpg")));
			mainpanel1.add(Main1, BorderLayout.CENTER);
			
			JPanel mainpanel2 = new JPanel();
			mainpanel2.setBounds(198, 472, 197, 190);
			maingame.getContentPane().add(mainpanel2);
			mainpanel2.setLayout(new BorderLayout(0, 0));
			
			JLabel Main2 = new JLabel("");
			Main2.setIcon(new ImageIcon(MainGame.class.getResource("./icon/头像2.jpg")));
			mainpanel2.add(Main2, BorderLayout.CENTER);
			
			JPanel mainpanel3 = new JPanel();
			mainpanel3.setBounds(397, 472, 197, 190);
			maingame.getContentPane().add(mainpanel3);
			mainpanel3.setLayout(new BorderLayout(0, 0));
			
			JLabel Main3 = new JLabel("");
			Main3.setIcon(new ImageIcon(MainGame.class.getResource("./icon/头像3.jpg")));
			mainpanel3.add(Main3, BorderLayout.CENTER);
			
			JPanel mainpanel4 = new JPanel();
			mainpanel4.setBounds(595, 472, 197, 190);
			maingame.getContentPane().add(mainpanel4);
			mainpanel4.setLayout(new BorderLayout(0, 0));
			
			JLabel Main4 = new JLabel("");
			Main4.setIcon(new ImageIcon(MainGame.class.getResource("./icon/头像4.jpg")));
			mainpanel4.add(Main4, BorderLayout.CENTER);*/
	
			maintextField = new JTextArea();
			maintextField.setBounds(792, 366, 182, 30);
			maingame.getContentPane().add(maintextField);
			maintextField.setColumns(10);
			
			JButton mainButton1 = new JButton("GO");
			mainButton1.setForeground(Color.ORANGE);
			mainButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str505=maintextField.getText();
					try {
						os.writeUTF("4"+str505);}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					maintextField.setText("");
				}
			});
			mainButton1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
			mainButton1.setBounds(981, 366, 43, 30);
			maingame.getContentPane().add(mainButton1);
			
			maintextArea = new JTextArea();
			maintextArea.setFont(new Font("微软雅黑", Font.PLAIN, 17));
			maintextArea.setBounds(792, 0, 232, 356);
			maingame.getContentPane().add(maintextArea);
			
			JButton mainButton2 = new JButton("准备");
			mainButton2.setForeground(Color.BLUE);
			mainButton2.setFont(new Font("幼圆", Font.ITALIC, 24));
			mainButton2.setBounds(835, 504, 120, 54);
			mainButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//new Thread(new CounterThread()).start();
    	    		try {
						os.writeUTF("4准备好了");
						System.out.println("4准备好了");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			maingame.getContentPane().add(mainButton2);
			
			mainlabel4 = new JLabel("60");
			mainlabel4.setForeground(Color.GREEN);
			mainlabel4.setFont(new Font("微软雅黑", Font.PLAIN, 24));
			mainlabel4.setBounds(874, 568, 110, 59);
			maingame.getContentPane().add(mainlabel4);
			
			mainlabel6 = new JLabel("提示：");
			mainlabel6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			mainlabel6.setBounds(802, 422, 222, 40);
			maingame.getContentPane().add(mainlabel6);
			
			JLabel mainlabel7 = new JLabel("你的得分");
			mainlabel7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			mainlabel7.setBounds(792, 472, 99, 30);
			maingame.getContentPane().add(mainlabel7);
			
			JLabel mainlabel8 = new JLabel("");
			mainlabel8.setBounds(890, 468, 94, 40);
			maingame.getContentPane().add(mainlabel8);
			
			((JPanel)maingamecp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

			maingame.setBounds(200, 20, 1050,700);
			//maingame.setVisible(true);
			//以上是正式游戏界面			
			
			
			
		
			
			
			
			
			
				
			
			//在游戏房间界面之前，首先要得到房间1的界面显示
			final JFrame chair=new JFrame("游戏房间");
			chair.setResizable(false);
			chair.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
//			chair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon chairimg = new ImageIcon(startgame.class.getResource("./icon/room1photo.jpg"));//这是背景图片
			JLabel chairimgLabel = new JLabel(chairimg);//将背景图放在标签里。

			chair.getLayeredPane().add(chairimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
			chairimgLabel.setBounds(0,0,600, 600);//设置背景标签的位置
			JPanel chaircp=(JPanel) chair.getContentPane();
			chair.getContentPane().setLayout(null);
			
			JLabel chairlabel = new JLabel("你画我猜房间");
			chairlabel.setFont(new Font("微软雅黑", Font.PLAIN, 42));
			chairlabel.setBounds(176, 30, 292, 59);
			chair.getContentPane().add(chairlabel);
			
			JLabel lblPlayer1 = new JLabel("player1");
			lblPlayer1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			lblPlayer1.setBounds(71, 82, 82, 51);
			chair.getContentPane().add(lblPlayer1);
			
			JLabel lblPlayer2 = new JLabel("player2");
			lblPlayer2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			lblPlayer2.setBounds(326, 82, 118, 51);
			chair.getContentPane().add(lblPlayer2);
			
			JLabel lblPlayer3 = new JLabel("player3");
			lblPlayer3.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			lblPlayer3.setBounds(71, 349, 82, 51);
			chair.getContentPane().add(lblPlayer3);
			
			JLabel lblPlayer4 = new JLabel("player4");
			lblPlayer4.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			lblPlayer4.setBounds(326, 349, 94, 51);
			chair.getContentPane().add(lblPlayer4);
			
			JButton chairButton1 = new JButton("");
			chairButton1.setIcon(new ImageIcon(room1.class.getResource("./icon/头像1.jpg")));
			chairButton1.setBounds(71, 127, 185, 188);
			chairButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "您是一号玩家，欢迎进入游戏", "欢迎一号", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					  (new Thread(new listenthread(is, os))).start();		
				}
				
			});

			
			chair.getContentPane().add(chairButton1);
			
			JButton chairButton2 = new JButton("New button");
			chairButton2.setIcon(new ImageIcon(room1.class.getResource("./icon/头像2.jpg")));
			chairButton2.setBounds(326, 127, 185, 188);
			chairButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "您是二号玩家，欢迎进入游戏", "欢迎二号", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();		
				}
				
			});

			chair.getContentPane().add(chairButton2);
			
			JButton chairButton3 = new JButton("New button");
			chairButton3.setIcon(new ImageIcon(room1.class.getResource("./icon/头像3.jpg")));
			chairButton3.setBounds(71, 404, 185, 188);
			chairButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "您是三号玩家，欢迎进入游戏", "欢迎三号", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();	
				}
				
			});

			chair.getContentPane().add(chairButton3);
			
			JButton chairButton4 = new JButton("New button");
			chairButton4.setIcon(new ImageIcon(room1.class.getResource("./icon/头像4.jpg")));
			chairButton4.setBounds(326, 404, 185, 188);
			chairButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "您是四号玩家，欢迎进入游戏", "欢迎四号", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();	
				}
			});

			chair.getContentPane().add(chairButton4);
			
			final JLabel chairlabel1 = new JLabel("不在线");
			chairlabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
			chairlabel1.setBounds(163, 82, 118, 51);
			chair.getContentPane().add(chairlabel1);
			
			final JLabel chairlabel2 = new JLabel("不在线");
			chairlabel2.setFont(new Font("微软雅黑", Font.BOLD, 18));
			chairlabel2.setBounds(418, 84, 118, 51);
			chair.getContentPane().add(chairlabel2);
			
			final JLabel chairlabel3 = new JLabel("不在线");
			chairlabel3.setFont(new Font("微软雅黑", Font.BOLD, 18));
			chairlabel3.setBounds(177, 351, 118, 51);
			chair.getContentPane().add(chairlabel3);
			
			final JLabel chairlabel4 = new JLabel("不在线");
			chairlabel4.setFont(new Font("微软雅黑", Font.BOLD, 18));
			chairlabel4.setBounds(418, 349, 118, 51);
			chair.getContentPane().add(chairlabel4);
			
			((JPanel)chaircp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

			chair.setBounds(280, 40, 620,640);
//			chair.setVisible(true);
			//以上是房间1的界面显示
			
			
			
			//游戏房间的界面
			final JFrame room=new JFrame("游戏大厅");
			room.setResizable(false);
			room.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
//			room.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon roomimg = new ImageIcon(startgame.class.getResource("./icon/room.jpg"));//这是背景图片
			JLabel roomimgLabel = new JLabel(roomimg);//将背景图放在标签里。

			room.getLayeredPane().add(roomimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
			roomimgLabel.setBounds(0,0,1000, 600);//设置背景标签的位置
			JPanel roomcp=(JPanel) room.getContentPane();
			room.getContentPane().setLayout(null);
			
			roomlabel1 = new JLabel("房间1：0人");
			roomlabel1.setFont(new Font("微软雅黑", Font.PLAIN, 27));
			roomlabel1.setBounds(112, 438, 145, 45);
			room.getContentPane().add(roomlabel1);
			
			roomlabel2 = new JLabel("房间2：0人");
			roomlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 27));
			roomlabel2.setBounds(342, 438, 145, 45);
			room.getContentPane().add(roomlabel2);
			
			roomlabel3 = new JLabel("房间3：0人");
			roomlabel3.setFont(new Font("微软雅黑", Font.PLAIN, 27));
			roomlabel3.setBounds(583, 438, 145, 45);
			room.getContentPane().add(roomlabel3);
			
			roomlabel4 = new JLabel("房间4：0人");
			roomlabel4.setFont(new Font("微软雅黑", Font.PLAIN, 27));
			roomlabel4.setBounds(829, 438, 145, 45);
			room.getContentPane().add(roomlabel4);
			
			JButton roomButton1 = new JButton("");
			roomButton1.setIcon(new ImageIcon(room.class.getResource("./icon/room1.jpg")));
			roomButton1.setBounds(27, 76, 231, 341);
			roomButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair是游戏房间
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel1.setText("房间1有人");
					
				}
				
			});
				   
			room.getContentPane().add(roomButton1);
			
			JButton roomButton2 = new JButton("New button");
			roomButton2.setIcon(new ImageIcon(room.class.getResource("./icon/room2.jpg")));
			roomButton2.setBounds(268, 76, 231, 341);
			roomButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair是游戏房间
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel2.setText("房间2有人");
				}
				
			});
			room.getContentPane().add(roomButton2);
			
			JButton roomButton3 = new JButton("New button");
			roomButton3.setIcon(new ImageIcon(room.class.getResource("./icon/room3.jpg")));
			roomButton3.setBounds(509, 76, 231, 341);
			roomButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair是游戏房间
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel3.setText("房间3有人");
				}
				
			});
			room.getContentPane().add(roomButton3);
			
			JButton roomButton4 = new JButton("New button");
			roomButton4.setIcon(new ImageIcon(room.class.getResource("./icon/room4.jpg")));
			roomButton4.setBounds(750, 76, 231, 341);
			roomButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair是游戏房间
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel4.setText("房间4有人");
				}
				
			});
			room.getContentPane().add(roomButton4);
			
			JLabel roomButton5 = new JLabel("游戏大厅");
			roomButton5.setFont(new Font("微软雅黑", Font.BOLD, 39));
			roomButton5.setBounds(416, 10, 338, 62);
			room.getContentPane().add(roomButton5);
			
			((JPanel)roomcp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

			room.setBounds(280, 40, 1000,640);
	    	//以上是游戏房间的界面
			
				
		    //再得到登陆游戏的界面
		    final JFrame login=new JFrame("登录界面");
		    login.setResizable(false);
		    login.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
        //	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon loginimg = new ImageIcon(startgame.class.getResource("./icon/login.jpg"));//这是背景图片
			JLabel loginimgLabel = new JLabel(loginimg);//将背景图放在标签里。

			login.getLayeredPane().add(loginimgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
			loginimgLabel.setBounds(0,0,600, 600);//设置背景标签的位置
			JPanel logincp=(JPanel) login.getContentPane();
			login.getContentPane().setLayout(null);
			
			JLabel loginlabel = new JLabel("用户名");
			loginlabel.setFont(new Font("仿宋", Font.PLAIN, 26));
			loginlabel.setBounds(153, 268, 106, 41);
			login.getContentPane().add(loginlabel);
			
			final JTextField logintextField = new JTextField();
			logintextField.setBounds(284, 268, 156, 41);
			login.getContentPane().add(logintextField);
			logintextField.setColumns(10);
			
			JLabel loginlabel1 = new JLabel("密码");
			loginlabel1.setFont(new Font("仿宋", Font.PLAIN, 26));
			loginlabel1.setBounds(153, 347, 106, 41);
			login.getContentPane().add(loginlabel1);
			
			final JPasswordField passwordField = new JPasswordField();
			passwordField.setBounds(284, 349, 156, 39);
			login.getContentPane().add(passwordField);
			
			JLabel loginlabel2 = new JLabel("用户登录");
			loginlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 36));
			loginlabel2.setBounds(214, 195, 188, 46);
			login.getContentPane().add(loginlabel2);
			
			JButton loginbutton1 = new JButton("登陆");
			loginbutton1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			loginbutton1.setBounds(230, 423, 133, 46);
            loginbutton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("等待登录");
					login.setVisible(false);
					String username1=logintextField.getText();
					String userpassword1=passwordField.getText();
					
					try {
	    				os.writeUTF("1");
	    				System.out.println("it reach here");
						os.writeUTF(username1);
						os.writeUTF(userpassword1);
						System.out.println("under reach");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try{
						String str3=is.readUTF();
						System.out.println("under under!");
						System.out.println("--------------------------");
						//szchsh myarray=new szchsh(des1);
						//des1=myarray.readObject(is);
	                    //登录成功，但还没进房间					
						if(str3.equals("登陆成功")){
							//System.out.println("登录成功");
							room.setVisible(true);
							a=is.readInt();
							size=a+1;
							System.out.println("***************(((((((("+a+"))))))))))*****************");
							//if (roomlabel1.getText()=="房间1有人")
							roomlabel1.setText("房间1："+a+"人");
						/*	else if (roomlabel2.getText()=="房间2有人")
								roomlabel2.setText("房间1："+a+"人");
							else if (roomlabel3.getText()=="房间3有人")
								roomlabel3.setText("房间1："+a+"人");
							else if (roomlabel4.getText()=="房间4有人")
								roomlabel4.setText("房间1："+a+"人");*/
							if(a>0){
								for(int i=1;i<=a;i++){
								     if(i==1){
								    	 chairlabel1.setText("在线");
								    	 
								     }
								     if(i==2){
								    	 chairlabel2.setText("在线");
								     }
								     if(i==3){
								    	 chairlabel3.setText("在线");
								     }
								     if(i==4){
								    	 chairlabel4.setText("在线");
								     }
								     
								}
							}
							}
						else  if(str3.equals("密码错误")){
							JOptionPane.showMessageDialog(null, "用户名或密码错误！！", "警告", JOptionPane.ERROR_MESSAGE); 
						}
					}catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}
			});
			login.getContentPane().add(loginbutton1);
			
			JLabel loginlabel3 = new JLabel("还没有用户名，免费注册吧");
			loginlabel3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			loginlabel3.setBounds(200, 479, 281, 32);
			login.getContentPane().add(loginlabel3);
			
			JButton loginbutton2 = new JButton("注册");
			loginbutton2.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			loginbutton2.setBounds(230, 521, 133, 46);
			loginbutton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					register.setVisible(true);
				}
			});
			
			login.getContentPane().add(loginbutton2);
			
			((JPanel)logincp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

			login.setBounds(280, 40, 620,640);
			//以上是登陆游戏的界面
		
		
				
			
			
		final JFrame start=new JFrame("首界面");
		start.setResizable(false);
		start.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/角图.jpg")));
//		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(startgame.class.getResource("./icon/startgame.jpg"));//这是背景图片
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
		
		JButton start2 = new JButton("开始游戏");
		start2.setFont(new Font("仿宋", Font.PLAIN, 23));
		start2.setBounds(86, 504, 137, 41);
		start.getContentPane().add(start2);
        start2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login.setVisible(true);
				start.setVisible(false);
			}
		});
		

		JButton start1 = new JButton("规则介绍");
		start1.setFont(new Font("仿宋", Font.PLAIN, 23));
		start1.setBounds(375, 504, 137, 41);
		start1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rule.setVisible(true);
			}
		});
		start.getContentPane().add(start1);

		start.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jframe的LayeredPane面板里。
		imgLabel.setBounds(0,0,600, 600);//设置背景标签的位置
		JPanel cp=(JPanel) start.getContentPane();
		start.getContentPane().setLayout(null);
		
		
		((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

		start.setBounds(280, 40, 620,640);
		start.setVisible(true);
	
		}
}
