import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01890_มกวม {
	static int N;
	static int[][] board;
	static long[][] dp;
	static int[] y = { 0, 1 };
	static int[] x = { 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		dp = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(s[j - 1]);
				dp[i][j] = -1;
			}
		}
		bw.write(dfs(1, 1) + "\n");
		bw.flush();

	}

	public static long dfs(int sn, int sm) {

		int jump = board[sn][sm];
		dp[sn][sm] = 0;

		if (jump > 0) {
			for (int i = 0; i < 2; i++) {
				int n = sn + jump * y[i];
				int m = sm + jump * x[i];

				if ((1 <= n && n <= N) && (1 <= m && m <= N)) {
					if (n == N && m == N) {
						dp[sn][sm] = 1;
						break;
					} else {
						if (dp[n][m] >= 0)
							dp[sn][sm] += dp[n][m];
						else
							dp[sn][sm] += dfs(n, m);
					}
				}
			}
		}

		return dp[sn][sm];
	}
}
