import java.util.Scanner;

public class n01934_최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int tmp_A = sc.nextInt();
			int tmp_B = sc.nextInt();

			int A = Math.max(tmp_A, tmp_B);
			int B = Math.min(tmp_A, tmp_B);

			int r = 1;

			while (r > 0) {
				r = A % B;
				A = B;
				B = r;
			}
			int lcm = (tmp_A * tmp_B) / A;

			System.out.println(lcm);
		}

	}
}
