package basic;

import java.util.Scanner;

/*next与nextLine区别：
next，nextInt,nextDouble会一流enter字符，用nextLine吃掉*/

public class next_and_nextLine {
    public static void main(String[] args){
        String s1,s2;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入第一个字符串");
        s1=sc.next();
        System.out.println("输入第二个字符串");
        s2=sc.nextLine();
        String s3=sc.next();
        System.out.println("--------------");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
