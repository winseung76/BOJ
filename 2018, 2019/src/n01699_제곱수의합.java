import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01699_Á¦°ö¼öÀÇÇÕ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			double d_num = Math.sqrt(i);
			int i_num = (int) Math.sqrt(i);
			int min = Integer.MAX_VALUE;

			if (d_num == i_num) {
				dp[i] = 1;
			} else {
				for (int j = 1; j <= i / 2; j++) {
					min = Math.min(dp[j] + dp[i - j], min);
				}
				dp[i] = min;
			}

		}

		bw.write(dp[n] + "\n");
		bw.flush();

	}
}
