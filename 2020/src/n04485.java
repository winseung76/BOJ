import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n04485 {

	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					dist[i][j] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(s[j]);
			}

			dijkstra();

			bw.write("Problem " + (k++) + ": " + dist[N - 1][N - 1] + "\n");
		}
		bw.flush();
	}

	public static void dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		dist[0][0] = map[0][0];
		pq.offer(new Pair(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();
			visited[p.y][p.x] = true;

			for (int i = 0; i < 4; i++) {
				int nx = p.x + x[i];
				int ny = p.y + y[i];

				if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && !visited[ny][nx]) {
					if (dist[p.y][p.x] + map[ny][nx] < dist[ny][nx])
						dist[ny][nx] = dist[p.y][p.x] + map[ny][nx];

					pq.offer(new Pair(ny, nx, dist[ny][nx]));
				}
			}

		}
	}

	static class Pair implements Comparable {
		int x, y, w;

		Pair(int y, int x, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Object o) {
			return w - ((Pair) o).w;
		}
	}
}
