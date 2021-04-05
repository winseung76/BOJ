import java.io.*;

public class n11066 {

	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[] arr = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];
			int[] sum = new int[K + 1];

			String[] input = br.readLine().split(" ");

			for (int i = 1; i <= K; i++) {
				arr[i] = Integer.parseInt(input[i - 1]);
				sum[i] = sum[i - 1] + arr[i];
			}

			for (int i = 1; i <= K; i++) {
				for (int j = 1; j <= K; j++) {
					if (i != j)
						dp[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 1; i < K; i++) {
				for (int s = 1; s <= K - i; s++) {

					int e = s + i;

					for (int m = s; m < e; m++) {

						dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m + 1][e] + sum[e] - sum[s - 1]);
					}

				}
			}

			bw.write(dp[1][K] + "\n");

		}

		bw.flush();

	}
}
