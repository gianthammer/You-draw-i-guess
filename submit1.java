package �㻭�Ҳ�;
import java.awt.Font;//����
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class submit1 {
	public JFrame frame100 = new JFrame("�㻭�Ҳ�");
	private JPanel imagePanel100;
	private ImageIcon background;
	
  public submit1(){
	  background = new ImageIcon(startgame.class.getResource("./icon/startgame.jpg"));//����ͼƬ��
	  JLabel label100 = new JLabel(background);//����ͼƬ��ʾ�ڱ�ǩ���棬�ѱ�ǩ��Сλ������ΪͼƬ�պ��������塣
	  label100.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
	                        //�����ݴ��ڸ�ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸����
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
