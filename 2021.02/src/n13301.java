import java.io.*;

public class n13301 {

	static int N;
	static long[] dp = new long[81];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= 80; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		long res = dp[N] * 4 + dp[N - 1] * 2;

		bw.write(res + "\n");
		bw.flush();

	}

}
