package Q1;

import java.util.InputMismatchException;
import java.util.Scanner;

class OutOfRangeException extends Exception {
	/**
	 * 
	 */
	// private static final long serialVersionUID = -8014663286907284633L;

	OutOfRangeException() {
		super();
	}
}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int in;
		try {
			in = scan.nextInt();

			if (in < 1 || in > 7)
				throw new OutOfRangeException();

			if (in == 1)
				System.out.println("Monday");
			if (in == 2)
				System.out.println("Tuesday");
			if (in == 3)
				System.out.println("Wednesday");
			if (in == 4)
				System.out.println("Thursday");
			if (in == 5)
				System.out.println("Friday");
			if (in == 6)
				System.out.println("Saturday");
			if (in == 7)
				System.out.println("Sunday");
		} catch (InputMismatchException e) {
			System.out.println("类型不匹配异常");
		} catch (OutOfRangeException e) {
			System.out.println("输入数值范围不合理");
		} finally {

		}

	}

}
