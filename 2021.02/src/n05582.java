import java.io.*;

public class n05582 {

	static int[][] dp;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();

		dp = new int[s2.length() + 1][s1.length() + 1];

		for (int i = 1; i <= s2.length(); i++) {
			char ch2 = s2.charAt(i - 1);

			for (int j = 1; j <= s1.length(); j++) {
				char ch1 = s1.charAt(j - 1);

				if (ch1 == ch2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		bw.write(max + "\n");
		bw.flush();

	}

}
