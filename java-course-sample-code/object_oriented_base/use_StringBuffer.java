package object_oriented_base;

public class use_StringBuffer {
    public static void main(String[] args){
        StringBuffer s=new StringBuffer("abcd");
        s.append("123");
        System.out.println(s);
        s.insert(4,"0");
        System.out.println(s);
        s.deleteCharAt(1);
        System.out.println(s);
        s.setCharAt(0,'e');
    }
}
