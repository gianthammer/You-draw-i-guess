package �㻭�Ҳ�;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MyServer {
    public static ArrayList<Socket> socketList = new ArrayList<Socket>();
    private static final int SERVER_PORT = 8887;
  public static final ArrayList<String> des1 = new ArrayList<String>();
  public static final ArrayList<DataInputStream> isarray = new ArrayList<DataInputStream>();
  public static final ArrayList<DataOutputStream> osarray = new ArrayList<DataOutputStream>();
  
  public static int number = 0;
  public static int sum = 0;
  public static int num = 0;
  public static int playersum = -1;
  
   public int getNum(){
	   return number;
   }
   public void setNum(int id){
	   number = id;
   }
   public ArrayList<String> getdes1(){
	   return des1;
   }
   public ArrayList<Socket> getSocket(){
	   return socketList;
   }
   public ArrayList<DataInputStream> getIs(){
	   return isarray;
   }
   public ArrayList<DataOutputStream>getOs(){
	   return osarray;
   }
   
   public static void main(String[] args) throws IOException{ 
	   //�������˵�һ������ĳ�ӿ�������Ϣ�ķ������
	   ServerSocket ss= new ServerSocket(SERVER_PORT);//������������server_port�˿ڵ�socket
	   while(true){   //ѭ�������ͻ�������
		   //�пͻ������ӵ�ͨѶ����
		   Socket s = ss.accept();
		  
		   socketList.add(s);  //ʵ��������is�����������
		   DataInputStream is = new DataInputStream(s.getInputStream());
		   DataOutputStream os = new DataOutputStream(s.getOutputStream());
		   isarray.add(is);
		   osarray.add(os);
		 		   
		   new Thread(new ServerThread2(s)).start();
	   }
   }
}
