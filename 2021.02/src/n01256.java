import java.io.*;

public class n01256 {

	static int N, M, K;
	static int[][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		dp = new int[N + M + 1][M + 1];

		for (int i = 0; i <= N + M; i++) {
			for (int j = 0; j <= Math.min(i, M); j++) {
				if (i == j || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

				if (dp[i][j] > 1000000000)
					dp[i][j] = 1000000000;
			}
		}

		if (dp[N + M][M] < K)
			bw.write(-1 + "\n");
		else
			bw.write(solve() + "\n");

		bw.flush();
	}

	public static String solve() {

		StringBuffer buf = new StringBuffer();

		int n = N;
		int m = M;

		K--;
		for (int i = n + m - 1; i >= 0; i--) {

			if (i >= m && K < dp[i][m])
				buf.append("a");
			else {
				buf.append("z");
				K -= dp[i][m];
				m--;
			}
		}

		return buf.toString();
	}
}
