package homework15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser("D:\\Project\\eclipse\\homework7\\src");
		chooser.showOpenDialog(null);
		try {
			File file = chooser.getSelectedFile();
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			String str;
			while ((str = bReader.readLine()) != null) {
				System.out.println(str);

			}
			bReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
