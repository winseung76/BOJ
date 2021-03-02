import java.io.*;

public class n11048 {

	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] += Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
			}
		}

		bw.write(dp[N][M] + "\n");
		bw.flush();

	}
}
