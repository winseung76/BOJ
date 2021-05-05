import java.io.*;

public class n18111 {

	static int N, M, B;
	static int[][] board;
	static int min = Integer.MAX_VALUE;
	static int height;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		B = Integer.parseInt(input[2]);

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}

		solve();
		bw.write(min + " " + height + "\n");
		bw.flush();

	}

	public static void solve() {

		for (int h = 0; h <= 256; h++) {
			int have = B;
			int need = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (board[r][c] < h)
						need += h - board[r][c];
					else if (board[r][c] > h)
						have += board[r][c] - h;

				}
			}

			if (have < need)
				continue;

			int time = (have - B) * 2 + need;

			if (min == time)
				height = Math.max(height, h);
			else if (min > time) {
				min = time;
				height = h;
			}

		}
	}

}
