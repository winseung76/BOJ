import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n02665 {

	static int N;
	static int[][] map;
	static int[][] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		bw.write(dijkstra() + "\n");
		bw.flush();

	}

	public static int dijkstra() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[0][0] = 0;
		pq.offer(new Pair(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (dist[pair.r][pair.c] > pair.w)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = pair.r + r[i];
				int nc = pair.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc & nc < N)) {
					if (map[nr][nc] == 0 && dist[nr][nc] > dist[pair.r][pair.c] + 1) {
						dist[nr][nc] = dist[pair.r][pair.c] + 1;
						pq.offer(new Pair(nr, nc, dist[nr][nc]));
					} else if (map[nr][nc] == 1 && dist[nr][nc] > dist[pair.r][pair.c]) {
						dist[nr][nc] = dist[pair.r][pair.c];
						pq.offer(new Pair(nr, nc, dist[nr][nc]));
					}
				}
			}

		}
		return dist[N - 1][N - 1];

	}

	static class Pair implements Comparable<Pair> {

		int r, c;
		int w;

		Pair(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return w - o.w;
		}

	}

}
