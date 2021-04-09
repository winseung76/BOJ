import java.io.*;

public class n01328 {

	static int N, L, R;
	static long[][][] dp;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		dp = new long[101][101][101];

		dp[1][1][1] = 1;
		dp[2][2][1] = dp[2][1][2] = 1;

		for (int n = 3; n <= N; n++) {
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					dp[n][l][r] += dp[n - 1][l - 1][r] % MOD;
					dp[n][l][r] += dp[n - 1][l][r - 1] % MOD;
					dp[n][l][r] += (dp[n - 1][l][r] * (n - 2)) % MOD;
					dp[n][l][r] %= MOD;
				}
			}
		}

		bw.write(dp[N][L][R] % MOD + "\n");
		bw.flush();

	}

}
