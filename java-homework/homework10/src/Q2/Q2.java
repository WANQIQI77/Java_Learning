package Q2;

class UnderAverageException extends Exception {
	UnderAverageException() {
		// TODO Auto-generated constructor stub
		super();
	}

	UnderAverageException(int a) {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "平均成绩低于六十分";
	}

}

public class Q2 {
	static int GetAverage(int[] a) {
		int sum = 0, num = 0;
		for (int i : a) {
			num++;
			sum = sum + i;
		}
		return sum / num;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int ave;
		ave = GetAverage(a);
		try {
			if (ave < 60)
				throw new UnderAverageException();
			System.out.println("平均成绩为" + ave);
		} catch (UnderAverageException e) {
			System.out.println(e.getMessage());
		}

	}
}
