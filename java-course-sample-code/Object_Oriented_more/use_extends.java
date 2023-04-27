package Object_Oriented_more;
class Student{
    private String sid;
    private String name;
    private int age;
    Student(){
        this("0000","未命名",18);
    }
    Student(String sid,String name,int age){
        this.sid=sid;
        this.name=name;
        this.age=age;
    }
    Student(String name){
        this("0000",name,18);
    }
    void setAge(int age){
        this.age=age;
    }
    int getAge(){
        return this.age;
    }
    String getInfo(){
        String info;
        info="学号为："+sid+", 姓名为:"+name+", 年龄为:"+age;
        return info;
    }

}
class UderGraduate extends Student{
    private double gpa;
    UderGraduate(String sid,String name,int age,double gpa){
        super(sid,name,age);
        this.gpa=gpa;
    }
    double getGpa(){
        return gpa;
    }
    void setGpa(double gpa){
        this.gpa=gpa;
    }
}
public class use_extends {
    public static void main(String[] args){
        UderGraduate ug=new UderGraduate("0001","sss",12,4.5);
        System.out.println(ug.getInfo());

    }
}
