import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

//软件工程2101 万琦琦 120211080314 B
class Mypanel{
    JFrame myframe;
    JTextArea textMember,textOne,textTwo;
    JLabel labelMember,labelOne,labelTwo;
    JButton buttonA,buttonBegin,buttonSave;
    JPanel panelButton,panelText,panelOne,panelTwo,panel12,panelMem;
    ArrayList list;
    Mypanel(ArrayList list){
        this.list=list;
    }
    void createFrame(){
        myframe=new JFrame("羽毛球组队");
        myframe.setSize(500,800);
        myframe.setResizable(false);
        myframe.setLocationRelativeTo(null);
        myframe.setLayout(new BorderLayout());
        //添加按钮
        panelButton=new JPanel();
        buttonA=new JButton("显示队员");
        buttonBegin=new JButton("开始组队");
        buttonSave=new JButton("保存名单");
        panelButton.add(buttonA);
        panelButton.add(buttonBegin);
        panelButton.add(buttonSave);
        myframe.add(BorderLayout.SOUTH,panelButton);
        //添加文本区
        textMember=new JTextArea();
        textMember.setLineWrap(true);
        // spMember=new JScrollPane(textMember,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        // spMember.setBounds(0,0,400,300);
        textOne=new JTextArea();
        textOne.setLineWrap(true);
        // sp1=new JScrollPane(textOne,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //sp1.setBounds(410,0,180,300);
        textTwo=new JTextArea();
        textTwo.setLineWrap(true);

        // sp2=new JScrollPane(textTwo,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //sp2.setBounds(410,190,180,300);
        //队员
        labelMember=new JLabel("队员");
        panelMem=new JPanel(new BorderLayout());
        panelMem.add(BorderLayout.NORTH,labelMember);
        panelMem.add(BorderLayout.CENTER,textMember);
        //一队
        labelOne=new JLabel("一队");
        panelOne=new JPanel(new BorderLayout());
        panelOne.add(BorderLayout.NORTH,labelOne);
        panelOne.add(BorderLayout.CENTER,textOne);
        //二队
        labelTwo=new JLabel("二队");
        panelTwo=new JPanel(new BorderLayout());
        panelTwo.add(BorderLayout.NORTH,labelTwo);
        panelTwo.add(BorderLayout.CENTER,textTwo);

        panel12=new JPanel(new GridLayout(1,3));
        panel12.add(panelOne);
        panel12.add(new JPanel());
        panel12.add(panelTwo);

        panelText=new JPanel();
        panelText=new JPanel(new GridLayout(2,1));
        panelText.add(panelMem);
        panelText.add(panel12);

        myframe.add(BorderLayout.CENTER,panelText);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMember.setText("      1. 张晓刚, 男\n" +
                        "      2. 段立明, 男\n" +
                        "      3. 王强, 男\n" +
                        "      4. 赵思力, 男\n" +
                        "      5. 孙晓龙, 男\n" +
                        "      6. 李永刚, 男\n" +
                        "      7. 戴海楠, 男\n" +
                        "      8. 于永, 男\n" +
                        "      9. 李敏, 女\n" +
                        "    10. 钱海燕, 女\n" +
                        "    11. 范晓萌, 女\n" +
                        "    12. 李思涵, 女\n" +
                        "    13. 王若琪, 女\n" +
                        "    14. 耿萱然, 女\n" +
                        "    15. 侯佳辰, 女\n" +
                        "    16. 王路鑫, 女");
            }
        });
        buttonBegin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList list1 ,list2;
                textOne.setText("");
                textTwo.setText("");
                Team team1=new Team(list);
                Team team2=new Team(list);
                list1=team1.getList1();
                list2=team2.getList2();
                ThreadA t1=new ThreadA(list1);
                ThreadA t2=new ThreadA(list2);
                Thread tt1=new Thread((Runnable) t1);
                Thread tt2=new Thread((Runnable) t2);
                tt1.start();tt2.start();
                String s1,s2;
                for(int i=0;i<list1.size();i++){
                    textOne.append((String) list1.get(i));
                    textOne.append("\n");
                }
                for(int i=0;i<list2.size();i++){
                    textTwo.append((String) list2.get(i));
                    textTwo.append("\n");
                }
            }
        });
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1,text2;
                text1=textOne.getText();
                text2=textTwo.getText();
                File file1=new File("D:\\t1.txt");
                File file2=new File("D:\\t2.txt");
                try {
                    FileWriter fw1=new FileWriter(file1);
                    fw1.write(text1);
                    fw1.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    FileWriter fw2=new FileWriter(file2);
                    fw2.write(text2);
                    fw2.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }
}
class ThreadA implements Runnable{
    ArrayList list;
    String s="";
    ThreadA(ArrayList list){
        this.list=list;
    }

    @Override
    public void run() {
        for(int i=0;i<list.size();i++){
            s+=list.get(i);
        }
    }
}
class Team  {
    ArrayList  list;
    ArrayList list1,list2;
    static ArrayList listshang,listxia;
    int flag;
    Team(ArrayList list){
        this.list=list;
        list2=new ArrayList();
        list1=new ArrayList<>();
        listshang=new ArrayList<>();
        listxia=new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            listshang.add(list.get(i));
        }
        for(int i=8;i<16;i++)
        {
            listxia.add(list.get(i));
        }

    }
    ArrayList getList1(){
        flag=8;
        int num1=8;int num2=8;
        while (flag>0){
            if(flag>4){
                int n=(int)(Math.random()*num1);
                list1.add(listshang.get(n));
                flag--;
                num1--;
                listshang.remove(n);
            }
            else if(flag>0&&flag<=4){
                int n=(int)(Math.random()*num2);
                list1.add(listxia.get(n));
                num2--;
                flag--;
                listxia.remove(n);
            }
        }
        return list1;
    }
    ArrayList getList2(){

        for(int i=0;i<4;i++)
        {
            list2.add(listshang.get(i));
        }
        for(int i=0;i<4;i++)
        {
            list2.add(listxia.get(i));
        }
        return list2;
    }


}
public class test {
    public static void main(String[] args){
        ArrayList list=new ArrayList<>();
        list.add(" 1. 张晓刚, 男");
        list.add(" 2. 段立明, 男");
        list.add(" 3. 王强, 男");
        list.add(" 4. 赵思力, 男");
        list.add(" 5. 孙晓龙, 男");
        list.add(" 6. 李永刚, 男");
        list.add(" 7. 戴海楠, 男");
        list.add(" 8. 于永, 男");
        list.add(" 9. 李敏, 女");
        list.add(" 10. 钱海燕, 女");
        list.add(" 11. 范晓萌, 女");
        list.add(" 12. 李思涵, 女");
        list.add(" 13. 王若琪, 女");
        list.add(" 14. 耿萱然, 女");
        list.add(" 15. 侯佳辰, 女");
        list.add("  16. 王路鑫, 女");
        Mypanel mycode=new Mypanel(list);
        mycode.createFrame();
    }
}
