package Object_Oriented_more;
class Teacher{
    private String name;
    private String university;
    Teacher(String name,String univ){
        this.name=name;
        this.university=univ;
    }
    //自我介绍
    void introduction(){
        System.out.println("大家好，我是"+name+"毕业于"+university);
    }
    //教学过程
    void teaching(){

    }
}
class JavaTeacher extends Teacher{
    JavaTeacher(String name,String univ){
        super(name,univ);
    }
    @Override
    void teaching(){
        System.out.println("JAVA");
    }
}

class CppTeacher extends Teacher{
    CppTeacher(String name,String univ){
        super(name,univ);
    }
    @Override
    void teaching(){
        System.out.println("Cpp");
    }
}

class JWC{
    void teachingDisplay(Teacher t){
        t.introduction();
        t.teaching();
    }

}
public class polymorphism {
    public static void main(String[] args){
        JWC j=new JWC();
        JavaTeacher jt=new JavaTeacher("11","清华大学");
        CppTeacher ct=new CppTeacher("22","北京大学");
        j.teachingDisplay(jt);
        j.teachingDisplay(ct);
    }
}
