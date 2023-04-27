package homework15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
	int x;

	A(int x) {
		this.x = x;
	}

	void getInfo() {
		System.out.println(x);
	}
}

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInputStream objectInputStream;
		ObjectOutputStream objectOutputStream;
		A[] a = new A[10];
		for (int i = 0; i < 10; i++) {
			a[i] = new A(i);
		}
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
			for (int i = 0; i < 10; i++) {
				objectOutputStream.writeObject(a[i]);
			}
			objectOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
			A b;
			for (int i = 0; i < 10; i++) {
				b = (A) objectInputStream.readObject();
				b.getInfo();
			}
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
