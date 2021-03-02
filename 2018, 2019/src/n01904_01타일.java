import java.util.Scanner;

public class n01904_01≈∏¿œ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			if (i == 0)
				dp[i] = 1;
			else if (i == 1)
				dp[i] = 2;
			else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			dp[i] = dp[i] % 15746;
		}
		System.out.println(dp[N - 1] % 15746);
	}
}
