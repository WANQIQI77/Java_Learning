package homework15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Asd implements Serializable {
	int x;

	Asd(int a) {
		this.x = a;
	}

	void getInfo() {
		System.out.println(x);
	}
}

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("D:\\Project\\eclipse\\homework15\\data.txt"));
			objectOutputStream.writeObject(new Asd(10));
			objectOutputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream objectInputStream;
		try {
			objectInputStream = new ObjectInputStream(
					new FileInputStream("D:\\Project\\eclipse\\homework15\\data.txt"));
			Asd b = (Asd) objectInputStream.readObject();
			b.getInfo();
			objectInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
