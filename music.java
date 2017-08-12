package 你画我猜;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;


public class music {
    //程序退出时执行的代码
	public void doShutDownWork(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				try{
					play();
					play();
				}
				catch(Exception ex){
				}
			}
		});
		
	}
	//播放音频文件
	public void play(){
		String fileur1 = "file/tada.wav";
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileur1));
			AudioFormat aif = ais.getFormat();
			SourceDataLine sd1 = null;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
			sd1 = (SourceDataLine)AudioSystem.getLine(info);
			sd1.open(aif);
			sd1.start();
			
			int nByte = 0;
			byte[] buffer = new byte[128];
			while(nByte != -1){
				nByte = ais.read(buffer,0,128);
				if(nByte >= 0){
					int oByte = sd1.write(buffer, 0, nByte);
				}
			}
			sd1.stop();
		}
		catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(LineUnavailableException e){
			e.printStackTrace();
		}
	}
}

