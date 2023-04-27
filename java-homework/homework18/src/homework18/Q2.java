package homework18;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*2、采用Callable方式创建线程，并返回100所有能够整除7的数字和，在主方法中显示结果。*/
class Sum implements Callable<Integer>{
	public Integer call()throws Exception{
		int sum = 0;
		for (int i=1;i<=100;i++) {
			if (i%7==0) {
				sum+=i;
			}
		}
		return sum;
	}
}
public class Q2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Sum mySum=new Sum();
		FutureTask<Integer> fTask=new FutureTask<>(mySum);
		Thread thread=new Thread(fTask);
		thread.start();
		System.out.println(fTask.get());
	}

}
