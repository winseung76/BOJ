import java.util.Scanner;

public class n03036_¸µ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int a = sc.nextInt();

		for (int i = 0; i < N - 1; i++) {
			int b = sc.nextInt();
			int tmp_a = Math.max(a, b);
			int tmp_b = Math.min(a, b);
			int r = 1;
			while (r > 0) {
				r = tmp_a % tmp_b;
				tmp_a = tmp_b;
				tmp_b = r;
			}
			int gcd = tmp_a;
			System.out.println(a / gcd + "/" + b / gcd);
		}

	}
}
