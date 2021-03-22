import java.io.*;

public class n09663 {

	static boolean[][] board;
	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N]; // 퀸이 있으면 true, 없으면 false

		solve(0);

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void solve(int row) {

		if (row == N) {
			cnt++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (check(row, col)) {
				board[row][col] = true;
				solve(row + 1);
				board[row][col] = false;
			}
		}

	}

	public static boolean check(int r, int c) {

		int idx = 1;
		for (int i = r - 1; i >= 0; i--) {
			if (board[i][c])
				return false;
			if (c - idx >= 0 && board[i][c - idx])
				return false;
			if (c + idx < N && board[i][c + idx])
				return false;
			idx++;
		}

		return true;

	}
}
