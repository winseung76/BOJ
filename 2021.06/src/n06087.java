import java.io.*;
import java.util.*;

public class n06087 {

	static int W, H;
	static char[][] board;
	static int[][] check;
	static Pos start, end;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);

		board = new char[H][W];
		check = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				check[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				board[i][j] = str.charAt(j);

				if (board[i][j] == 'C') {
					if (start == null)
						start = new Pos(i, j);
					else
						end = new Pos(i, j);
				}
			}
		}

		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (check[i][j] == Integer.MAX_VALUE)
					System.out.print("F ");
				else
					System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}

		bw.write(check[end.r][end.c] + "\n");
		bw.flush();

	}

	public static void bfs() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(start, 0, -1));

		check[start.r][start.c] = 0;

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			if (pos.r == end.r && pos.c == end.c) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < H) && (0 <= nc && nc < W) && board[nr][nc] != '*') {

					int cnt = pair.cnt;

					if (pair.d != i && pos != start)
						cnt = cnt + 1;

					if (check[nr][nc] >= cnt) {
						q.offer(new Pair(new Pos(nr, nc), cnt, i));
						check[nr][nc] = cnt;
					}
				}
			}
		}

	}

	static class Pos {

		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Pair {

		Pos pos;
		int d, cnt;

		Pair(Pos pos, int cnt, int d) {
			this.pos = pos;
			this.cnt = cnt;
			this.d = d;
		}
	}

}
