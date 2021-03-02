import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11049_Çà·Ä°ö¼À¼ø¼­ {

	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		dp = new int[N + 1][N + 1];

		for (int n = 1; n <= N; n++) {
			String[] str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]);
			int c = Integer.parseInt(str[1]);

			arr[n][0] = r;
			arr[n][1] = c;
		}
		/*
		for (int i = 1; i < N; i++)
			dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
			*/

		if (N == 1)
			dp[1][N] = arr[1][0] * arr[1][1];
		else {
			int min;
			for (int diff = 1; diff < N; diff++) {

				int n = 1;

				while (n + diff <= N) {
					min = Integer.MAX_VALUE;

					for (int k = n; k < n + diff; k++)
						min = Math.min(min,
								dp[n][k] + dp[k + 1][n + diff] + (arr[n][0] * arr[k][1] * arr[n + diff][1]));

					dp[n][n + diff] = min;
					n++;
				}

			}
		}

		bw.write(dp[1][N] + "\n");
		bw.flush();

	}
}
