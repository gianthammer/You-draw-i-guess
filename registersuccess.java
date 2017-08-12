package Äã»­ÎÒ²Â;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class registersuccess {
  public static void main(String[] args) {
	JFrame success =new JFrame();
	success.setBounds(280, 40, 660,520);
	success.getContentPane().setLayout(new BorderLayout(0, 0));
	
	JLabel successlabel = new JLabel("");
	successlabel.setIcon(new ImageIcon(registersuccess.class.getResource("./icon/\u6CE8\u518C\u6210\u529F.jpg")));
	success.getContentPane().add(successlabel, BorderLayout.CENTER);
	success.setVisible(true);
  }
}

