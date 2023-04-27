package network_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
实现字符界面下简单的client/server程序，服务器端与客户端会话一次
 */
//服务器端
public class App9_3 {
    public static void main(String[] args){
        try {
            //在服务器端口1234上创建监听服务
            ServerSocket ss=new ServerSocket(1234);
            while(true){
                //监听并接受客户端的连接请求
                Socket s=ss.accept();
                //通过I/O流来传递数据
                OutputStream os=s.getOutputStream();
                DataOutputStream dos =new DataOutputStream(os);
                dos.writeUTF("hello,"+s.getInetAddress()+"port$"+s.getPort()+" bye-bye!");
                dos.close();
                ss.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
