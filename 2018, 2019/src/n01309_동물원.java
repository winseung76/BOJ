import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01309_µ¿¹°¿ø {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			if (i == 1)
				dp[i][0] = dp[i][1] = dp[i][2] = 1;
			else {
				dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
				dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
				dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
			}
			dp[i][0] = dp[i][0] % 9901;
			dp[i][1] = dp[i][1] % 9901;
			dp[i][2] = dp[i][2] % 9901;
		}

		bw.write((dp[N][0] + dp[N][1] + dp[N][2]) % 9901 + "\n");
		bw.flush();
	}
}
