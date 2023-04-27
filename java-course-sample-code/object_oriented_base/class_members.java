package object_oriented_base;
class Count2{
    static int count=0;//类成员变量用static修饰
    void add(){
        count++;
    }
}
public class class_members {
    public static void main(String[] args){
        Count2 x=new Count2();
        x.add();
        Count2 x2=new Count2();
        x2.add();
        System.out.println(Count2.count);
    }
}
