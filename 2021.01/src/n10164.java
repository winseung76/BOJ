import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10164 {

	static int N, M, K;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);

		arr = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		int n = 1;
		Pos temp = null;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = n++;
				if (arr[i][j] == K)
					temp = new Pos(i, j);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i == 1)
					dp[i][j] = 1;
				else {
					if (temp == null)
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

					else {
						if (i > temp.r && temp.c == j)
							dp[i][j] = dp[i - 1][j];
						else if (j > temp.c && temp.r == i)
							dp[i][j] = dp[i][j - 1];
						else
							dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}

		bw.write(dp[N][M] + "\n");
		bw.flush();

	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
