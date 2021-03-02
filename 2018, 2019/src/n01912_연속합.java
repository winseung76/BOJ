import java.util.Arrays;
import java.util.Scanner;

public class n01912_¿¬¼ÓÇÕ {
	private static int[] arr, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			if (i == 0)
				dp[0] = arr[0];
			else {
				if (dp[i - 1] < 0)
					dp[i] = arr[i];
				else
					dp[i] = dp[i - 1] + arr[i];
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);

	}
}
