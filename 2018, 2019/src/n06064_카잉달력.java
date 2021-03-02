import java.util.Scanner;

public class n06064_Ä«À×´Þ·Â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int a = Math.max(M, N);
			int b = Math.min(M, N);
			int tmp = 1;
			while (tmp > 0) {
				tmp = a % b;
				a = b;
				b = tmp;
			}
			int lcm = (M * N) / a;
			int n = 0, k = -1;
			while (true) {
				if (x == M)
					x = 0;
				if (y == N)
					y = 0;
				int tmp_k = M * n + x;

				if (tmp_k % N == y) {
					k = tmp_k;
					break;
				}
				if (tmp_k > lcm)
					break;
				n++;
			}
			System.out.println(k);
		}
	}
}
