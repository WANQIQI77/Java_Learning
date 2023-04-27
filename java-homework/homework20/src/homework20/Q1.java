package homework20;
import java.util.ArrayList;
/*2个线程依次产生0-9的随机整数，
 * 共产生5组，然后输出10组数字中获胜次数较多的线程。
 * 例如，随机产生的数字为：
 * 4，3，5，6，3，5，6，8，7，9，
 * 其中4>3, 5<6, 3<5, 6<8, 7<9，所以第二个线程获胜。*/
import java.util.Random;
class Group{
	ArrayList<Integer> arraylist=new ArrayList<>();
	//ArrayList<Thread> threadsList=new ArrayList<>() {{add(null);add(null);}};
	int pk=0;
	int[] winCount= {0,0};//每轮输赢计算
	
	void start() {
		//获取当前线程
		//threadsList.set(pk, Thread.currentThread());
		//System.out.println(Thread.currentThread().getName()+"产生的数是：");
		//产生10个随机数
		Random random=new Random();
		int list[]=new int[10];
		for(int i=0;i<10;i++) {
			list[i]=random.nextInt(10);
			arraylist.add(list[i]);
			System.out.print(list[i]+' ');
		}
		pk+=1;
		//某个线程已经产生了一组数
		if(pk==1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		//两个线程都产生了一组数
		if(pk==2) {
			pk=0;
			//比较两个线程数的大小
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
				//判断谁的获胜次数多
				if(group.winCount[0]>group.winCount[1])
				{
					System.out.println("线程一赢了");
				}
				else if(group.winCount[0]<group.winCount[1])
				{
					System.out.println("线程二赢了");
				}
				else {
					System.out.println("平手");
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
