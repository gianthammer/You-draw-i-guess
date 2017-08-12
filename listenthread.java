package 你画我猜;






import java.awt.Color;
import java.awt.Font;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class listenthread implements Runnable {
    
	 JTextArea textArea505_1;
	 JTextField textfield;
	 JLabel mylabel;
	 DataInputStream is;
	 DataOutputStream os;
	 String str;
	 String text;
	 String message;
	public listenthread(DataInputStream is,DataOutputStream os){
		System.out.println("20+"+is==null);
		this.is=is;
		this.os= os;
	}
	
	
	

	public void run() {
		// TODO Auto-generated method stub
		try {
			expriment  mylisten=new expriment();
			textArea505_1=mylisten.getTextArea();
		//	返回“提示”
			mylabel=mylisten.getLabel();
			 MultiDraw MD=mylisten.getMD();
			while(true){
				System.out.println (is == null);
				//服务器读客户端信息    或读talkthread信息
				str=is.readUTF();
				int mmm=1;
				System.out.println(str+mmm);
				mmm++;
				if(!str.equals("成功")){
					
				System.out.println(str+"************************");
				
				//talkthread 发送的str
					  if(str.substring(0, 4).equals("talk")){
						 
						 text=str.substring(4, str.length());
						 text=textArea505_1.getText()+"\n"+text;
						 textArea505_1.setText(text);
						 textArea505_1.setLineWrap(true);
					  }
				  //sendthread 发送的"要画词语是："+trueexpression   or    "提示要猜词语的长度是："+trueexpression.length()+""
					  else if(str.substring(0, 4).equals("$$$$")){
					     message=str.substring(4,str.length());
					     //
					  mylabel.setText(message);
					     System.out.println(message+"+++++++++++++++++++++++++++");
								     if(message.substring(0, 2).equals("要画")){
								    	 //(MultiDraw.g2).setColor(Color.BLACK);
								    	 //让画板可以画
								    	 MD.addMouseListener(MD);
				                       	 MD.addMouseMotionListener(MD);
				                       	 
				                       	 //显示提示要画的界面
				                    /*   	JFrame JF=new JFrame();
								    	JF.setBounds(600, 230, 250, 150);
								    	JF.getContentPane().setLayout(null);
								    	
								    	JLabel lb = new JLabel("到你画了");
								    	lb.setFont(new Font("仿宋", Font.PLAIN, 23));
								    	lb.setBounds(10, 22, 214, 55);
								    	JF.getContentPane().add(lb);
								    	JF.setVisible(true);*/
				                       	 JOptionPane.showMessageDialog(null, "到你画了！", "说明", JOptionPane.ERROR_MESSAGE);
				                       	 
								     }
									   else if(message.substring(0, 2).equals("提示")){
									    	 System.out.println("____________________***********(((((((((((())))))))+++++++++++++");
									    	 //不能画
									    	 MD.removeMouseListener(MD);
									    	 MD.removeMouseMotionListener(MD);
									    	System.out.println(message.substring(0, 7)+"++++++++++++++++++++++++++++");
									    	
									    	//显示提示要猜的界面
									    	/*JFrame JF=new JFrame();
									    	JF.setBounds(600, 230, 250, 150);
									    	JF.getContentPane().setLayout(null);
									    	
									    	JLabel lb = new JLabel("到你猜了");
									    	lb.setFont(new Font("仿宋", Font.PLAIN, 23));
									    	lb.setBounds(10, 22, 214, 55);
									    	JF.getContentPane().add(lb);
									    	JF.setVisible(true);*/
									    	 JOptionPane.showMessageDialog(null, "到你猜了！", "说明", JOptionPane.ERROR_MESSAGE);
									     }
						 CounterThread ct=new CounterThread();	     
				     new Thread(ct).start();
				     System.out.println("这个计数线程重复了几次");
				     //else if
				}
					  
					  
				//if(!str.equals("成功"))	  
				}
			//	while
			}
		//try		
		}      
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("没有接收到说话的内容");
		}
		//run
	}
 //runable  
}






