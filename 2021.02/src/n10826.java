import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10826 {

	static int n;
	static String[] dp = new String[10001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		dp[0] = "0";
		dp[1] = "1";

		for (int i = 2; i <= 10000; i++) {
			boolean flag = false;
			int pl = dp[i - 1].length() - 1;
			int pr = dp[i - 2].length() - 1;
			StringBuffer buf = new StringBuffer();

			while (pl >= 0 || pr >= 0) {

				int m = 0;
				if (pl >= 0)
					m += (dp[i - 1].charAt(pl--) - '0');

				if (pr >= 0)
					m += (dp[i - 2].charAt(pr--) - '0');

				if (flag)
					m++;

				if (m >= 10)
					flag = true;
				else
					flag = false;

				buf.append(String.valueOf(m % 10));
			}
			if (flag)
				buf.append("1");

			dp[i] = buf.reverse().toString();
		}

		bw.write(dp[n] + "\n");
		bw.flush();

	}

}
