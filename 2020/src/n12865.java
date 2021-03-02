import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n12865 {

	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			s = br.readLine().split(" ");
			int W = Integer.parseInt(s[0]);
			int V = Integer.parseInt(s[1]);

			for (int j = 1; j <= K; j++) {
				if (j < W)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
			}
			
		}

		bw.write(dp[N][K] + "\n");
		bw.flush();

	}
}
