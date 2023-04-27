package Q2;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
class Student{
	String name;
	int age;
	Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString() {
		return this.name+"  "+this.age;
	}
}
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Student> map=new HashMap<String,Student>();
		//����ѧ��
		Student s1=new Student("wqq",18);
		Student s2=new Student("zzh",18);
		Student s3=new Student("jdh",18);
		//���
		map.put("1",s1);
		map.put("2",s2);
		map.put("3",s3);
	
		//����
		Set<String> keySet=map.keySet();
		for(String k:keySet) {
			Student value=map.get(k);
			System.out.println(k+":"+value);
		}
		System.out.println("-----------------------------");
		//ɾ��
		map.remove("1");
		keySet=map.keySet();
		for(String k:keySet) {
			Student value=map.get(k);
			System.out.println(k+":"+value);
		}
		System.out.println("-----------------------------");
		//�޸�
		Student s4=new Student("zzz",18);
		map.put("3", s4);
		keySet=map.keySet();
		for(String k:keySet) {
			Student value=map.get(k);
			System.out.println(k+":"+value);
		}
		System.out.println("-----------------------------");
		//����
		System.out.println(map.get("2"));
			
		
		
	}

}
