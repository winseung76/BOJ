import java.io.*;

public class n01890 {

	static int N;
	static long[][] arr, dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1][N + 1];
		dp = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Long.parseLong(input[j - 1]);
			}
		}
		dp[1][1] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				for (int c = 1; c < j; c++) {
					if (arr[i][c] == j - c)
						dp[i][j] += dp[i][c];
				}

				for (int r = 1; r < i; r++) {
					if (arr[r][j] == i - r)
						dp[i][j] += dp[r][j];
				}
			}
		}

		bw.write(dp[N][N] + "\n");
		bw.flush();

	}

}
