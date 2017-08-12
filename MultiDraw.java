package 你画我猜;

/**
 * @author lgz
 * @version 1.2
 * 
 * 1.2
 * 增加了一些注释
 * 
 * 1.1
 * 添加了网络功能。。。
 * 然后。。。。还是采用组播协议。。。
 * 在实际中，还是需要服务器。。。负责分配下使用的端口。。。。
 * 然后同一个房间的人就可以。。。。
 * 但是如果不是做成游戏大厅的话。。。
 * 那就更简单了。。
 * 只需要服务器负责安排下谁画谁猜，判断谁对谁错。。其他的聊天呀，画画呀。都是不需要服务器的。。
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
	// type 0 铅笔 1 橡皮擦
	private int x1, y1, x2, y2, count,color4;
	
	
	
	
	public MulticastSocket socket;

	public MultiDraw() {
		init();
		
	

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

		g2 = image.createGraphics();

		// 初始化背景颜色
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);

		// 设置画笔颜色
		g2.setColor(Color.BLACK);

		// 设置抗锯齿
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// 设置笔触 三个参数分别是粗细、始末笔触形状、连接处方式
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
		// 实际用时，通过房间座位决定序列号
//		sendBuf[0]=(byte) button.getSendBuf();
//		System.out.println(sendBuf[0]);
//		String str = JOptionPane.showInputDialog(MultiDraw.this,
//				"请输入这个画板的序号，要求在0到127之间，且几个画板不重复！");
		sendBuf[0] = (byte) (Math.random() * 128);
//		if (str != null) {
//			try {
//				sendBuf[0] = (byte) Integer.parseInt(str);
//				System.out.println(sendBuf[0]);
//				if (sendBuf[0] < 0) {
//					sendBuf[0] = (byte) (Math.random() * 128);
//					JOptionPane.showMessageDialog(getParent(),
//							"你输入不合法，已经为你自动产生了一个随机数（" + sendBuf[0]
//									+ "），但是随机产生的有可能和其他画板重复！！");
//				} else
//					JOptionPane.showMessageDialog(getParent(), "你输入的是："
//							+ sendBuf[0]);
//			} catch (NumberFormatException e) {
//				sendBuf[0] = (byte) (Math.random() * 128);
//				JOptionPane.showMessageDialog(getParent(),
//						"你输入不合法，已经为你自动产生了一个随机数（" + sendBuf[0]
//								+ "），但是随机产生的有可能和其他画板重复！！");
//			}
//
//		} else {
//			sendBuf[0] = (byte) (Math.random() * 128);
//			JOptionPane.showMessageDialog(getParent(), "你输入不合法，已经为你自动产生了一个随机数（"
//					+ sendBuf[0] + "），但是随机产生的有可能和其他画板重复！！");
//		}

		try {
			// 初始化组播端口。。。实际中，根据房间号决定端口号
		    PORT=9999;
		    System.out.println(PORT);
		    socket = new MulticastSocket(PORT);
			
			//  组播地址，可以是224.0.2.0 一直到238.255.255.255
			group = InetAddress.getByName("224.0.2.103");
			
			// 加入组。。。
			// 可以加入多个组。。。
			socket.joinGroup(group);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 启动接收线程
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
		// 使用count计数，减少频率，也是为了使图像锯齿减少，同时减少网络传输的负担,尽管没什么负担
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

				// 准备一个字节数组接受数据，大小可以改变。。如果需要一次发送更多文字的话
				// 这个大小根据你要传输的内容来决定
				byte[] buf = new byte[11];

				// 新建一个数据包，用来接受
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				try {
					// 接受数据包
					socket.receive(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 判断是否是自己发出去的数据包。。
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

