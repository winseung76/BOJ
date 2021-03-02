import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01726 {

	static int M, N;
	static int[][] map;
	static Pos start, end;
	static int[][][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		M = Integer.parseInt(sarr[0]);
		N = Integer.parseInt(sarr[1]);

		map = new int[M + 1][N + 1];
		visited = new int[M + 1][N + 1][5];

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= 4; k++)
					visited[i][j][k] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i <= M; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}
		sarr = br.readLine().split(" ");
		start = new Pos(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[1]), Integer.parseInt(sarr[2]));
		sarr = br.readLine().split(" ");
		end = new Pos(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[1]), Integer.parseInt(sarr[2]));

		bfs();

		bw.write(min + "\n");
		bw.flush();

	}

	public static void bfs() {

		int[] dr = { 0, 0, 0, 1, -1 };
		int[] dc = { 0, 1, -1, 0, 0 };
		Queue<Pair> q = new LinkedList<>();

		visited[start.r][start.c][start.d] = 0;
		q.offer(new Pair(start, 0));

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			if (pos.r == end.r && pos.c == end.c && pos.d == end.d) {
				min = Math.min(min, visited[end.r][end.c][end.d]);
				continue;
			}

			// 앞으로 이동하는 명령
			int nr = pos.r + dr[pos.d];
			int nc = pos.c + dc[pos.d];
			int cnt = 0;
			while (cnt < 3) {

				if ((1 <= nr && nr <= M) && (1 <= nc && nc <= N) && map[nr][nc] == 0) {

					if (visited[nr][nc][pos.d] > pair.cnt + 1) {
						visited[nr][nc][pos.d] = pair.cnt + 1;
						q.offer(new Pair(new Pos(nr, nc, pos.d), pair.cnt + 1));
					}

					nr += dr[pos.d];
					nc += dc[pos.d];
					cnt++;
				} else
					break;

			}

			// 다른 방향으로 회전하는 명령
			int[] d = new int[2];

			switch (pos.d) {
			case 1:
			case 2:
				d[0] = 3;
				d[1] = 4;
				break;
			case 3:
			case 4:
				d[0] = 1;
				d[1] = 2;
				break;
			}

			for (int i = 0; i < 2; i++) {

				if (visited[pos.r][pos.c][d[i]] > pair.cnt + 1) {
					visited[pos.r][pos.c][d[i]] = pair.cnt + 1;
					q.offer(new Pair(new Pos(pos.r, pos.c, d[i]), pair.cnt + 1));
				}
			}

		}
	}

	static class Pos {

		int r, c, d;

		Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static class Pair {

		Pos pos;
		int cnt;

		Pair(Pos pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}

	}

}
