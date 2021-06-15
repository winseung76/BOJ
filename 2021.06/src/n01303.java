import java.io.*;
import java.util.*;

public class n01303 {

	static int N, M;
	static char[][] board;
	static boolean[][] visited;
	static int W, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		board = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if (board[i][j] == 'W')
						W += bfs(new Pos(i, j));
					if (board[i][j] == 'B')
						B += bfs(new Pos(i, j));
				}
			}
		}

		bw.write(W + " " + B + "\n");
		bw.flush();

	}

	public static int bfs(Pos start) {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		int cnt = 0;

		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if ((0 <= nr && nr < M) && (0 <= nc && nc < N) && !visited[nr][nc]
						&& board[nr][nc] == board[start.r][start.c]) {
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		return cnt * cnt;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
