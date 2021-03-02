import java.util.Scanner;

public class n02775_부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] sum = new int[k][n + 1];

			for (int r = 0; r < k; r++) {
				for (int c = 1; c <= n; c++) {
					if (r == 0)
						sum[r][c] = c;
					else
						sum[r][c] = sum[r - 1][c];

					sum[r][c] += sum[r][c - 1];
				}
			}
			System.out.println(sum[k - 1][n]);
		}

	}
}
