package homework18;
/*3、有一个货架（大小200），
 * 有两个生产商品的线程分别生产100个物品（可以是一个随机的int型变量）并存在货架中，
 * 编写程序模拟这个过程。*/
class Products implements Runnable{
	private int tickets = 200;
	private int i =0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (tickets>0) {
			System.out.println(Thread.currentThread().getName()+"produced Product"+i++);
			tickets--;
			
		}
	}
	
	
}
public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Products pdProducts=new Products();
		new Thread(pdProducts).start();
		new Thread(pdProducts).start();
	}

}
