import java.io.*;
import java.util.*;

public class n02580 {

	static int[][] board = new int[9][9];
	static List<Pos> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(sarr[j]);
				if (board[i][j] == 0)
					list.add(new Pos(i, j));
			}
		}

		solve(0);

	}

	public static boolean solve(int idx) {

		if (idx == list.size()) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}

			return true;
		}

		Pos pos = list.get(idx);
		int row = pos.r;
		int col = pos.c;

		for (int n = 1; n <= 9; n++) {
			if (check(row, col, n)) {

				board[row][col] = n;

				if (solve(idx + 1))
					return true;

				board[row][col] = 0;
			}
		}

		return false;
	}

	public static boolean check(int row, int col, int n) {

		int sr = 3 * (row / 3);
		int sc = 3 * (col / 3);

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (board[i][j] == n)
					return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == n)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board[i][col] == n)
				return false;
		}

		return true;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
