import java.util.Scanner;

public class n09461_파도반_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		long[] dp = new long[101];

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			for (int j = 1; j <= N; j++) {
				if (j <= 3)
					dp[j] = 1;
				else {
					dp[j] = dp[j - 2] + dp[j - 3];
				}
			}
			System.out.println(dp[N]);
		}

	}
}
