package homework18;

import java.security.Principal;

/*1���ֱ����Runnable��Thread��ʽ�����߳����100�����ܹ�����7�����ֺͣ�����ʾ��*/
class myThread extends Thread{
	public void run() {
		int sum = 0;
		for (int i=1;i<=100;i++) {
			if (i%7==0) {
				sum+=i;
			}
		}
		System.out.println("Thread: "+sum);
	}
}
class myRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i=1;i<=100;i++) {
			if (i%7==0) {
				sum+=i;
			}
		}
		System.out.println("Runnable: "+sum);
	}
	
}
public class Q1 {
	public static void main(String[] args) {
		Thread S1=new myThread();
		Thread S2= new Thread(new myRunnable());
		S1.start();
		S2.start();
		
	}
}
