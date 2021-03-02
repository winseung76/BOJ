import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01743 {

	static int N, M, K;
	static int[][] board;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		board = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			sarr = br.readLine().split(" ");
			int r = Integer.parseInt(sarr[0]);
			int c = Integer.parseInt(sarr[1]);
			board[r][c] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				if (board[i][j] == 1 && !visited[i][j]) {
					int res = bfs(new Pos(i, j));
					max = Math.max(max, res);
				}

			}
		}

		bw.write(max + "\n");
		bw.flush();

	}

	public static int bfs(Pos start) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		int cnt = 0;

		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= M) && board[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new Pos(nr, nc));

					visited[nr][nc] = true;
				}
			}
		}

		return cnt;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
