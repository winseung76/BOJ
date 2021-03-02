import java.util.Scanner;

public class n11727_2N_≈∏¿œ∏µ2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0)
				dp[i] = 1;
			else if (i == 1)
				dp[i] = 3;
			else {
				dp[i] = dp[i - 1] + dp[i - 2] * 2;
			}
			dp[i] = dp[i] % 10007;
		}
		System.out.println(dp[n - 1]);

	}
}
