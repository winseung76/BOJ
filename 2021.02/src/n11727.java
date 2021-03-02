import java.io.*;

public class n11727 {

	static int n;
	static int[] dp=new int[1001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= 1000; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;

		bw.write(dp[n] + "\n");
		bw.flush();

	}

}
