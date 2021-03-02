import java.util.Scanner;

public class n11052_카드구매하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			dp[i] = x;

			if (i > 0) {
				dp[i] = x;
				for (int j = 0; j <= i / 2; j++) {
					dp[i] = Math.max(dp[j] + dp[i - j - 1], dp[i]);
				}
			}

		}
		System.out.println(dp[N - 1]);
	}
}
