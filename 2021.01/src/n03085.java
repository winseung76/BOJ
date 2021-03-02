import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n03085 {

	static int N;
	static char[][] board;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				board[i][j] = str.charAt(j);
		}

		solve();

		bw.write(max + "\n");
		bw.flush();

	}

	public static void check() {

		for (int k = 0; k < N; k++) {
			int cnt = 1;
			for (int s = 1; s < N; s++) {
				if (board[k][s] == board[k][s - 1])
					cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
		for (int s = 0; s < N; s++) {
			int cnt = 1;
			for (int k = 1; k < N; k++) {
				if (board[k][s] == board[k - 1][s])
					cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
	}

	public static void solve() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char tmp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = tmp;

				check();

				tmp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = tmp;
			}
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				char tmp = board[i][j];
				board[i][j] = board[i + 1][j];
				board[i + 1][j] = tmp;

				check();

				tmp = board[i][j];
				board[i][j] = board[i + 1][j];
				board[i + 1][j] = tmp;
			}
		}

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
