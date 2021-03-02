import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01788_피보나치_수의_확장 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int N = Math.abs(n);
		long[] dp = new long[N + 1];

		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			if (i == 1)
				dp[i] = 1;
			else
				dp[i] = dp[i - 2] + dp[i - 1];

			dp[i] = dp[i] % 1000000000;
		}

		int res;
		if (n < 0 && N % 2 == 0)
			res = -1;
		else if (n == 0)
			res = 0;
		else
			res = 1;

		bw.write(res + "\n");
		bw.write(dp[N] + "\n");
		bw.flush();
	}
}
