import java.io.*;
import java.util.*;

public class n02749 {

	static final int MOD = 1000000;
	static long[] dp = new long[1500001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= 1500000; i++) {
			dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
			dp[i] %= MOD;
		}

		int res = (int) (n % 1500000);

		bw.write(dp[res] + "\n");
		bw.flush();

	}

}
