package $1;

interface Calling{
	void call() ;
}
interface Texting{
	void text();
	static void findGas() {
		
	}
}
interface Naving {
	void nav();
}
class SmartPhone implements Calling,Texting,Naving{
	
	public void call() {
		System.out.println("我可以打电话");
	}

	public void text() {
		System.out.println("我可以发短信");
	}

	public void nav() {
		System.out.println("我可以行程导航");
	}
	public void findgas() {
		System.out.println("我可以寻找加油站");
	}
}
class OldPhone implements Calling,Texting,Naving{
	
	public void call() {
		System.out.println("我可以打电话");
	}

	public void text() {
		System.out.println("我可以发短信");
	}

	public void nav() {
		System.out.println("我不可以行程导航");
	}
}


class SeasonPrint{
	enum Season{
		Spring,Summer,Fall,Winter;
	}
	void getInfo() {
		System.out.println(Season.Spring+"三月/四月/五月");
		System.out.println(Season.Summer+"六月/七月/八月");
		System.out.println(Season.Fall+"九月/十月/十一月");
		System.out.println(Season.Winter+"十二月/一月/二月");
	}
}
public class Q1 {
	public static void main(String[] args)
	{
		SmartPhone a=new SmartPhone();
		OldPhone b=new OldPhone();
		a.call();a.text();a.nav();a.findgas();
		System.out.println("------------");
		b.call();b.text();b.nav();
		System.out.println("------------");
		SeasonPrint pp=new SeasonPrint();
		pp.getInfo();
	}
}

