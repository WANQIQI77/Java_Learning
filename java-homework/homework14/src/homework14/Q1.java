package homework14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// D:\Project\eclipse\homewrok13\src\homewrok13\Q1.java
		try {
			File jiva13 = new File("D:\\Project\\eclipse\\homewrok13\\src\\homewrok13\\Q1.java");
			FileReader fReader = new FileReader(jiva13);
			int n;
			while ((n = fReader.read()) != -1) {
				System.out.print((char) n);
			}
			fReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("文件打开失败");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("文件输入异常");
		}
	}

}
