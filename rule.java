package Äã»­ÎÒ²Â;



import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class rule {
	public static void main(String[] args) {
		JFrame rule=new JFrame();
		rule.setBounds(280, 40, 600,480);
		rule.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel rulelabel = new JLabel("");
		rulelabel.setIcon(new ImageIcon(rule.class.getResource("./icon/\u4F60\u753B\u6211\u731C\u6E38\u620F\u4ECB\u7ECD_\u672C_+"
    	   		+ "\u526F\u672C.jpg")));
		rule.getContentPane().add(rulelabel, BorderLayout.CENTER);
		rule.setVisible(true);
			
	}
   
}


/*
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class rule {
	public static void main(String[] args) {
		JFrame rule=new JFrame();
		rule.setBounds(280, 40, 600,480);
		rule.getContentPane().setLayout(new BorderLayout(0, 0));
		
		ImageIcon image = new ImageIcon("C://Users//wgm//Desktop//Í¼Æ¬//eclipse_update_120.jpg");
		JLabel rulelabel = new JLabel(image);
		
		rule.getContentPane().add(rulelabel, BorderLayout.CENTER);
		rule.setVisible(true);
			
	}
   
}



/*
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class rule {
       public static void main(String[] args){
    	   JFrame ruler = new JFrame();
    	   rule.setBounds(280,40,600,480);
    	   rule.getContentPane().setLayout(new BorderLayout(0,0));
    	   
    	   JLabel rulelabel = new JLabel("");
    	   rulelabel.setIcon(new ImageIcon(rule.class.getResource("/icon/\u4F60\u753B\u6211\u731C\u6E38\u620F\u4ECB\u7ECD_\u672C_+"
    	   		+ "\u526F\u672C.jpg")));
    	   rule.getContentPane().add(rulelabel,BorderLayout.CENTER);
    	   rule.setVisible(true);
       }
}
*/