import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n17070 {

	static int[][][] dp;
	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][N + 1][3];
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(s[j - 1]);
		}

		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			int j;
			if (i == 1)
				j = 3;
			else
				j = 1;

			for (; j <= N; j++) {
				if (map[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
					if (map[i - 1][j] != 1 && map[i][j - 1] != 1)
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}

			}
		}

		bw.write(dp[N][N][0] + dp[N][N][1] + dp[N][N][2] + "\n");
		bw.flush();

	}

}
