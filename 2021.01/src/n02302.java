import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02302 {

	static int N, M;
	static boolean[] fixed;
	static long[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		fixed = new boolean[N + 1];
		dp = new long[N + 1];

		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine());
			fixed[n] = true;
		}

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (fixed[i])
				dp[i] = dp[i - 1];
			else {
				if (fixed[i - 1])
					dp[i] = dp[i - 2];
				else
					dp[i] = dp[i - 1] + dp[i - 2];
			}

		}

		bw.write(dp[N] + "\n");
		bw.flush();

	}

}
