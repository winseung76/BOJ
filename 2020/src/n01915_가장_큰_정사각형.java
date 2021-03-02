import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01915_가장_큰_정사각형 {

	static int[][] dp, board;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		board = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				board[i][j] = Integer.parseInt(s.substring(j, j + 1));
				if (board[i][j] == 1)
					dp[i][j] = 1;
			}
		}
		int[] x = { -1, 0, -1 };
		int[] y = { 0, -1, -1 };
		boolean[] flag = new boolean[3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (board[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < 3; k++) {
						int r = i + y[k];
						int c = j + x[k];
						if ((0 <= r && r < n) && (0 <= c && c < m))
							min = Math.min(min, dp[r][c]);
						else {
							min = 0;
							break;
						}

					}
					dp[i][j] += min;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		bw.write(max * max + "\n");
		bw.flush();

	}
}
