import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09252_LCS2 {

	static int[][] dp;
	static int max;
	static String res = "";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();

		dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s2.length(); i++) {
			for (int j = 1; j <= s1.length(); j++) {
				char ch1 = s1.charAt(j - 1);
				char ch2 = s2.charAt(i - 1);

				if (ch1 == ch2)
					dp[j][i] = dp[j - 1][i - 1] + 1;
				else
					dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);

				max = Math.max(max, dp[j][i]);
			}
		}
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int cnt = max;

		while (i >= 0 && j >= 0) {
			if (s1.charAt(i)== s2.charAt(j) && dp[i + 1][j + 1] == cnt) {
				res = s1.charAt(i) + res;
				i--;
				j = s2.length() - 1;
				cnt--;

			} else {
				if (j > 0)
					j--;
				else {
					i--;
					j = s2.length() - 1;
				}
			}
		}

		bw.write(max + "\n");
		bw.write(res + "\n");
		bw.flush();

	}
}
