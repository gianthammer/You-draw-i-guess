package �㻭�Ҳ�;

/**
 * @author lgz
 * @version 1.2
 * 
 * 1.2
 * ������һЩע��
 * 
 * 1.1
 * ��������繦�ܡ�����
 * Ȼ�󡣡��������ǲ����鲥Э�顣����
 * ��ʵ���У�������Ҫ���������������������ʹ�õĶ˿ڡ�������
 * Ȼ��ͬһ��������˾Ϳ��ԡ�������
 * �����������������Ϸ�����Ļ�������
 * �Ǿ͸����ˡ���
 * ֻ��Ҫ��������������˭��˭�£��ж�˭��˭��������������ѽ������ѽ�����ǲ���Ҫ�������ġ���
 * 
 */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import javax.print.attribute.standard.Severity;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import javax.swing.JButton;

public class MultiDraw extends JPanel implements MouseInputListener {
	private static int PORT;//= 1234;
	private InetAddress group;
	private final static int WIDTH = 785;
	private final static int HEIGHT = 600;
	private BufferedImage image;
	public  static Graphics2D g2;
	public static  byte[] sendBuf;
    public static int type;
    public static int colorcolor;
	// type 0 Ǧ�� 1 ��Ƥ��
	private int x1, y1, x2, y2, count,color4;
	
	
	
	
	public MulticastSocket socket;

	public MultiDraw() {
		init();
		
	

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

		g2 = image.createGraphics();

		// ��ʼ��������ɫ
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);

		// ���û�����ɫ
		g2.setColor(Color.BLACK);

		// ���ÿ����
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// ���ñʴ� ���������ֱ��Ǵ�ϸ��ʼĩ�ʴ���״�����Ӵ���ʽ
		g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));

//     	addMouseListener(this);
//		addMouseMotionListener(this);

	}
	public  Graphics2D getG2(){
		return g2;
	}

	public void clean(){
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);

	}
	
	
	
	
	private void init() {
		// TODO Auto-generated method stub
		sendBuf = new byte[11];
		// ʵ����ʱ��ͨ��������λ�������к�
//		sendBuf[0]=(byte) button.getSendBuf();
//		System.out.println(sendBuf[0]);
//		String str = JOptionPane.showInputDialog(MultiDraw.this,
//				"����������������ţ�Ҫ����0��127֮�䣬�Ҽ������岻�ظ���");
		sendBuf[0] = (byte) (Math.random() * 128);
//		if (str != null) {
//			try {
//				sendBuf[0] = (byte) Integer.parseInt(str);
//				System.out.println(sendBuf[0]);
//				if (sendBuf[0] < 0) {
//					sendBuf[0] = (byte) (Math.random() * 128);
//					JOptionPane.showMessageDialog(getParent(),
//							"�����벻�Ϸ����Ѿ�Ϊ���Զ�������һ���������" + sendBuf[0]
//									+ "������������������п��ܺ����������ظ�����");
//				} else
//					JOptionPane.showMessageDialog(getParent(), "��������ǣ�"
//							+ sendBuf[0]);
//			} catch (NumberFormatException e) {
//				sendBuf[0] = (byte) (Math.random() * 128);
//				JOptionPane.showMessageDialog(getParent(),
//						"�����벻�Ϸ����Ѿ�Ϊ���Զ�������һ���������" + sendBuf[0]
//								+ "������������������п��ܺ����������ظ�����");
//			}
//
//		} else {
//			sendBuf[0] = (byte) (Math.random() * 128);
//			JOptionPane.showMessageDialog(getParent(), "�����벻�Ϸ����Ѿ�Ϊ���Զ�������һ���������"
//					+ sendBuf[0] + "������������������п��ܺ����������ظ�����");
//		}

		try {
			// ��ʼ���鲥�˿ڡ�����ʵ���У����ݷ���ž����˿ں�
		    PORT=9999;
		    System.out.println(PORT);
		    socket = new MulticastSocket(PORT);
			
			//  �鲥��ַ��������224.0.2.0 һֱ��238.255.255.255
			group = InetAddress.getByName("224.0.2.103");
			
			// �����顣����
			// ���Լ������顣����
			socket.joinGroup(group);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ���������߳�
		(new Thread(new reciveOne())).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		x1 = x2 = e.getX();
		y1 = y2 = e.getY();
		sendPoint();

		g2.drawLine(x1, y1, x2, y2);
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// ʹ��count����������Ƶ�ʣ�Ҳ��Ϊ��ʹͼ���ݼ��٣�ͬʱ�������紫��ĸ���,����ûʲô����
		if (count % 5 == 0) {
			x1 = x2;
			y1 = y2;
			x2 = e.getX();
			y2 = e.getY();
			g2.drawLine(x1, y1, x2, y2);
			sendPoint();
			repaint();
		}
		count++;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void sendPoint() {
		// TODO Auto-generated method stub
		sendBuf[2] = (byte) (x1 % 128);
		sendBuf[1] = (byte) (x1 / 128);
		sendBuf[4] = (byte) (x2 % 128);
		sendBuf[3] = (byte) (x2 / 128);
		sendBuf[6] = (byte) (y1 % 128);
		sendBuf[5] = (byte) (y1 / 128);
		sendBuf[8] = (byte) (y2 % 128);
		sendBuf[7] = (byte) (y2 / 128);
		sendBuf[9] = (byte)type;
		sendBuf[10]=(byte)colorcolor;
		System.out.println("@"+type);
		

		DatagramPacket dp = new DatagramPacket(sendBuf, sendBuf.length, group,PORT);
		try {
			socket.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class reciveOne implements Runnable {

		@Override
		public void run() {
			while (true) {

				// ׼��һ���ֽ�����������ݣ���С���Ըı䡣�������Ҫһ�η��͸������ֵĻ�
				// �����С������Ҫ���������������
				byte[] buf = new byte[11];

				// �½�һ�����ݰ�����������
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				try {
					// �������ݰ�
					socket.receive(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// �ж��Ƿ����Լ�����ȥ�����ݰ�����
				if (buf[0] != sendBuf[0]) {
					x1 = buf[2] + buf[1] * 128;
					x2 = buf[4] + buf[3] * 128;
					y1 = buf[6] + buf[5] * 128;
					y2 = buf[8] + buf[7] * 128;
					type = buf[9];
					color4=buf[10];
					
                    if(type==0){
                    	g2.setColor(Color.BLACK);
                    	g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
								BasicStroke.JOIN_ROUND));
                    	System.out.println("***"+type);
                    	
                    	System.out.println(type);
                    }
                    else if(type==1){
                    	g2.setColor(Color.WHITE);
                    	g2.setStroke(new BasicStroke(12, BasicStroke.CAP_ROUND,
								BasicStroke.JOIN_ROUND));
                    	System.out.println("**********"+type);
                    }
//                    if(color4!=0&&type!=1){
//					Color color1=new Color(color4);
//					g2.setColor(color1);
//					g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
//							BasicStroke.JOIN_ROUND));
//                    }
					g2.drawLine(x1, y1, x2, y2);
					repaint();

				}

			}
		}

	}

}

