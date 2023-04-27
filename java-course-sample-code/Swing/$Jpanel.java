package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

class Event{
    Event(){
        JFrame frame=new JFrame("窗口名");
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        //文本区
        JTextArea textA=new JTextArea();//文本区域组件
        textA.setLineWrap(true);//自动换行
        textA.setFont(new Font(null,Font.PLAIN,18));//设置字体
        textA.setText("kljhkshdajhd,sjkfggfhdgfsjfhsgdjsdgf");
        textA.append("年后附件客户的卡号觉得");

        JButton button=new JButton("得到text的内容");

        JScrollPane sp=new JScrollPane(textA,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setBounds(5,5,200,200);


        frame.add(BorderLayout.CENTER,sp);
        frame.add(BorderLayout.SOUTH,button);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string=new String();
                string=textA.getText();
                System.out.println(string);
            }
        });
    }
}
class Filetest{
    Filetest(){
        File file=new File("data.txt");
        if(!file.exists()){
            try {
                System.out.println("文件不存在，正在创建文件");
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            FileReader fr=new FileReader(file);
            int n;
            while ((n=fr.read())!=-1){
                System.out.print((char) n);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileWriter fw=new FileWriter(file,true);
            Scanner sc=new Scanner(System.in);
            String ch=System.getProperty("line.separator");
            String s;
            System.out.println("请输入多行字符，以#号结束：");
            while(true){
                s=sc.nextLine();
                if(s.equals("#")){
                    break;
                }else {
                    fw.write(s);
                    fw.write(ch);
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class ThreadB implements Runnable{
    private boolean flag=false;
    @Override
    public void run() {
        while (!flag){
            synchronized (this){

            }

        }
    }
    void stopRunnning(){
        flag=true;
    }
}
public class $Jpanel {
    public static void main(String[] args){
        //new Event();

    }
}
