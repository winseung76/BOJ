import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11051_이항계수2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int N = Integer.parseInt(s.split(" ")[0]);
		int K = Integer.parseInt(s.split(" ")[1]);
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i == j || j == 0)
					dp[i][j] = 1;
				else if (j == 1)
					dp[i][j] = i;
				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
					dp[i][j] = dp[i][j] % 10007;
				}
			}
		}

		bw.write(dp[N][K] + "\n");
		bw.flush();
	}
}
