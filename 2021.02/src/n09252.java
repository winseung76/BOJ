import java.io.*;

public class n09252 {

	static int[][] dp;

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
			}
		}
		int i = s1.length();
		int j = s2.length();
		StringBuffer buf = new StringBuffer();

		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i][j - 1])
				j--;
			else if (dp[i][j] == dp[i - 1][j])
				i--;
			else if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				i--;
				j--;
				buf.append(s1.charAt(i));
			}
		}

		bw.write(dp[s1.length()][s2.length()] + "\n");
		bw.write(buf.reverse().toString() + "\n");
		bw.flush();

	}

}
