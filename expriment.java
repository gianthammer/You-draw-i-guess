package �㻭�Ҳ�;

 
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
	static DataOutputStream os;//���
	static DataInputStream is; //����
	static int a;
	public static JLabel roomlabel1;
	public static JLabel roomlabel2;
	public static JLabel roomlabel3;
	public static JLabel roomlabel4;
	private static MultiDraw MD=new MultiDraw();//�¼�;
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
    
		
    	
    	
    	
    	
    	
		//��ע��ɹ�����֮ǰ��Ҫ�ȵõ�ע��ɹ���Ľ��棨���ý��������
		final JFrame success =new JFrame();
		success.setResizable(false);
		success.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
		success.setBounds(280, 40, 660,520);
		success.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel successlabel = new JLabel("");
		successlabel.setIcon(new ImageIcon(registersuccess.class.getResource("./icon/ע��ɹ�.jpg")));
		success.getContentPane().add(successlabel, BorderLayout.CENTER);
//		success.setVisible(true);
		
		//������ע��ɹ�����ʾ�Ľ���
	
		
		
		
		
		
		
		//�ȵõ�ע����Ϸ�Ľ��棬������ʾ����
		 final JFrame register=new JFrame("ע�����");
		 register.setResizable(false);
		 register.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
		 //register.setIconImage(Toolkit.getDefaultToolkit().getImage("/icon/��ͼ��jpg"));
			ImageIcon registerimg = new ImageIcon(startgame.class.getResource("./icon/register1.jpg"));//���Ǳ���ͼƬ
			JLabel registerimgLabel = new JLabel(registerimg);//������ͼ���ڱ�ǩ�

			register.getLayeredPane().add(registerimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
			registerimgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
			JPanel registercp=(JPanel) register.getContentPane();
			register.getContentPane().setLayout(null);
			
			JLabel registerlabel = new JLabel("�û���");
			registerlabel.setFont(new Font("����", Font.PLAIN, 22));
			registerlabel.setBounds(288, 126, 106, 37);
			register.getContentPane().add(registerlabel);
			
			registertextField = new JTextField();
			registertextField.setBounds(383, 126, 149, 37);
			register.getContentPane().add(registertextField);
			registertextField.setColumns(10);
			
			JLabel registerlabe2 = new JLabel("����");
			registerlabe2.setFont(new Font("����", Font.PLAIN, 22));
			registerlabe2.setBounds(288, 199, 106, 37);
			register.getContentPane().add(registerlabe2);
			
			JLabel registerlabe3 = new JLabel("�Ա�");
			registerlabe3.setFont(new Font("����", Font.PLAIN, 22));
			registerlabe3.setBounds(288, 404, 106, 37);
			register.getContentPane().add(registerlabe3);
			
			JLabel registerlabe4 = new JLabel("�ǳ�");
			registerlabe4.setFont(new Font("����", Font.PLAIN, 22));
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
			
			JLabel registerlabe5 = new JLabel("����");
			registerlabe5.setFont(new Font("����", Font.PLAIN, 22));
			registerlabe5.setBounds(288, 335, 106, 37);
			register.getContentPane().add(registerlabe5);
			
			registertextField1 = new JTextField();
			registertextField1.setColumns(10);
			registertextField1.setBounds(383, 404, 149, 37);
			register.getContentPane().add(registertextField1);
			
			JLabel registerlabe6 = new JLabel("�÷�");
			registerlabe6.setFont(new Font("����", Font.PLAIN, 22));
			registerlabe6.setBounds(288, 527, 106, 37);
			register.getContentPane().add(registerlabe6);
			
			JLabel registerlabe7 = new JLabel("0");
			registerlabe7.setFont(new Font("����", Font.PLAIN, 22));
			registerlabe7.setBounds(383, 527, 149, 37);
			register.getContentPane().add(registerlabe7);
			
			JLabel registerlabe8 = new JLabel("�û�ע��");
			registerlabe8.setFont(new Font("΢���ź�", Font.PLAIN, 40));
			registerlabe8.setBounds(216, 54, 205, 54);
			register.getContentPane().add(registerlabe8);
			
			JLabel registerlabe9 = new JLabel("����");
			registerlabe9.setFont(new Font("����", Font.PLAIN, 22));
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
			
			JLabel registerlabe10 = new JLabel("�㻭�Ҳ�");
			registerlabe10.setFont(new Font("΢���ź�", Font.PLAIN, 40));
			registerlabe10.setBounds(216, 10, 205, 54);
			register.getContentPane().add(registerlabe10);
			
			JButton registerButton = new JButton("ע��");
			registerButton.setFont(new Font("΢���ź�", Font.PLAIN, 27));
			registerButton.setBounds(329, 558, 134, 44);
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Ҫ��õ��ӷ������ķ���ֵ����ô��Ҫ������д�Ĵ�����������ͨ�����ݿ���д���
					
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
						
						if(str.equals("��Ч��ע��")){
							 JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�����ע��ɣ�", "����", JOptionPane.ERROR_MESSAGE);    

							
						}
						else if(str.equals("ע��ɹ�")){
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
			((JPanel)registercp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
			register.setBounds(280, 40, 620,640);
            //������ע����Ϸ�Ľ���
			
		
			
			
			
					
			//�õ���Ϸ������ܽ���
			final JFrame rule=new JFrame();
			rule.setResizable(false);
			rule.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
			rule.setBounds(280, 40, 600,480);
			rule.getContentPane().setLayout(new BorderLayout(0, 0));
			
			JLabel rulelabel = new JLabel("");
			rulelabel.setIcon(new ImageIcon(rule.class.getResource("./icon/������� .jpg")));
			rule.getContentPane().add(rulelabel, BorderLayout.CENTER);
		    //��������Ϸ������ܽ���
			
			
	
			
			//����Ϸ����1�Ľ�����ʾ����֮ǰ��Ҫ�Ƚ���ʽ��Ϸ�Ľ����ʼ�������ǲ���������ʾ����
			maingame=new JFrame("��Ϸ����");
			maingame.setResizable(false);
			maingame.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
			maingame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon maingameimg = new ImageIcon(startgame.class.getResource("./icon/MainGame.jpg"));//���Ǳ���ͼƬ
			JLabel maingameimgLabel = new JLabel(maingameimg);//������ͼ���ڱ�ǩ�

			maingame.getLayeredPane().add(maingameimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
			maingameimgLabel.setBounds(0,0,1100, 700);//���ñ�����ǩ��λ��
			JPanel maingamecp=(JPanel) maingame.getContentPane();
			maingame.getContentPane().setLayout(null);
			
			 maingamepanel = new JPanel();
			maingamepanel.setBounds(0, 0, 792, 600);
			maingamepanel.setLayout(new BorderLayout());
			
			/*MD=new MultiDraw();//�¼�
	   	    g2=MD.getG2();*/
	   	    maingamepanel.add(MD);
	   	    MD.setLayout(null);
	   	
	   	    JButton pencil = new JButton("Ǧ��");
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
	   	    
	   	    JButton eraser = new JButton("��Ƥ");
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
			
			
			JButton button1 = new JButton("Ǧ��");
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
			
			JButton button2 = new JButton("��ϸ");
			button2.setBounds(145, 620, 100, 35);
			button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
				}
			});
			maingame.getContentPane().add(button2);
			
			JButton button3 = new JButton("��ɫ");
			button3.setBounds(270, 620, 100, 35);
			button3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					
				}
			});
			maingame.getContentPane().add(button3);
			
			JButton button4 = new JButton("��");
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
			
			JButton button5 = new JButton("�ػ�");
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
			Main1.setIcon(new ImageIcon(MainGame.class.getResource("./icon/ͷ��1.jpg")));
			mainpanel1.add(Main1, BorderLayout.CENTER);
			
			JPanel mainpanel2 = new JPanel();
			mainpanel2.setBounds(198, 472, 197, 190);
			maingame.getContentPane().add(mainpanel2);
			mainpanel2.setLayout(new BorderLayout(0, 0));
			
			JLabel Main2 = new JLabel("");
			Main2.setIcon(new ImageIcon(MainGame.class.getResource("./icon/ͷ��2.jpg")));
			mainpanel2.add(Main2, BorderLayout.CENTER);
			
			JPanel mainpanel3 = new JPanel();
			mainpanel3.setBounds(397, 472, 197, 190);
			maingame.getContentPane().add(mainpanel3);
			mainpanel3.setLayout(new BorderLayout(0, 0));
			
			JLabel Main3 = new JLabel("");
			Main3.setIcon(new ImageIcon(MainGame.class.getResource("./icon/ͷ��3.jpg")));
			mainpanel3.add(Main3, BorderLayout.CENTER);
			
			JPanel mainpanel4 = new JPanel();
			mainpanel4.setBounds(595, 472, 197, 190);
			maingame.getContentPane().add(mainpanel4);
			mainpanel4.setLayout(new BorderLayout(0, 0));
			
			JLabel Main4 = new JLabel("");
			Main4.setIcon(new ImageIcon(MainGame.class.getResource("./icon/ͷ��4.jpg")));
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
			mainButton1.setFont(new Font("��������", Font.PLAIN, 20));
			mainButton1.setBounds(981, 366, 43, 30);
			maingame.getContentPane().add(mainButton1);
			
			maintextArea = new JTextArea();
			maintextArea.setFont(new Font("΢���ź�", Font.PLAIN, 17));
			maintextArea.setBounds(792, 0, 232, 356);
			maingame.getContentPane().add(maintextArea);
			
			JButton mainButton2 = new JButton("׼��");
			mainButton2.setForeground(Color.BLUE);
			mainButton2.setFont(new Font("��Բ", Font.ITALIC, 24));
			mainButton2.setBounds(835, 504, 120, 54);
			mainButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//new Thread(new CounterThread()).start();
    	    		try {
						os.writeUTF("4׼������");
						System.out.println("4׼������");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			maingame.getContentPane().add(mainButton2);
			
			mainlabel4 = new JLabel("60");
			mainlabel4.setForeground(Color.GREEN);
			mainlabel4.setFont(new Font("΢���ź�", Font.PLAIN, 24));
			mainlabel4.setBounds(874, 568, 110, 59);
			maingame.getContentPane().add(mainlabel4);
			
			mainlabel6 = new JLabel("��ʾ��");
			mainlabel6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			mainlabel6.setBounds(802, 422, 222, 40);
			maingame.getContentPane().add(mainlabel6);
			
			JLabel mainlabel7 = new JLabel("��ĵ÷�");
			mainlabel7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			mainlabel7.setBounds(792, 472, 99, 30);
			maingame.getContentPane().add(mainlabel7);
			
			JLabel mainlabel8 = new JLabel("");
			mainlabel8.setBounds(890, 468, 94, 40);
			maingame.getContentPane().add(mainlabel8);
			
			((JPanel)maingamecp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

			maingame.setBounds(200, 20, 1050,700);
			//maingame.setVisible(true);
			//��������ʽ��Ϸ����			
			
			
			
		
			
			
			
			
			
				
			
			//����Ϸ�������֮ǰ������Ҫ�õ�����1�Ľ�����ʾ
			final JFrame chair=new JFrame("��Ϸ����");
			chair.setResizable(false);
			chair.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
//			chair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon chairimg = new ImageIcon(startgame.class.getResource("./icon/room1photo.jpg"));//���Ǳ���ͼƬ
			JLabel chairimgLabel = new JLabel(chairimg);//������ͼ���ڱ�ǩ�

			chair.getLayeredPane().add(chairimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
			chairimgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
			JPanel chaircp=(JPanel) chair.getContentPane();
			chair.getContentPane().setLayout(null);
			
			JLabel chairlabel = new JLabel("�㻭�Ҳ·���");
			chairlabel.setFont(new Font("΢���ź�", Font.PLAIN, 42));
			chairlabel.setBounds(176, 30, 292, 59);
			chair.getContentPane().add(chairlabel);
			
			JLabel lblPlayer1 = new JLabel("player1");
			lblPlayer1.setFont(new Font("΢���ź�", Font.PLAIN, 21));
			lblPlayer1.setBounds(71, 82, 82, 51);
			chair.getContentPane().add(lblPlayer1);
			
			JLabel lblPlayer2 = new JLabel("player2");
			lblPlayer2.setFont(new Font("΢���ź�", Font.PLAIN, 21));
			lblPlayer2.setBounds(326, 82, 118, 51);
			chair.getContentPane().add(lblPlayer2);
			
			JLabel lblPlayer3 = new JLabel("player3");
			lblPlayer3.setFont(new Font("΢���ź�", Font.PLAIN, 21));
			lblPlayer3.setBounds(71, 349, 82, 51);
			chair.getContentPane().add(lblPlayer3);
			
			JLabel lblPlayer4 = new JLabel("player4");
			lblPlayer4.setFont(new Font("΢���ź�", Font.PLAIN, 21));
			lblPlayer4.setBounds(326, 349, 94, 51);
			chair.getContentPane().add(lblPlayer4);
			
			JButton chairButton1 = new JButton("");
			chairButton1.setIcon(new ImageIcon(room1.class.getResource("./icon/ͷ��1.jpg")));
			chairButton1.setBounds(71, 127, 185, 188);
			chairButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "����һ����ң���ӭ������Ϸ", "��ӭһ��", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					  (new Thread(new listenthread(is, os))).start();		
				}
				
			});

			
			chair.getContentPane().add(chairButton1);
			
			JButton chairButton2 = new JButton("New button");
			chairButton2.setIcon(new ImageIcon(room1.class.getResource("./icon/ͷ��2.jpg")));
			chairButton2.setBounds(326, 127, 185, 188);
			chairButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "���Ƕ�����ң���ӭ������Ϸ", "��ӭ����", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();		
				}
				
			});

			chair.getContentPane().add(chairButton2);
			
			JButton chairButton3 = new JButton("New button");
			chairButton3.setIcon(new ImageIcon(room1.class.getResource("./icon/ͷ��3.jpg")));
			chairButton3.setBounds(71, 404, 185, 188);
			chairButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "����������ң���ӭ������Ϸ", "��ӭ����", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();	
				}
				
			});

			chair.getContentPane().add(chairButton3);
			
			JButton chairButton4 = new JButton("New button");
			chairButton4.setIcon(new ImageIcon(room1.class.getResource("./icon/ͷ��4.jpg")));
			chairButton4.setBounds(326, 404, 185, 188);
			chairButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "�����ĺ���ң���ӭ������Ϸ", "��ӭ�ĺ�", JOptionPane.ERROR_MESSAGE); 
					maingame.setVisible(true);
					chair.setVisible(false);
					 (new Thread(new listenthread(is, os))).start();	
				}
			});

			chair.getContentPane().add(chairButton4);
			
			final JLabel chairlabel1 = new JLabel("������");
			chairlabel1.setFont(new Font("΢���ź�", Font.BOLD, 18));
			chairlabel1.setBounds(163, 82, 118, 51);
			chair.getContentPane().add(chairlabel1);
			
			final JLabel chairlabel2 = new JLabel("������");
			chairlabel2.setFont(new Font("΢���ź�", Font.BOLD, 18));
			chairlabel2.setBounds(418, 84, 118, 51);
			chair.getContentPane().add(chairlabel2);
			
			final JLabel chairlabel3 = new JLabel("������");
			chairlabel3.setFont(new Font("΢���ź�", Font.BOLD, 18));
			chairlabel3.setBounds(177, 351, 118, 51);
			chair.getContentPane().add(chairlabel3);
			
			final JLabel chairlabel4 = new JLabel("������");
			chairlabel4.setFont(new Font("΢���ź�", Font.BOLD, 18));
			chairlabel4.setBounds(418, 349, 118, 51);
			chair.getContentPane().add(chairlabel4);
			
			((JPanel)chaircp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

			chair.setBounds(280, 40, 620,640);
//			chair.setVisible(true);
			//�����Ƿ���1�Ľ�����ʾ
			
			
			
			//��Ϸ����Ľ���
			final JFrame room=new JFrame("��Ϸ����");
			room.setResizable(false);
			room.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
//			room.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon roomimg = new ImageIcon(startgame.class.getResource("./icon/room.jpg"));//���Ǳ���ͼƬ
			JLabel roomimgLabel = new JLabel(roomimg);//������ͼ���ڱ�ǩ�

			room.getLayeredPane().add(roomimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
			roomimgLabel.setBounds(0,0,1000, 600);//���ñ�����ǩ��λ��
			JPanel roomcp=(JPanel) room.getContentPane();
			room.getContentPane().setLayout(null);
			
			roomlabel1 = new JLabel("����1��0��");
			roomlabel1.setFont(new Font("΢���ź�", Font.PLAIN, 27));
			roomlabel1.setBounds(112, 438, 145, 45);
			room.getContentPane().add(roomlabel1);
			
			roomlabel2 = new JLabel("����2��0��");
			roomlabel2.setFont(new Font("΢���ź�", Font.PLAIN, 27));
			roomlabel2.setBounds(342, 438, 145, 45);
			room.getContentPane().add(roomlabel2);
			
			roomlabel3 = new JLabel("����3��0��");
			roomlabel3.setFont(new Font("΢���ź�", Font.PLAIN, 27));
			roomlabel3.setBounds(583, 438, 145, 45);
			room.getContentPane().add(roomlabel3);
			
			roomlabel4 = new JLabel("����4��0��");
			roomlabel4.setFont(new Font("΢���ź�", Font.PLAIN, 27));
			roomlabel4.setBounds(829, 438, 145, 45);
			room.getContentPane().add(roomlabel4);
			
			JButton roomButton1 = new JButton("");
			roomButton1.setIcon(new ImageIcon(room.class.getResource("./icon/room1.jpg")));
			roomButton1.setBounds(27, 76, 231, 341);
			roomButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair����Ϸ����
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel1.setText("����1����");
					
				}
				
			});
				   
			room.getContentPane().add(roomButton1);
			
			JButton roomButton2 = new JButton("New button");
			roomButton2.setIcon(new ImageIcon(room.class.getResource("./icon/room2.jpg")));
			roomButton2.setBounds(268, 76, 231, 341);
			roomButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair����Ϸ����
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel2.setText("����2����");
				}
				
			});
			room.getContentPane().add(roomButton2);
			
			JButton roomButton3 = new JButton("New button");
			roomButton3.setIcon(new ImageIcon(room.class.getResource("./icon/room3.jpg")));
			roomButton3.setBounds(509, 76, 231, 341);
			roomButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair����Ϸ����
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel3.setText("����3����");
				}
				
			});
			room.getContentPane().add(roomButton3);
			
			JButton roomButton4 = new JButton("New button");
			roomButton4.setIcon(new ImageIcon(room.class.getResource("./icon/room4.jpg")));
			roomButton4.setBounds(750, 76, 231, 341);
			roomButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//chair����Ϸ����
					chair.setVisible(true);
					room.setVisible(false);
					roomlabel4.setText("����4����");
				}
				
			});
			room.getContentPane().add(roomButton4);
			
			JLabel roomButton5 = new JLabel("��Ϸ����");
			roomButton5.setFont(new Font("΢���ź�", Font.BOLD, 39));
			roomButton5.setBounds(416, 10, 338, 62);
			room.getContentPane().add(roomButton5);
			
			((JPanel)roomcp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

			room.setBounds(280, 40, 1000,640);
	    	//��������Ϸ����Ľ���
			
				
		    //�ٵõ���½��Ϸ�Ľ���
		    final JFrame login=new JFrame("��¼����");
		    login.setResizable(false);
		    login.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
        //	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon loginimg = new ImageIcon(startgame.class.getResource("./icon/login.jpg"));//���Ǳ���ͼƬ
			JLabel loginimgLabel = new JLabel(loginimg);//������ͼ���ڱ�ǩ�

			login.getLayeredPane().add(loginimgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
			loginimgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
			JPanel logincp=(JPanel) login.getContentPane();
			login.getContentPane().setLayout(null);
			
			JLabel loginlabel = new JLabel("�û���");
			loginlabel.setFont(new Font("����", Font.PLAIN, 26));
			loginlabel.setBounds(153, 268, 106, 41);
			login.getContentPane().add(loginlabel);
			
			final JTextField logintextField = new JTextField();
			logintextField.setBounds(284, 268, 156, 41);
			login.getContentPane().add(logintextField);
			logintextField.setColumns(10);
			
			JLabel loginlabel1 = new JLabel("����");
			loginlabel1.setFont(new Font("����", Font.PLAIN, 26));
			loginlabel1.setBounds(153, 347, 106, 41);
			login.getContentPane().add(loginlabel1);
			
			final JPasswordField passwordField = new JPasswordField();
			passwordField.setBounds(284, 349, 156, 39);
			login.getContentPane().add(passwordField);
			
			JLabel loginlabel2 = new JLabel("�û���¼");
			loginlabel2.setFont(new Font("΢���ź�", Font.PLAIN, 36));
			loginlabel2.setBounds(214, 195, 188, 46);
			login.getContentPane().add(loginlabel2);
			
			JButton loginbutton1 = new JButton("��½");
			loginbutton1.setFont(new Font("΢���ź�", Font.PLAIN, 30));
			loginbutton1.setBounds(230, 423, 133, 46);
            loginbutton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("�ȴ���¼");
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
	                    //��¼�ɹ�������û������					
						if(str3.equals("��½�ɹ�")){
							//System.out.println("��¼�ɹ�");
							room.setVisible(true);
							a=is.readInt();
							size=a+1;
							System.out.println("***************(((((((("+a+"))))))))))*****************");
							//if (roomlabel1.getText()=="����1����")
							roomlabel1.setText("����1��"+a+"��");
						/*	else if (roomlabel2.getText()=="����2����")
								roomlabel2.setText("����1��"+a+"��");
							else if (roomlabel3.getText()=="����3����")
								roomlabel3.setText("����1��"+a+"��");
							else if (roomlabel4.getText()=="����4����")
								roomlabel4.setText("����1��"+a+"��");*/
							if(a>0){
								for(int i=1;i<=a;i++){
								     if(i==1){
								    	 chairlabel1.setText("����");
								    	 
								     }
								     if(i==2){
								    	 chairlabel2.setText("����");
								     }
								     if(i==3){
								    	 chairlabel3.setText("����");
								     }
								     if(i==4){
								    	 chairlabel4.setText("����");
								     }
								     
								}
							}
							}
						else  if(str3.equals("�������")){
							JOptionPane.showMessageDialog(null, "�û�����������󣡣�", "����", JOptionPane.ERROR_MESSAGE); 
						}
					}catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}
			});
			login.getContentPane().add(loginbutton1);
			
			JLabel loginlabel3 = new JLabel("��û���û��������ע���");
			loginlabel3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
			loginlabel3.setBounds(200, 479, 281, 32);
			login.getContentPane().add(loginlabel3);
			
			JButton loginbutton2 = new JButton("ע��");
			loginbutton2.setFont(new Font("΢���ź�", Font.PLAIN, 30));
			loginbutton2.setBounds(230, 521, 133, 46);
			loginbutton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					register.setVisible(true);
				}
			});
			
			login.getContentPane().add(loginbutton2);
			
			((JPanel)logincp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

			login.setBounds(280, 40, 620,640);
			//�����ǵ�½��Ϸ�Ľ���
		
		
				
			
			
		final JFrame start=new JFrame("�׽���");
		start.setResizable(false);
		start.setIconImage(Toolkit.getDefaultToolkit().getImage(expriment.class.getResource("./icon/��ͼ.jpg")));
//		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(startgame.class.getResource("./icon/startgame.jpg"));//���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
		
		JButton start2 = new JButton("��ʼ��Ϸ");
		start2.setFont(new Font("����", Font.PLAIN, 23));
		start2.setBounds(86, 504, 137, 41);
		start.getContentPane().add(start2);
        start2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login.setVisible(true);
				start.setVisible(false);
			}
		});
		

		JButton start1 = new JButton("�������");
		start1.setFont(new Font("����", Font.PLAIN, 23));
		start1.setBounds(375, 504, 137, 41);
		start1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rule.setVisible(true);
			}
		});
		start.getContentPane().add(start1);

		start.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jframe��LayeredPane����
		imgLabel.setBounds(0,0,600, 600);//���ñ�����ǩ��λ��
		JPanel cp=(JPanel) start.getContentPane();
		start.getContentPane().setLayout(null);
		
		
		((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

		start.setBounds(280, 40, 620,640);
		start.setVisible(true);
	
		}
}
