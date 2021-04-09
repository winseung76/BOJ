import java.io.*;

public class n02240 {

	static int T, W;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		T = Integer.parseInt(input[0]);
		W = Integer.parseInt(input[1]);

		dp = new int[T + 1][3][W + 1];

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i <= W; i++) {

				if (n == 1) {
					if (i == 0)
						dp[t][1][i] = dp[t - 1][1][i] + 1;
					else {
						dp[t][1][i] = Math.max(dp[t - 1][1][i], dp[t - 1][2][i - 1]) + 1;
						dp[t][2][i] = Math.max(dp[t - 1][1][i - 1], dp[t - 1][2][i]);
					}
				}
				if (n == 2) {
					if (i == 0)
						dp[t][1][i] = dp[t - 1][1][i];
					else {
						dp[t][1][i] = Math.max(dp[t - 1][1][i], dp[t - 1][2][i - 1]);
						dp[t][2][i] = Math.max(dp[t - 1][1][i - 1], dp[t - 1][2][i]) + 1;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= W; i++) {
			max = Math.max(max, Math.max(dp[T][1][i], dp[T][2][i]));
		}

		bw.write(max + "\n");
		bw.flush();

	}

}
