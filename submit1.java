package 你画我猜;
import java.awt.Font;//字体
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class submit1 {
	public JFrame frame100 = new JFrame("你画我猜");
	private JPanel imagePanel100;
	private ImageIcon background;
	
  public submit1(){
	  background = new ImageIcon(startgame.class.getResource("./icon/startgame.jpg"));//背景图片。
	  JLabel label100 = new JLabel(background);//背景图片显示在标签里面，把标签大小位置设置为图片刚好填充满面板。
	  label100.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
	                        //把内容窗口格转化为JPanel,否则不能用方法setOpaque()来使内容窗格透明。
	  imagePanel100 = (JPanel)frame100.getContentPane();
	  frame100.getContentPane().setLayout(null);
	  frame100.setResizable(true);
  }
  
  public void setVisible(boolean b){
	  if (b == true){
		  frame100.setVisible(true);
	  }
	  if (b == false){
		  frame100.setVisible(false);
	  }
  }
			
}
