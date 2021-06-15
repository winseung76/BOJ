import java.io.*;
import java.util.*;

public class n03187 {

	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static int sheep, wolf;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		board = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);

				if (board[i][j] == 'k')
					sheep++;
				if (board[i][j] == 'v')
					wolf++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && board[i][j] != '#') {
					bfs(new Pos(i, j));
				}
			}
		}

		bw.write(sheep + " " + wolf + "\n");
		bw.flush();

	}

	public static void bfs(Pos start) {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int v = 0;
		int k = 0;
		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		visited[start.r][start.c] = true;
		if (board[start.r][start.c] == 'k')
			k++;
		if (board[start.r][start.c] == 'v')
			v++;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && !visited[nr][nc] && board[nr][nc] != '#') {
					if (board[nr][nc] == 'v')
						v++;
					if (board[nr][nc] == 'k')
						k++;

					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		if (k <= v)
			sheep -= k;
		else
			wolf -= v;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
