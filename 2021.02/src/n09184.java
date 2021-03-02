
import java.io.*;

public class n09184 {

	static int[][][] dp = new int[51][51][51];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				for (int k = 0; k <= 20; k++) {

					if (i == 0 || j == 0 || k == 0)
						dp[i][j][k] = 1;
					else if (i < j && j < k)
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					else
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
				}
			}
		}
		
		for (int i = 0; i <= 50; i++) {
			for (int j = 0; j <= 50; j++) {
				for (int k = 0; k <= 50; k++) {

					if (i == 0 || j == 0 || k == 0)
						dp[i][j][k] = 1;
					else if (i > 20 || j > 20 || k > 20)
						dp[i][j][k] = dp[20][20][20];
					else if (i < j && j < k)
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					else
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
				}
			}
		}

		while (true) {

			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			int c = Integer.parseInt(sarr[2]);

			if (a == -1 && b == -1 && c == -1)
				break;

			bw.write("w(" + a + ", " + b + ", " + c + ") = " + dp[Math.max(a, 0)][Math.max(b, 0)][Math.max(c, 0)]
					+ "\n");
		}

		bw.flush();

	}

}
