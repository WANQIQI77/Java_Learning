package object_oriented_base;
class Count{
    int i=0;
    Count increment(){
        i++;
        return this;//链式调用要加this
    }
    void print(){
        System.out.println("i="+i);
    }
}
public class chained_calls {
    public static void main(String[] args){
        Count x=new Count();
        x.increment().increment().print();

        //依次执行

    }
}
