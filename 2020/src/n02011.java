import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02011 {

	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		if (str == null || str.equals("") || Integer.parseInt(str.substring(0, 1)) == 0) {
			bw.write("0\n");
			bw.flush();
			return;

		}

		dp = new int[str.length()];
		dp[0] = 1;

		if (str.length() > 1) {

			for (int n = 1; n < str.length(); n++) {

				int m = Integer.parseInt(str.substring(n, n + 1));

				if (m > 0)
					dp[n] += dp[n - 1];

				int k = Integer.parseInt(str.substring(n - 1, n + 1));

				if (Integer.parseInt(str.substring(n - 1, n)) != 0 && 1 <= k && k <= 26) {
					if (n > 1)
						dp[n] += dp[n - 2];
					else
						dp[n] += 1;
				}

				dp[n] = dp[n] % 1000000;
			}
		}

		bw.write(dp[str.length() - 1] + "\n");
		bw.flush();

	}

}
