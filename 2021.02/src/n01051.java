import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01051 {

	static int N, M;
	static int[][] board;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int n = board[i][j];
				int max = Math.min(N - i, M - j);

				for (int size = 1; size <= max; size++) {
					int a = board[i][j + size - 1];
					int b = board[i + size - 1][j + size - 1];
					int c = board[i + size - 1][j];

					if (n == a && n == b && n == c)
						res = Math.max(res, size);

				}

			}
		}

		return res * res;

	}

}
