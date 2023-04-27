package network_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
利用URL类访问网上资源，读出网址www.sina.com.cn的主页内容
 */
public class App9_2 {
    public static void main(String[] args){
        String url_name="http://www.sina.com.cn";
        new App9_2().display(url_name);
    }
    public void display(String url_name){
        InputStreamReader in=null;
        BufferedReader br=null;
        try {
            //根据URL建立数据输入流
            URL url=new URL(url_name);
            in = new InputStreamReader(url.openStream());
            br = new BufferedReader(in);

            //从流中读取一行显示
            String aline;
            while ((aline=br.readLine())!=null)
                System.out.println(aline);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
