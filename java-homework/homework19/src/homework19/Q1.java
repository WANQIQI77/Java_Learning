package homework19;

import java.nio.channels.Pipe.SourceChannel;
import java.util.Date;

/*1����дһ���߳�ģ��һ�ſγ̵��Ͽι��̣����߳̿�����45���������̡߳�
*/
class Math implements Runnable {
	private boolean flag=false;
	@Override
	public void run() {
		while (!flag) {
			System.out.println("��ǰ��������ѧ�Σ�ʱ��Ϊ--"+new Date().toString());
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
