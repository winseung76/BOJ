import java.io.*;

public class n11049 {

	static int N;
	static int[][] dp;
	static Pair[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][N + 1];
		arr = new Pair[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			arr[i] = new Pair(r, c);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					dp[i][j] = 0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int g = 1; g < N; g++) {
			for (int s = 1; s <= N - g; s++) {
				int e = s + g;

				for (int i = s; i < e; i++) {
					int sum = dp[s][i] + dp[i + 1][e] + (arr[s].r) * (arr[i].c) * (arr[e].c);
					dp[s][e] = Math.min(dp[s][e], sum);
				}
			}
		}

		bw.write(dp[1][N] + "\n");
		bw.flush();

	}

	static class Pair {

		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
