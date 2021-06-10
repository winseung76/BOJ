import java.io.*;
import java.util.*;

public class n14716 {

	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		board = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					bfs(new Pos(i, j));
					cnt++;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void bfs(Pos start) {

		int[] dr = { 0, 1, 0, -1, 1, 1, -1, -1 };
		int[] dc = { 1, 0, -1, 0, 1, -1, 1, -1 };

		Queue<Pos> q = new LinkedList<>();
		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if ((0 <= nr && nr < M) && (0 <= nc && nc < N) && !visited[nr][nc] && board[nr][nc] == 1) {
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
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
