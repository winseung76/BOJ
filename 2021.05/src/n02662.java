import java.io.*;
import java.util.*;

public class n02662 {

	static int N, M;
	static long[][] company, dp, check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		company = new long[M + 1][N + 1];
		dp = new long[M + 1][N + 1];
		check = new long[M + 1][N + 1];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int m = Integer.parseInt(input[0]);
			for (int j = 1; j <= M; j++) {
				company[j][m] = Long.parseLong(input[j]);
			}
		}

		bw.write(solve() + "\n");

		List<Integer> list = new ArrayList<>();
		int tmp = N;
		for (int i = M; i >= 1; i--) {
			list.add((int) check[i][tmp]);
			tmp = tmp - (int) check[i][tmp];
		}
		Collections.reverse(list);

		for (int n : list)
			bw.write(n + " ");
		bw.flush();

	}

	public static long solve() {

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {

				int max = 0;
				for (int k = 0; k <= j; k++) {

					if (dp[i][j] < dp[i - 1][j - k] + company[i][k]) {
						dp[i][j] = dp[i - 1][j - k] + company[i][k];
						max = k;
					}
				}

				check[i][j] = max;
			}
		}

		return dp[M][N];
	}
}
