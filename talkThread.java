package 你画我猜;





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
	
	
	//str 准备好了    
	public talkThread(DataInputStream is, DataOutputStream os, String str,
			String useruser, String username, String password) {
		this.oos = os;
		this.ios = is;
		//str=准备好了   或是猜的答案
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
			if (str.equals("准备好了")) {
				//sum=0,准备好的人
				//为什么是1 
				System.out.println("之前server.sum是" + server.sum);
				server.sum++;
				System.out.println("之后server.sum是" + server.sum);
				System.out.println("之后server.getdes1.size()是"
						+ server.getdes1().size());
			//登录人数
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
				// ...osarray.get(ii).writeUTF("1111//要猜的词语");
				// }
				// else{
				// ...osarray.get(ii).writeUTF("1111+要猜词语的长度");
				// }
				// }
				// }
				// }
			} else {
				if (str.equals(SendThread.trueexpression)) {
					str = str+"    "+"(系统提示：猜对了答案，画图者和猜对者各加1分）";
					//ct.setFlag();
					
					//os=ex.getOS();
					//is=ex.getIS();
				
					
			   	 
					//new Thread(new listenthread(is,os)).start();
					
					

					try {
						Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL
																// JDBC驱动程序
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/draw","wgm","194785");
						// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

						Statement stmt1 = connect.createStatement();

						final ResultSet rset3 = stmt1.executeQuery("SELECT * FROM users;");
						// rset.close();
						//移动到第一行
						if(rset3.first()){
							
							while (rset3.next()) {
								//得到用户名
								final String str1 = rset3.getString(1);
								//得到分数
								int ii2 = rset3.getInt(7);
								// 如何用sql语句更改数据库中的值
								System.out.println("####" + username + "#####");
								//用户名匹配
								if (str1.equals(username)) {
									ii2 = ii2 + 1;
									grade=ii2;
									System.out.println("哈哈哈哈哈哈哈哈，增加的得分是" + ii2);
								}
							}//更改数据
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
					//要发送短消息    用户名：猜的答案
					message = useruser + ":" + str;
					System.out.println(message);
					System.out.println("talk" + message);
					// int Ia = isarray.size();
					//登录人数
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



