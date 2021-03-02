import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class n01261 {

	static int[][] map;
	static int[][] dist;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		map = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		dijkstra(new Pos(0, 0, 0));
		bw.write(dist[N - 1][M - 1] + "\n");
		bw.flush();

	}

	public static void dijkstra(Pos start) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		dist[start.r][start.c] = start.w;
		PriorityQueue<Pos> pq = new PriorityQueue<>();

		pq.offer(start);

		while (!pq.isEmpty()) {

			Pos pos = pq.poll();

			if (dist[pos.r][pos.c] < pos.w)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];
				if ((0 <= nr && nr < N) && (0 <= nc && nc < M)) {
					if (dist[nr][nc] > dist[pos.r][pos.c] + map[nr][nc]) {
						dist[nr][nc] = dist[pos.r][pos.c] + map[nr][nc];
						pq.offer(new Pos(nr, nc, dist[nr][nc]));
					}
				}
			}
		}

	}

	static class Pos implements Comparable {
		int r, c, w;

		Pos(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Object o) {
			return w - ((Pos) o).w;
		}
	}
}
