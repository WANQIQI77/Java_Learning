package homework19;

import java.util.Date;
import java.util.Random;

/*2����дһ���߳�ģ��һ�ſγ̵��Ͽι��̣����߳̿�����45�����ͣ�ÿγ̣�
 * 10��֮���ٴμ����ÿγ̣�Ȼ��45��֮��γ̽�����*/
class Math2 implements Runnable {
	private boolean flag=false;
	private boolean suspend = false;
	
	public synchronized void toSuspend(){
		suspend = true;
	}
	
	public synchronized void toResume(){
		notify();//��ǰ�ȴ����̼߳���ִ��
		suspend = false;
	}
	@Override
	public void run() {
		while(!flag){
			
			synchronized (this) {
				while(suspend){
					try {
						wait();//���߳̽���ȴ�״̬
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
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
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math2 math=new Math2();
		Thread thread = new Thread(math);
		thread.start();
		System.out.println("��ʼ");
		try {
			Thread.sleep(45000);
			
			math.toSuspend();System.out.println("��ͣ");
			
			Thread.sleep(10000);
			
			math.toResume();System.out.println("���¿�ʼ");
			Thread.sleep(45000);
			
			math.stopRunning();System.out.println("����");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
