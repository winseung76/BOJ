import java.util.Scanner;

public class n02293_����1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coins[i])
					dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[k]);

	}
}
