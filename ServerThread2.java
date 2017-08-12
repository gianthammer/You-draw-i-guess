package 你画我猜;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


//import GUI.szchsh;

//import com.mysql.jdbc.ResultSet;

public class ServerThread2 implements Runnable {

	String panduan;
	String username;
	String userpassword;
	String usernickname;
	String userage;
	String usersex;
	String userconstellation;
	String username1;
	String userpassword1;
	DataInputStream is;
	DataOutputStream os;
	String user = " ";
	boolean aa = false;
	
	MyServer button = new MyServer();
	ArrayList<String> des1 = button.getdes1();
	ArrayList<Socket> socketList = button.getSocket();
	ArrayList<DataInputStream> isarray = button.getIs();
	ArrayList<DataOutputStream> osarray = button.getOs();
	public static String useruser;
	public static String passpass;
	Socket s = null;// 定义当前线程所处理的Socket
	BufferedReader br = null;// 该线程所处理Socket所对应的输入流

	public ServerThread2(Socket s) throws IOException {
		this.s = s;
	}

	public void run() {
		int ph = button.getNum();
		is = isarray.get(ph);
		os = osarray.get(ph);
		ph++;
		int number = ph;
		//设 number=1
		button.setNum(number);

		while (true) {
			try {
				panduan = is.readUTF();
				System.out.println("***************************");
				System.out.println(panduan);
				System.out.println(panduan.substring(0, 1));
				System.out.println(panduan.substring(1, panduan.length()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				// e2.printStackTrace();
				System.out.println("panduan没有接收到");
			}
			if (panduan.equals("0")) {
				try {					
					username = is.readUTF();
					userpassword = is.readUTF();
					usernickname = is.readUTF();
					userage = is.readUTF();
					usersex = is.readUTF();
					userconstellation = is.readUTF();

				} catch (IOException e) {
					e.printStackTrace();
				}

				if (username.equals("") || userpassword.equals("")) 
				{
					// 如果用户名或密码有一个为空
					// 注侧无效的frame显示
					// frame1000.setVisible(true);//frame1000是一个表示注册无效的界面
					try {
						os.writeUTF("无效的注册");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else {
					try {
						os.writeUTF("注册成功");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try{	
                        Class.forName("com.mysql.jdbc.Driver"); //加载mysql

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//String url = "jdbc:odbc:draw";//zhentian de yu ju 
					try {
					//	String url = "jdbc:odbc:draw";
						Connection connect = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/draw","wgm","194785");
						Statement stmt = connect.createStatement();
						int rowachanged = stmt.executeUpdate("insert into users VALUES('"
										+ username
										+ "','"
										+ userpassword
										+ "','"
										+ usernickname
										+ "','"
										+ userage
										+ "','"
										+ usersex
										+ "','"
										+ userconstellation
										+ "','"
										+ 0//grade
										+ "')");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
//gggggggggg
			} else if (panduan.equals("3")) {
				try {
					String str4 = is.readUTF();
					System.out.println(str4);
					System.out.println(str4.substring(6, 7));
					if (str4.substring(6, 7).equals("1")) {
//gggggggggg
						des1.add(str4);
					}
					System.out.println("在ServerThread中的des1的大小是" + des1.size());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					os.writeUTF("成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (panduan.equals("1")) {
				try {
					username1 = is.readUTF();
					//输入的用户名
					user = username1;
					System.out.println(user + "****************************"
							+ "_______________________________");
					userpassword1 = is.readUTF();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					Connection connect = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/draw","wgm","194785");
					// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

					Statement stmt = connect.createStatement();
					if (username1.equals("") || userpassword1.equals("")) {
						System.out
								.println("****************************************");
						os.writeUTF("密码错误");

					} else {
						final ResultSet rset = (ResultSet) stmt
								.executeQuery("SELECT * FROM users");
						//while循环
						while (rset.next()) {
							
							final String str1 = rset.getString(1);
							final String str2 = rset.getString(2);
							if (str1.equals(username1)&& str2.equals(userpassword1)) {
								// os2 = new
								// DataOutputStream(s.getOutputStream());
								//确定匹配的用户名
								useruser=username1;
								passpass=userpassword1;
								System.out.println("---------------77777777777777777");
								MyServer.playersum++;
								os.writeUTF("登陆成功");
								System.out
										.println("---------------7777777777777777788888888888888888");
								int a =MyServer.playersum;
								System.out.println("参与游戏的人的个数是" + a);
								os.writeInt(a);

								break;
							}
						}
						if (!rset.next()) {

							os.writeUTF("密码错误");

						}

					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else if (panduan.substring(0, 1).equals("4")) {
				System.out.println(panduan.substring(1, panduan.length()));
				new talkThread(is, os, panduan.substring(1, panduan.length()),user,useruser,passpass).start();
				System.out.println("******************************");
				
			} else if (panduan.substring(0, 1).equals("5")) {
				new Thread(new SendThread(panduan.substring(1, panduan.length()))).start();
			}

		}

	}
}



