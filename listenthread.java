package �㻭�Ҳ�;






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
		//	���ء���ʾ��
			mylabel=mylisten.getLabel();
			 MultiDraw MD=mylisten.getMD();
			while(true){
				System.out.println (is == null);
				//���������ͻ�����Ϣ    ���talkthread��Ϣ
				str=is.readUTF();
				int mmm=1;
				System.out.println(str+mmm);
				mmm++;
				if(!str.equals("�ɹ�")){
					
				System.out.println(str+"************************");
				
				//talkthread ���͵�str
					  if(str.substring(0, 4).equals("talk")){
						 
						 text=str.substring(4, str.length());
						 text=textArea505_1.getText()+"\n"+text;
						 textArea505_1.setText(text);
						 textArea505_1.setLineWrap(true);
					  }
				  //sendthread ���͵�"Ҫ�������ǣ�"+trueexpression   or    "��ʾҪ�´���ĳ����ǣ�"+trueexpression.length()+""
					  else if(str.substring(0, 4).equals("$$$$")){
					     message=str.substring(4,str.length());
					     //
					  mylabel.setText(message);
					     System.out.println(message+"+++++++++++++++++++++++++++");
								     if(message.substring(0, 2).equals("Ҫ��")){
								    	 //(MultiDraw.g2).setColor(Color.BLACK);
								    	 //�û�����Ի�
								    	 MD.addMouseListener(MD);
				                       	 MD.addMouseMotionListener(MD);
				                       	 
				                       	 //��ʾ��ʾҪ���Ľ���
				                    /*   	JFrame JF=new JFrame();
								    	JF.setBounds(600, 230, 250, 150);
								    	JF.getContentPane().setLayout(null);
								    	
								    	JLabel lb = new JLabel("���㻭��");
								    	lb.setFont(new Font("����", Font.PLAIN, 23));
								    	lb.setBounds(10, 22, 214, 55);
								    	JF.getContentPane().add(lb);
								    	JF.setVisible(true);*/
				                       	 JOptionPane.showMessageDialog(null, "���㻭�ˣ�", "˵��", JOptionPane.ERROR_MESSAGE);
				                       	 
								     }
									   else if(message.substring(0, 2).equals("��ʾ")){
									    	 System.out.println("____________________***********(((((((((((())))))))+++++++++++++");
									    	 //���ܻ�
									    	 MD.removeMouseListener(MD);
									    	 MD.removeMouseMotionListener(MD);
									    	System.out.println(message.substring(0, 7)+"++++++++++++++++++++++++++++");
									    	
									    	//��ʾ��ʾҪ�µĽ���
									    	/*JFrame JF=new JFrame();
									    	JF.setBounds(600, 230, 250, 150);
									    	JF.getContentPane().setLayout(null);
									    	
									    	JLabel lb = new JLabel("�������");
									    	lb.setFont(new Font("����", Font.PLAIN, 23));
									    	lb.setBounds(10, 22, 214, 55);
									    	JF.getContentPane().add(lb);
									    	JF.setVisible(true);*/
									    	 JOptionPane.showMessageDialog(null, "������ˣ�", "˵��", JOptionPane.ERROR_MESSAGE);
									     }
						 CounterThread ct=new CounterThread();	     
				     new Thread(ct).start();
				     System.out.println("��������߳��ظ��˼���");
				     //else if
				}
					  
					  
				//if(!str.equals("�ɹ�"))	  
				}
			//	while
			}
		//try		
		}      
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("û�н��յ�˵��������");
		}
		//run
	}
 //runable  
}






