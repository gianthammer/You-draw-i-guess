package �㻭�Ҳ�;

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
	String message;    //str + "0"=message    str  ׼������
	String expression;   //����
	public static String trueexpression;   //Ҫ�µĵ���
	ArrayList<String> array=new ArrayList<String>();   //�������е��ʵ�����
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
			Class.forName("com.mysql.jdbc.Driver"); //�������ݿ����ӣ����� JDBC��������
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/draw","wgm","194785");
			// ����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������

			Statement stmt = connect.createStatement();
			final ResultSet rset = (ResultSet) stmt.executeQuery("SELECT words FROM array where id>=1");
			while (rset.next()) {
				//�õ����е��ʣ�����array
				 expression =rset.getString(1);
				 array.add(expression);
			}

		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		//��¼����    Ia
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
				//�õ�һ������
				trueexpression =array.get((int)(Math.random()*6));//ע������Խ��
					for(int ii=0;ii<Ia;ii++){
						if(ii==Ic){
							try {
								osarray.get(ii).writeUTF(logo+"Ҫ�������ǣ�"+trueexpression);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else{
							try {
								osarray.get(ii).writeUTF(logo+"��ʾҪ�´���ĳ����ǣ�"+trueexpression.length()+"");
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
//				                System.out.print("    �߳�˯��1�룡\n"); 
//				            } catch (InterruptedException e) { 
//				                e.printStackTrace(); 
//				            } 
//				        } 
//				}
			
	}

}






