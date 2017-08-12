package 你画我猜;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.ResultSet;



public class SendThread implements Runnable{
    
	String logo="$$$$";
	String message;    //str + "0"=message    str  准备好了
	String expression;   //单词
	public static String trueexpression;   //要猜的单词
	ArrayList<String> array=new ArrayList<String>();   //包含所有单词的数组
	MyServer server=new MyServer();
	ArrayList<DataInputStream> isarray=server.getIs();
    ArrayList<DataOutputStream>osarray=server.getOs();
    //ggggggggggggggggggggggggggggggggggggggggggggggggg
    //str + "0"=message
	public SendThread(String message){
		this.message=message;
	}
	
	
	
	public void run() {
		// TODO Auto-generated method stub
	//	String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		//String conURL = "jdbc:odbc:draw";
		try {
			Class.forName("com.mysql.jdbc.Driver"); //建立数据库连接，加载 JDBC驱动程序
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/draw","wgm","194785");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			Statement stmt = connect.createStatement();
			final ResultSet rset = (ResultSet) stmt.executeQuery("SELECT words FROM array where id>=1");
			while (rset.next()) {
				//得到所有单词，加入array
				 expression =rset.getString(1);
				 array.add(expression);
			}

		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		//登录人数    Ia
				int Ia=isarray.size();
				//0    1
				int Ib=Integer.parseInt(message.substring(message.length()-1, message.length()));
				//num=0
				System.out.println("((((((((((((((((((((((("+MyServer.num+"))))))))))))))))))))))))))");
				int Ic=(MyServer.num)/Ia;
				if(Ic<Ia){
					Ic=Ic;
				}
				else if(Ic>=Ia){
					Ic=Ic%Ia;
				}
				//得到一个单词
				trueexpression =array.get((int)(Math.random()*6));//注意数组越界
					for(int ii=0;ii<Ia;ii++){
						if(ii==Ic){
							try {
								osarray.get(ii).writeUTF(logo+"要画词语是："+trueexpression);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else{
							try {
								osarray.get(ii).writeUTF(logo+"提示要猜词语的长度是："+trueexpression.length()+"");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					MyServer.num++;
					System.out.println("))))))))))))))))))"+MyServer.num+"(((((((((((((");
//					 for (int mm = 60; i >0; i--) { 
//				            try { 
//				                Thread.sleep(1000);
//				                System.out.print("    线程睡眠1秒！\n"); 
//				            } catch (InterruptedException e) { 
//				                e.printStackTrace(); 
//				            } 
//				        } 
//				}
			
	}

}






