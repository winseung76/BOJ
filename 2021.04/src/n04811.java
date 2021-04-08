import java.io.*;

public class n04811 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			long[][][] dp = new long[2 * N + 1][2 * N + 1][N + 1];

			dp[1][1][N - 1] = 1;

			for (int t = 2; t <= 2 * N; t++) {
				for (int h = 0; h <= 2 * N; h++) {
					for (int w = 0; w <= N; w++) {

						if (h + 1 <= 2 * N)
							dp[t][h][w] += dp[t - 1][h + 1][w];
						if (h - 1 >= 0 && w + 1 <= N)
							dp[t][h][w] += dp[t - 1][h - 1][w + 1];
					}
				}
			}

			long sum = 0;
			for (int h = 0; h <= 2 * N; h++) {
				for (int w = 0; w <= N; w++) {
					sum += dp[2 * N][h][w];
				}
			}
			bw.write(sum + "\n");
		}
		bw.flush();
	}
}
