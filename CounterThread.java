
package 你画我猜;

/*

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JLabel;

public class CounterThread implements Runnable{






 public static boolean flag;
   public static boolean getFlag()
  {
	   return flag;
   }
	public void setFlag(){
		flag=false;
	}
	expriment myCounter=new expriment();
	
	public void run() {
		flag=true;
		while(flag){
		  JLabel myLabel=myCounter.getMainLabel();
	      DataInputStream is=myCounter.getIS();
	      DataOutputStream os=myCounter.getOS();
	      
		 for (int i = 60; i >0; i--) { 
	            try { 
	                Thread.sleep(1000);
	                 String ii=" "+i;
	                myLabel.setText(ii);
	            } catch (InterruptedException e) { 
	                e.printStackTrace(); 
	            } 
	        } 
		 //size 登录人数       a  房间人数
// 、、ggggggggggggggggggggggggggggggggggggggggggggggggggggggg
		 try {
			 //登录人数不为0
			 if(myCounter.size!=0){
		    System.out.println("myCounter.size是"+myCounter.size);
		    //count初始值为0
			os.writeUTF("5结束了"+((myCounter.count)%(myCounter.size)));
			System.out.println("5结束了"+((myCounter.count)%(myCounter.size)));
			myCounter.count++;
			 }
			 else{
				 os.writeUTF("5结束了"+1);
				 myCounter.count++;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}



/*

package 你画我猜;*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JLabel;


public class CounterThread implements Runnable{
    public static boolean flag;
      public static boolean getflag(){
    	  return flag;
      }
      public void setFlag(){
    	  flag = false;
      }
      expriment myCounter = new expriment();
      
	@Override
	public void run() {
		// TODO Auto-generated method stub
		flag = true;
		while (flag){
			JLabel myLabel = myCounter.getMainLabel();
			DataInputStream is = myCounter.getIS();
			DataOutputStream os = myCounter.getOS();
			
			for (int i = 60;i > 0;i --){
				try {
					Thread.sleep(1000);
					String ii = " " + i;
					myLabel.setText(ii);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		     	//size登录人数， a 房间人数
			try {
				//登陆人数不为零
				if(myCounter.size!=0){
					System.out.println("myCounter.size是" + myCounter.size);
					//count的初始值为0
					os.writeUTF("5结束了" + ((myCounter.count)%(myCounter.size)));
					System.out.println("5结束了" +((myCounter.count)%(myCounter.size)));
					myCounter.count++;
				}
				else{
					os.writeUTF("5结束了" +1);
					myCounter.count++;
				}
			}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		
	}
	
}
	
