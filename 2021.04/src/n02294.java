import java.io.*;

public class n02294 {

	static int n, k;
	static int[] coin;
	static int[] dp;
	static final int max = 10001;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		coin = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());

		for (int i = 1; i <= k; i++)
			dp[i] = max;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i])
					dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		if (dp[k] >= max)
			dp[k] = -1;
		bw.write(dp[k] + "\n");
		bw.flush();

	}

}
