import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n07579 {

	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		dp = new int[N + 1][10001];

		String[] marr = br.readLine().split(" ");
		String[] carr = br.readLine().split(" ");

		for (int i = 1; i <= N; i++) {

			int m = Integer.parseInt(marr[i - 1]);
			int c = Integer.parseInt(carr[i - 1]);

			for (int j = 0; j <= 10000; j++) {
				if (j < c)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
			}
		}

		for (int i = 1; i <= 10000; i++) {
			if (dp[N][i] >= M) {
				bw.write(i + "\n");
				bw.flush();
				return;
			}
		}

	}
}
