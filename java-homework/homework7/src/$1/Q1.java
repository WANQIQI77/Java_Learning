package $1;

abstract class animal{
	String name;
	animal(String name){
		this.name=name;
	}
	abstract void eat();
	abstract void sleep();
	abstract void think();
	abstract void speak();
	abstract void fly();
}
class cat extends animal{
	cat(String name){
		super(name);
	}
	void eat() {
		System.out.println("我是一只猫，我爱吃老鼠和鱼");
	}
	void sleep() {
		System.out.println("我是一只猫，我晚上不睡觉");
	}
	void think(){
		System.out.println("我是一只猫，我每天都在思考怎么抓老鼠");
	}
	void fly(){
		System.out.println("我是一只猫，我不会飞");
	}
	void speak(){
		System.out.println("我是一只猫，我会喵喵叫");
	}
	
}
class human extends animal{
	human(String name){
		super(name);
	}
	void eat() {
		System.out.println("我是一个人，我爱吃火锅");
	}
	void sleep() {
		System.out.println("我是一个人，我晚上睡觉");
	}
	void think(){
		System.out.println("我是一个人，我每天都在思考");
	}
	void fly(){
		System.out.println("我是一个人，我不会飞");
	}
	void speak(){
		System.out.println("我是一个人，我会好几种语言");
	}
	
}
class bird extends animal{
	bird(String name){
		super(name);
	}
	void eat() {
		System.out.println("我是一只鸟，我爱吃虫子");
	}
	void sleep() {
		System.out.println("我是一只鸟，我晚上要睡觉");
	}
	void think(){
		System.out.println("我是一只鸟，我不能思考");
	}
	void fly(){
		System.out.println("我是一直念，我会飞");
	}
	void speak(){
		System.out.println("我是一只鸟，我会吱吱叫");
	}
	
}
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat lili=new cat("Lili");
		human cc=new human("cici");
		bird kk=new bird("kk");
		lili.fly();
		cc.sleep();
		kk.think();
	}

}
