import java.io.*;
import java.util.*;

public class n13565 {

	static int M, N;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		board = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			if (board[0][i] == 0 && !visited[0][i]) {
				if (bfs(new Pos(0, i))) {
					bw.write("YES\n");
					bw.flush();
					return;
				}
			}
		}

		bw.write("NO\n");
		bw.flush();
	}

	public static boolean bfs(Pos start) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			if (pos.r == M - 1)
				return true;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < M) && (0 <= nc && nc < N) && !visited[nr][nc] && board[nr][nc] == 0) {
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}

		}

		return false;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
