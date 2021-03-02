import java.util.Scanner;

public class n01074_Z {
	private static int R, C, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		int result = getVisitCount(N, 0, 0);

		System.out.println(result);

	}

	public static int getVisitCount(int n, int r, int c) {

		int[] x = { 0, 0, 1, 1 };
		int[] y = { 0, 1, 0, 1 };
		int sum = 0;

		if (n == 1) {
			for (int i = 0; i < 4; i++) {
				int new_r = r + x[i];
				int new_c = c + y[i];

				if (new_r == R && new_c == C) {
					return i;
				}
			}
			return 4;
		}
		int nr = r + (int) Math.pow(2, n) / 2;
		int nc = c + (int) Math.pow(2, n) / 2;

		if (r <= R && R < nr && c <= C && C < nc) // 1사분면에 있는 경우
			sum = getVisitCount(n - 1, r, c);

		else if (r <= R && R < nr && nc <= C) // 2사분면에 있는 경우
			sum = (int) Math.pow(2, 2 * n - 2) + getVisitCount(n - 1, r, nc);

		else if (nr <= R && c <= C && C < nc) // 3사분면에 있는 경우
			sum = (int) Math.pow(2, 2 * n - 2) * 2 + getVisitCount(n - 1, nr, c);

		else if (nr <= R && nc <= C) // 4사분면에 있는 경우
			sum = (int) Math.pow(2, 2 * n - 2) * 3 + getVisitCount(n - 1, nr, nc);

		return sum;
	}
}
