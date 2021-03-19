import java.io.*;
import java.util.*;

public class n02491 {

	static int N;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][2];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(input[i]);

		dp[0][0] = 1;
		dp[0][1] = 1;

		for (int i = 1; i < N; i++) {

			if (arr[i - 1] < arr[i]) {
				dp[i][0] = dp[i - 1][0] + 1;
				dp[i][1] = 1;
			}

			else if (arr[i - 1] > arr[i]) {
				dp[i][0] = 1;
				dp[i][1] = dp[i - 1][1] + 1;
			}

			else {
				dp[i][0] = dp[i - 1][0] + 1;
				dp[i][1] = dp[i - 1][1] + 1;
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

		bw.write(max + "\n");
		bw.flush();

	}

}
