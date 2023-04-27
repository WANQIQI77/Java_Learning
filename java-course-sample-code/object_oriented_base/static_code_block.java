package object_oriented_base;
//静态代码块在类被加载的时候执行，并且只会执行一次
class StaticBlock{
    static double x1=0.025;
    static double x2;
    static {
        x2=x1*0.2;
    }
}
public class static_code_block {
    public static void main(String[] args){
        StaticBlock x1=new StaticBlock();
        StaticBlock x2=new StaticBlock();
        System.out.println(x1.x1);
        System.out.println(x1.x2);
        //虽然创建了两个对象，但是静态代码块只执行了一次
    }
}
