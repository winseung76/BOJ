import java.io.*;
import java.util.*;

public class n02206 {

	static int N, M;
	static int[][] board;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		board = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = str.charAt(j - 1) - '0';
			}
		}

		bw.write(bfs() + "\n");
		bw.flush();

	}

	public static int bfs() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		Queue<Pair> q = new LinkedList<>();

		Pos start = new Pos(1, 1);
		q.offer(new Pair(start, false, 1));
		visited[1][1][0] = true;

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			if (pos.r == N && pos.c == M) {
				return pair.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= M)) {
					if (board[nr][nc] == 0) {
						if (pair.flag && !visited[nr][nc][1]) {
							q.offer(new Pair(new Pos(nr, nc), pair.flag, pair.cnt + 1));
							visited[nr][nc][1] = true;
						} else if (!pair.flag && !visited[nr][nc][0]) {
							q.offer(new Pair(new Pos(nr, nc), pair.flag, pair.cnt + 1));
							visited[nr][nc][0] = true;
						}
					}

					else if (board[nr][nc] == 1 && !pair.flag && !visited[nr][nc][1]) {
						q.offer(new Pair(new Pos(nr, nc), true, pair.cnt + 1));
						visited[nr][nc][1] = true;
					}
				}
			}
		}

		return -1;

	}

	static class Pair {

		boolean flag;
		Pos pos;
		int cnt;

		Pair(Pos pos, boolean flag, int cnt) {
			this.pos = pos;
			this.flag = flag;
			this.cnt = cnt;
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
