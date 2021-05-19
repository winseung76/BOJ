import java.io.*;

public class n01535 {

	static int N;
	static int[] energy, happy;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][101];
		energy = new int[N + 1];
		happy = new int[N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			energy[i] = Integer.parseInt(input[i - 1]);
		}

		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			happy[i] = Integer.parseInt(input[i - 1]);
		}
		solve();

		bw.write(dp[N][99] + "\n");
		bw.flush();

	}

	public static void solve() {

		for (int j = 1; j <= N; j++) {
			for (int i = 0; i <= 100; i++) {
				if (i < energy[j])
					dp[j][i] = dp[j - 1][i];
				else
					dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - energy[j]] + happy[j]);
			}
		}
	}

}
