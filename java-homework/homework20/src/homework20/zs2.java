package homework20;
import java.util.ArrayList;
import java.util.Random;

public class zs2 implements Runnable {
	private int nums;
	boolean flag = true;
	int flag2 = 0;
	zs gn = null;

	public zs2(int nums, zs gn) {
		this.nums = nums;
		this.gn = gn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums; i++) {
			gn.generateUnrepeatNumber(nums * 2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			if (flag) {
				gn.getWin();
				flag = false;
			}
		}
	}

	public static void main(String[] args) {

//		1��  2���߳����β���0-9�����������������5�飬Ȼ�����10�������л�ʤ�����϶���̡߳�
//			���磬�������������Ϊ��4��3��5��6��3��5��6��8��7��9��
//			����4>3, 5<6, 3<5, 6<8, 7<9�����Եڶ����̻߳�ʤ��

		zs gn = new zs();
		Runnable gt = new zs2(5, gn);
		Thread t1 = new Thread(gt, "Thread 1");
		Thread t2 = new Thread(gt, "Thread 2");

		t1.start();
		t2.start();
	}
}