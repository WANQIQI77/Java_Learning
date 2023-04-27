package Q1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Q1 {
	public static void main(String[] args)
	{
		
		String[] a=new String[100];
		Scanner scan=new Scanner(System.in);
		int i=0;
	
		while(scan.hasNextLine()) 
		{
			a[i]=scan.nextLine();
			if(a[i].equals("")) break;
			i++;
		}
		scan.close();
		
//		for(String t:a) {
//			System.out.println(t);
//		}
		System.out.println("--------------------------------");
		ArrayList<String> list=new ArrayList<String>();
		for(int k=0;k<i;k++)
		{
			list.add(a[k]);
		}
		
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("--------------------------------");
		list.remove("vvv");
		
		Iterator<String> it2=list.iterator();
		while(it2.hasNext())
		{
			System.out.println(it2.next());
		}
	}
}