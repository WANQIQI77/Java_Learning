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
		System.out.println("�ҿ��Դ�绰");
	}

	public void text() {
		System.out.println("�ҿ��Է�����");
	}

	public void nav() {
		System.out.println("�ҿ����г̵���");
	}
	public void findgas() {
		System.out.println("�ҿ���Ѱ�Ҽ���վ");
	}
}
class OldPhone implements Calling,Texting,Naving{
	
	public void call() {
		System.out.println("�ҿ��Դ�绰");
	}

	public void text() {
		System.out.println("�ҿ��Է�����");
	}

	public void nav() {
		System.out.println("�Ҳ������г̵���");
	}
}


class SeasonPrint{
	enum Season{
		Spring,Summer,Fall,Winter;
	}
	void getInfo() {
		System.out.println(Season.Spring+"����/����/����");
		System.out.println(Season.Summer+"����/����/����");
		System.out.println(Season.Fall+"����/ʮ��/ʮһ��");
		System.out.println(Season.Winter+"ʮ����/һ��/����");
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

