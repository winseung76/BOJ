import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n15686 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Vector<Pos> list = new Vector<>();
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 2)
					list.add(new Pos(i, j));

			}
		}

		comb(0, 0);

		bw.write(res + "\n");
		bw.flush();

	}

	public static int bfs(Pos pos) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		visited = new boolean[N + 1][N + 1];

		q.offer(pos);
		visited[pos.r][pos.c] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + r[i];
				int nc = p.c + c[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && !visited[nr][nc]) {

					if (map[nr][nc] == 2) {
						return Math.abs(pos.r - nr) + Math.abs(pos.c - nc);
					}

					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		return 0;

	}

	public static void comb(int cnt, int idx) {

		if (cnt == list.size() - M) {
			int dist = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1)
						dist += bfs(new Pos(i, j));
				}
			}

			res = Math.min(res, dist);
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			Pos pos = list.get(i);

			map[pos.r][pos.c] = 0;
			comb(cnt + 1, i + 1);
			map[pos.r][pos.c] = 2;
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
