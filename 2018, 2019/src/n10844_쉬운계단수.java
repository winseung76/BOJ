import java.util.Scanner;

public class n10844_쉬운계단수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[][] dp = new long[N][10];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0)
					dp[0][j] = 1;
				else {
					if (j == 0)
						dp[i][j] = dp[i - 1][j + 1];
					else if (j == 9)
						dp[i][j] = dp[i - 1][j - 1];
					else
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
				}
				dp[i][j] = dp[i][j] % 1000000000;
			}

		}
		for (int i = 1; i < 10; i++) {
			sum += dp[N - 1][i];
			sum = sum % 1000000000;
		}

		System.out.println(sum);
	}
}
