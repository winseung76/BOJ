import java.io.*;

public class n16194 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		String[] sarr = br.readLine().split(" ");
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(sarr[i - 1]);
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
		}

		bw.write(dp[N] + "\n");
		bw.flush();

	}

}
