import java.util.Scanner;

public class n01629_°ö¼À {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();

		System.out.println(pow(A, B, C));
	}

	public static long pow(long a, long b, long c) {

		if (b == 1)
			return a % c;

		long result = pow(a, b / 2, c);

		if (b % 2 == 0)
			return result * result % c;
		else
			return result * pow(a, b / 2 + 1, c) % c;
	}
}
