import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02133_타일채우기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		dp[0] = 1;

		for (int i = 2; i <= N; i = i + 2) {
			if (i == 2)
				dp[i] = 3;
			else {
				dp[i] += dp[i - 2] * dp[2];
				for (int j = 0; j < i - 2; j = j + 2) {
					dp[i] += dp[j] * 2;
				}

			}

		}
		bw.write(dp[N] + "\n");
		bw.flush();
	}
}
