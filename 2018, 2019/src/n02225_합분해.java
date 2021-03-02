import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02225_ÇÕºÐÇØ {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		long[][] dp = new long[N + 1][K + 1];

		for (int i = 0; i <= N; i++)
			dp[i][1] = 1;

		for (int n = 0; n <= N; n++) {
			for (int k = 1; k <= K; k++) {
				for (int i = 0; i <= n; i++) {
					dp[n][k] += dp[i][k - 1];
				}
				dp[n][k] = dp[n][k] % 1000000000;
			}
		}

		bw.write(dp[N][K] + "\n");
		bw.flush();
	}
}
