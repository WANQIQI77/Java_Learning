package Object_Oriented_more;
class SuperClass{
    int number=10;
}
class SubClass extends SuperClass{
    int number=20;
    void print(){
        System.out.println(number);
        System.out.println(super.number);
    }
}
public class hide_memberVariables {
    public static void main(String[] args){
        SubClass sc=new SubClass();
        sc.print();
    }
}
