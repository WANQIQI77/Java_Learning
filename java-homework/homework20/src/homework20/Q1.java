package homework20;
import java.util.ArrayList;
/*2���߳����β���0-9�����������
 * ������5�飬Ȼ�����10�������л�ʤ�����϶���̡߳�
 * ���磬�������������Ϊ��
 * 4��3��5��6��3��5��6��8��7��9��
 * ����4>3, 5<6, 3<5, 6<8, 7<9�����Եڶ����̻߳�ʤ��*/
import java.util.Random;
class Group{
	ArrayList<Integer> arraylist=new ArrayList<>();
	//ArrayList<Thread> threadsList=new ArrayList<>() {{add(null);add(null);}};
	int pk=0;
	int[] winCount= {0,0};//ÿ����Ӯ����
	
	void start() {
		//��ȡ��ǰ�߳�
		//threadsList.set(pk, Thread.currentThread());
		//System.out.println(Thread.currentThread().getName()+"���������ǣ�");
		//����10�������
		Random random=new Random();
		int list[]=new int[10];
		for(int i=0;i<10;i++) {
			list[i]=random.nextInt(10);
			arraylist.add(list[i]);
			System.out.print(list[i]+' ');
		}
		pk+=1;
		//ĳ���߳��Ѿ�������һ����
		if(pk==1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		//�����̶߳�������һ����
		if(pk==2) {
			pk=0;
			//�Ƚ������߳����Ĵ�С
			int num1=0;
			int num2=0;
			int index=arraylist.size()-1;
			for(int i=0;i<10;i++) {
				if(arraylist.get(index)>arraylist.get(index-10)) {
					num1+=1;
				}
				else if (arraylist.get(index)<arraylist.get(index-10)) {
					num2+=1;
				}
			}
			
			if(num1>num2) {
				winCount[0]+=1;
			}
			if(num1<num2) {
				winCount[1]+=1;
			}
			this.notifyAll();
		}
		
	}
}
class Lin implements Runnable{
	boolean flag=false;
	Group group=null;
	public Lin(Group group) {
		// TODO Auto-generated constructor stub
		this.group=group;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			group.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		synchronized (this) {
				//�ж�˭�Ļ�ʤ������
				if(group.winCount[0]>group.winCount[1])
				{
					System.out.println("�߳�һӮ��");
				}
				else if(group.winCount[0]<group.winCount[1])
				{
					System.out.println("�̶߳�Ӯ��");
				}
				else {
					System.out.println("ƽ��");
				}
		}
			
	}
}
	


public class Q1 {
	public static void main(String[] args) {
		Group group=new Group();
		Lin lineLin =new Lin(group);
		Thread t1 = new Thread(lineLin, "Thread 1");
		Thread t2 = new Thread(lineLin, "Thread 2");
		t1.start();
		t2.start();
	}
}
