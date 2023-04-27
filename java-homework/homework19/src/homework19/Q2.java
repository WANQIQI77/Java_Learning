package homework19;

import java.util.Date;
import java.util.Random;

/*2、编写一个线程模拟一门课程的上课过程，主线程控制在45秒后暂停该课程，
 * 10秒之后再次继续该课程，然后45秒之后课程结束。*/
class Math2 implements Runnable {
	private boolean flag=false;
	private boolean suspend = false;
	
	public synchronized void toSuspend(){
		suspend = true;
	}
	
	public synchronized void toResume(){
		notify();//当前等待的线程继续执行
		suspend = false;
	}
	@Override
	public void run() {
		while(!flag){
			
			synchronized (this) {
				while(suspend){
					try {
						wait();//让线程进入等待状态
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
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
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math2 math=new Math2();
		Thread thread = new Thread(math);
		thread.start();
		System.out.println("开始");
		try {
			Thread.sleep(45000);
			
			math.toSuspend();System.out.println("暂停");
			
			Thread.sleep(10000);
			
			math.toResume();System.out.println("重新开始");
			Thread.sleep(45000);
			
			math.stopRunning();System.out.println("结束");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
