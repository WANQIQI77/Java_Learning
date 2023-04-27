package object_oriented_base;
class Student{
    String sid="0000";
    String name;
    int age = 18;
    String getInfo(){
        String info;
        info="学号为："+sid+", 姓名为"+name+"，年龄为"+age;
        return info;
    }

}

public class use_object {
    public static void main(String[] args){
        Student stu1=new Student();
        stu1.sid="1101";
        stu1.name="小明";
        stu1.age=20;
        System.out.println("stu1"+stu1.getInfo());

        Student stu2=new Student();
        stu2=stu1;//stu2指向了stu1，原来的stu2内存无法使用，没有变量能访问
        System.out.println("stu2"+stu2.getInfo());
    }
}
