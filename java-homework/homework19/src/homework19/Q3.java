package homework19;

import java.util.Random;


/*3��ģ��2���߳�ȡǮ��ÿ���߳�ȡ5�Σ�
 * ÿ��ȡǮ�����0-100�����������
 * ȡǮ�������ٽ���ӡ��Ϣ��������*/
class Money implements Runnable{
	@Override
	public void  run() {
		// TODO Auto-generated method stub
		
			for(int i=0;i<5;i++) {
				Random random= new Random();
				int m=random.nextInt(0, 100);
				synchronized (this) {
					
					System.out.println(Thread.currentThread().getName()+"ȡ����"+m+"yuan");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		
		
		
	}
	
	
}

/**/
public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money m1=new Money();
		Thread t1=new Thread(m1);
		Thread t2=new Thread(m1);
		t1.start();
		t2.start();
		
	}

}
