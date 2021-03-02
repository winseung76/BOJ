import java.util.Scanner;

public class n11057_오르막수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] dp = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			int j;
			for (j = 0; j < 10; j++) {
				if (i == 1)
					dp[i][j] = 1;
				else {
					for (int k = 0; k <= j; k++)
						dp[i][j] += dp[i - 1][k];
				}
				dp[i][j] %= 10007;
			}

		}
		int result = 0;
		for (int i = 0; i < 10; i++)
			result += dp[N][i];

		System.out.println(result % 10007);

	}
}
