package Object_Oriented_more;
class Student2{
    private String sid;
    private String name;
    private int age;
    Student2(){
        this("0000","未命名",18);
    }
    Student2(String sid,String name,int age){
        this.sid=sid;
        this.name=name;
        this.age=age;
    }
    Student2(String name){
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
class UderGraduate2 extends Student2{
    private double gpa;
    UderGraduate2(String sid,String name,int age,double gpa){
        super(sid,name,age);
        this.gpa=gpa;
    }
    double getGpa(){
        return gpa;
    }
    void setGpa(double gpa){
        this.gpa=gpa;
    }
    @Override
    String getInfo(){
        String info=super.getInfo();
        return info+", GPA:"+this.gpa;
    }
}
public class override_memberFunc {
    public static void main(String[] args){
        UderGraduate2 ug=new UderGraduate2("0001","sss",12,4.5);
        System.out.println(ug.getInfo());

    }
}
