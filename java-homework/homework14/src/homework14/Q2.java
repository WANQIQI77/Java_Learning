package homework14;

import java.io.FileWriter;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fWriter = new FileWriter("D:\\test\\data.txt");
			String ch = System.getProperty("line.separator");
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextLine()) {
				String str2 = scanner.nextLine();
				if (str2.equals(""))
					break;
				else {
					fWriter.write(str2);
					fWriter.write(ch);
				}
			}

			fWriter.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
