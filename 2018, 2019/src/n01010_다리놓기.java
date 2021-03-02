import java.util.Scanner;

public class n01010_다리놓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[][] dp;
		int sum = 0;
		for (int n = 0; n < T; n++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			dp = new int[N][M];
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i; j <= M - N + i; j++) {
					if (i == 0 || i == j)
						dp[i][j] = 1;
					else {
						dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
					}
					if (i == N - 1)
						sum += dp[i][j];

				}
			}
			System.out.println(sum);
		}
	}
}
