package network_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*利用InetAddresss类获取计算机的主机名和IP地址*/
public class App9_1 {
    public static void main(String[] args){
        try {
            //获取本地主机的IP地址
            InetAddress add1=InetAddress.getLocalHost();
            System.out.println("本地主机:"+add1);

            //通过DNS域名解析，获得相应服务器的主机地址
            InetAddress add2=InetAddress.getByName("www.163.com");
            System.out.println("网易主机服务器地址:"+add2);

            //根据字符串形式的IP地址获得相应的主机地址
            InetAddress add3=InetAddress.getByName("192.168.0.22");
            System.out.println("ip:"+add3);

            //返回主机名称
            System.out.println(add1.getHostName());
            System.out.println(add2.getHostName());
            System.out.println(add3.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
