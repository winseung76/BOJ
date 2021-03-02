import java.util.Arrays;
import java.util.Scanner;

public class n14501_Επ»η {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] T = new int[N];
		int[] P = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < i; j++) {
				if ((i + 1) - (j + T[j]) > 0) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			if (i + T[i] <= N)
				dp[i] += P[i];

		}
		Arrays.sort(dp);
		System.out.print(dp[N - 1]);

	}
}
