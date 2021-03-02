import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n12100 {

	static int N;
	static int[][] board;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}

		comb(0, 0);
		bw.write(res + "\n");
		bw.flush();

	}

	public static void comb(int cnt, int max) {

		int[][] boardCopy = new int[N][N];

		if (cnt == 5) {
			res = Math.max(res, max);
			return;
		}

		for (int i = 0; i < 4; i++) {

			for (int k = 0; k < board.length; k++) {
				System.arraycopy(board[k], 0, boardCopy[k], 0, N);
			}

			max = Math.max(max, solve(i));
			comb(cnt + 1, max);

			for (int k = 0; k < board.length; k++) {
				System.arraycopy(boardCopy[k], 0, board[k], 0, N);
			}

		}
	}

	public static int solve(int idx) {

		int max = 0;

		switch (idx) {

		case 0:
			max = moveEast();
			break;
		case 1:
			max = moveWest();
			break;
		case 2:
			max = moveSouth();
			break;
		case 3:
			max = moveNorth();
			break;
		}

		return max;
	}

	public static int moveEast() {

		int max = 0;

		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {

				if (board[r][c] > 0) {

					for (int i = N - 1; i > c; i--) {
						if (board[r][i] == 0) {
							board[r][i] = board[r][c];
							board[r][c] = 0;
							break;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {

				max = Math.max(max, board[r][c]);

				if (board[r][c] == 0)
					break;

				int nr = r;
				int nc = c - 1;

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {

					if (board[nr][nc] != board[r][c])
						continue;

					board[r][c] += board[nr][nc];
					board[nr][nc] = 0;

					max = Math.max(max, board[r][c]);

					for (int i = nc; i > 0; i--) {
						board[r][i] = board[r][i - 1];
						board[r][i - 1] = 0;
					}

				}

			}

		}

		return max;
	}

	public static int moveWest() {
		int max = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				if (board[r][c] > 0) {

					for (int i = 0; i < c; i++) {
						if (board[r][i] == 0) {
							board[r][i] = board[r][c];
							board[r][c] = 0;
							break;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				max = Math.max(max, board[r][c]);

				if (board[r][c] == 0)
					break;

				int nr = r;
				int nc = c + 1;

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {

					if (board[nr][nc] != board[r][c])
						continue;

					board[r][c] += board[nr][nc];
					board[nr][nc] = 0;

					max = Math.max(max, board[r][c]);

					for (int i = nc; i < N - 1; i++) {
						board[r][i] = board[r][i + 1];
						board[r][i + 1] = 0;
					}
				}

			}

		}

		return max;
	}

	public static int moveSouth() {
		int max = 0;

		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {

				if (board[r][c] > 0) {

					for (int i = N - 1; i > r; i--) {
						if (board[i][c] == 0) {
							board[i][c] = board[r][c];
							board[r][c] = 0;
							break;
						}
					}
				}
			}
		}

		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {

				max = Math.max(max, board[r][c]);

				if (board[r][c] == 0)
					break;

				int nr = r - 1;
				int nc = c;

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {

					if (board[nr][nc] != board[r][c])
						continue;

					board[r][c] += board[nr][nc];
					board[nr][nc] = 0;

					max = Math.max(max, board[r][c]);

					for (int i = nr; i > 0; i--) {
						board[i][c] = board[i - 1][c];
						board[i - 1][c] = 0;
					}
				}

			}

		}

		return max;
	}

	public static int moveNorth() {
		int max = 0;

		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {

				if (board[r][c] > 0) {

					for (int i = 0; i < r; i++) {
						if (board[i][c] == 0) {
							board[i][c] = board[r][c];
							board[r][c] = 0;
							break;
						}
					}
				}
			}
		}

		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {

				max = Math.max(max, board[r][c]);

				if (board[r][c] == 0)
					break;

				int nr = r + 1;
				int nc = c;

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {

					if (board[nr][nc] != board[r][c])
						continue;

					board[r][c] += board[nr][nc];
					board[nr][nc] = 0;

					max = Math.max(max, board[r][c]);

					for (int i = nr; i < N - 1; i++) {
						board[i][c] = board[i + 1][c];
						board[i + 1][c] = 0;
					}
				}

			}

		}

		return max;
	}

}
