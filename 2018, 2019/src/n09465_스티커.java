import java.util.Scanner;

public class n09465_½ºÆ¼Ä¿ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < n; j++) {
					arr[k][j] = sc.nextInt();
				}
			}
			for (int c = 0; c < n; c++) {
				for (int r = 0; r < 2; r++) {
					if (c == 0)
						dp[r][0] = arr[r][0];
					else if (c == 1)
						dp[r][1] = dp[Math.abs(r - 1)][0] + arr[r][1];
					else {
						dp[r][c] = Math.max(Math.max(dp[0][c - 2], dp[1][c - 2]), dp[Math.abs(r - 1)][c - 1]);
						dp[r][c] += arr[r][c];
					}

				}
			}
			int max = Math.max(dp[0][n - 1], dp[1][n - 1]);
			System.out.println(max);

		}
	}
}
