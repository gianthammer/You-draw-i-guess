package �㻭�Ҳ�;





import java.awt.Graphics2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

public class talkThread extends Thread {

	String panduan;
	String str;
	private DataInputStream ios;
	private DataOutputStream oos;
	private DataInputStream is;
	private DataOutputStream os;
	String useruser;
	String username;
	String password;
	String message;
	int grade;

	//new talkThread(is, os, panduan.substring(1, panduan.length()),
	//user,useruser,passpass).start();
	
	
	//str ׼������    
	public talkThread(DataInputStream is, DataOutputStream os, String str,
			String useruser, String username, String password) {
		this.oos = os;
		this.ios = is;
		//str=׼������   ���ǲµĴ�
		this.str = str;
		this.useruser = useruser;
		this.username = username;
		this.password = password;
	}

	public void run() {
		MyServer server = new MyServer();
		ArrayList<DataInputStream> isarray = server.getIs();
		ArrayList<DataOutputStream> osarray = server.getOs();

	//	String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	//	String conURL = "jdbc:odbc:draw";
		try {
			if (str.equals("׼������")) {
				//sum=0,׼���õ���
				//Ϊʲô��1 
				System.out.println("֮ǰserver.sum��" + server.sum);
				server.sum++;
				System.out.println("֮��server.sum��" + server.sum);
				System.out.println("֮��server.getdes1.size()��"
						+ server.getdes1().size());
			//��¼����
				System.out.println((server.getIs()).size());
				if (server.sum == (server.getIs()).size()) {
					new Thread(new SendThread(str + "0")).start();
				}
				// server.sum++;
				// if(server.sum==(server.getdes1()).size()){
				// int Ia=isarray.size();
				// for(int i=0;i<Ia;i++){
				// for(int ii=0;ii<Ia;ii++){
				// if(ii==i){
				// ...osarray.get(ii).writeUTF("1111//Ҫ�µĴ���");
				// }
				// else{
				// ...osarray.get(ii).writeUTF("1111+Ҫ�´���ĳ���");
				// }
				// }
				// }
				// }
			} else {
				if (str.equals(SendThread.trueexpression)) {
					str = str+"    "+"(ϵͳ��ʾ���¶��˴𰸣���ͼ�ߺͲ¶��߸���1�֣�";
					//ct.setFlag();
					
					//os=ex.getOS();
					//is=ex.getIS();
				
					
			   	 
					//new Thread(new listenthread(is,os)).start();
					
					

					try {
						Class.forName("com.mysql.jdbc.Driver"); // ����MYSQL
																// JDBC��������
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/draw","wgm","194785");
						// ����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������

						Statement stmt1 = connect.createStatement();

						final ResultSet rset3 = stmt1.executeQuery("SELECT * FROM users;");
						// rset.close();
						//�ƶ�����һ��
						if(rset3.first()){
							
							while (rset3.next()) {
								//�õ��û���
								final String str1 = rset3.getString(1);
								//�õ�����
								int ii2 = rset3.getInt(7);
								// �����sql���������ݿ��е�ֵ
								System.out.println("####" + username + "#####");
								//�û���ƥ��
								if (str1.equals(username)) {
									ii2 = ii2 + 1;
									grade=ii2;
									System.out.println("���������������������ӵĵ÷���" + ii2);
								}
							}//��������
								int result = stmt1
										.executeUpdate("UPDATE users SET grade= "	+ grade
												+ " where username ="
												+ username);
								System.out.println(result
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
							}
						
						

					} catch (Exception e1) {

						e1.printStackTrace();
					}
					//Ҫ���Ͷ���Ϣ    �û������µĴ�
					message = useruser + ":" + str;
					System.out.println(message);
					System.out.println("talk" + message);
					// int Ia = isarray.size();
					//��¼����
					int Ia = osarray.size();
					System.out.println("#################################" + Ia
							+ "#####################################");
					System.out.println("^^^^^```" + SendThread.trueexpression
							+ "````^^^^^");
					System.out.println("^^^^^````" + message + "^^^^^`````");

					for (int i = 0; i < Ia; i++) {
						osarray.get(i).writeUTF("talk" + message);
					}
				} else {
					int Ia = osarray.size();
					for (int i = 0; i < Ia; i++) {
						osarray.get(i).writeUTF("talk" + useruser + ":" + str);
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}



