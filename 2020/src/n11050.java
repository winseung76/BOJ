import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11050 {

	static int N, K;
	static int[][] dp = new int[11][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		for (int i = 0; i <= 10; i++) {
			dp[i] = new int[i + 1];
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		bw.write(dp[N][K] + "\n");
		bw.flush();

	}

}
