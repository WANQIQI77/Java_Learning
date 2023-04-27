package Object_Oriented_more;

import java.lang.reflect.Array;
import java.util.Arrays;

//利用comparable和arrays.sort排序
class Number implements Comparable{
    int n;
    Number(int n){
        this.n=n;
    }

    @Override
    public int compareTo(Object o) {
        //转换类型
        Number otherOne=(Number) o;
        return Integer.compare(n,otherOne.n);
    }

    void print(){
        System.out.println(n);
    }
}
public class interface_Comparable {
    public static void main(String[] args)
    {
        Number num[]=new Number[3];
        num[0]=new Number(0);
        num[1]=new Number(3);
        num[2]=new Number(2);
        Arrays.sort(num);
        for(Number x:num){
            x.print();
        }
    }



}
