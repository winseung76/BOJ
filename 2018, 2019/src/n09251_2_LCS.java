import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09251_2_LCS {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[1001][1001];

		for (int i = 1; i <= s2.length(); i++) {
			char c2 = s2.charAt(i - 1);

			for (int j = 1; j <= s1.length(); j++) {
				char c1 = s1.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		bw.write(dp[s2.length()][s1.length()] + "\n");
		bw.flush();

	}
}
