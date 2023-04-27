package object_oriented_base;
class Student2{
    String sid;
    String name;
    int age;
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


    String getInfo(){
        String info;
        info="学号为："+sid+", 姓名为"+name+"，年龄为"+age;
        return info;
    }

}

public class constructor {
}
