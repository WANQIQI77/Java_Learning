package homework18;
/*3����һ�����ܣ���С200����
 * ������������Ʒ���̷ֱ߳�����100����Ʒ��������һ�������int�ͱ����������ڻ����У�
 * ��д����ģ��������̡�*/
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
