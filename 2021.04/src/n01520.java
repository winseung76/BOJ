import java.io.*;

public class n01520 {

	static int M, N;
	static int[][] arr, dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		arr = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(input[j - 1]);
				dp[i][j] = -1;
			}
		}

		dp[M][N] = 1;

		int res = dfs(1, 1);

		bw.write(res + "\n");
		bw.flush();
	}

	public static int dfs(int r, int c) {

		int[] mr = { 0, 1, 0, -1 };
		int[] mc = { 1, 0, -1, 0 };

		if (r == M && c == N) {
			return 1;
		}

		dp[r][c] = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + mr[i];
			int nc = c + mc[i];

			if ((1 <= nr && nr <= M) && (1 <= nc && nc <= N) && arr[nr][nc] < arr[r][c]) {
				if (dp[nr][nc] >= 0)
					dp[r][c] += dp[nr][nc];
				else
					dp[r][c] += dfs(nr, nc);

			}
		}

		return dp[r][c];

	}

}
