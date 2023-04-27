package $2;

interface animal{
	void eat();
	void sleep();
	void think();
	void speak();
	void fly();
}
class cat implements animal{
	public void eat() {
		System.out.println("我是一只猫，我爱吃老鼠和鱼");
	}
	public void sleep() {
		System.out.println("我是一只猫，我晚上不睡觉");
	}
	public void think(){
		System.out.println("我是一只猫，我每天都在思考怎么抓老鼠");
	}
	public void fly(){
		System.out.println("我是一只猫，我不会飞");
	}
	public void speak(){
		System.out.println("我是一只猫，我会喵喵叫");
	}
}
class human implements animal{
	public void eat() {
		System.out.println("我是一个人，我爱吃火锅");
	}
	public void sleep() {
		System.out.println("我是一个人，我晚上睡觉");
	}
	public void think(){
		System.out.println("我是一个人，我每天都在思考");
	}
	public void fly(){
		System.out.println("我是一个人，我不会飞");
	}
	public void speak(){
		System.out.println("我是一个人，我会好几种语言");
	}
	
}
class bird implements animal{
	public void eat() {
		System.out.println("我是一只鸟，我爱吃虫子");
	}
	public void sleep() {
		System.out.println("我是一只鸟，我晚上要睡觉");
	}
	public void think(){
		System.out.println("我是一只鸟，我不能思考");
	}
	public void fly(){
		System.out.println("我是一直鸟，我会飞");
	}
	public void speak(){
		System.out.println("我是一只鸟，我会吱吱叫");
	}
	
}
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat lili=new cat();
		human cc=new human();
		bird kk=new bird();
		lili.fly();
		cc.sleep();
		kk.think();

	}

}