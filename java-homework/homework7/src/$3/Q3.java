package $3;
abstract class film{
	String filmwork;
	String tvwork;
	String songwork;
	film(String filmwork,String tvwork,String songwork){
		this.filmwork=filmwork;
		this.songwork=songwork;
		this.tvwork=tvwork;
	
	}
	
}

class superstar extends film{
	String name;
	superstar(String name,String filmwork, String tvwork, String songwork) {
		super(filmwork, tvwork, songwork);
		this.name=name;
	}
	void Getinfo(){
		System.out.println(name+"是一个影视歌三栖艺人。");
		System.out.println("代表电影作品："+this.filmwork);
		System.out.println("代表电视剧作品："+this.tvwork);
		System.out.println("代表歌曲作品："+this.songwork);
	}
}

public class Q3 {
	public static void main(String[] args) {
	superstar abc=new superstar("大鹏","捉妖记2","屌丝男士","煎饼侠");
	abc.Getinfo();
	}
}
