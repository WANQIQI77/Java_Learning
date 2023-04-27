package homework19;

import java.nio.channels.Pipe.SourceChannel;
import java.util.Date;

/*1、编写一个线程模拟一门课程的上课过程，主线程控制在45秒后结束该线程。
*/
class Math implements Runnable {
	private boolean flag=false;
	@Override
	public void run() {
		while (!flag) {
			System.out.println("当前正在上数学课，时间为--"+new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	void stopRunning() {
		flag=true;
	}
}
public class Q1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math math=new Math();
		Thread thread = new Thread(math);
		thread.start();
		System.out.println("start");
		try {
			Thread.sleep(45000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		math.stopRunning();
		System.out.print("stop");
		
	}
}
