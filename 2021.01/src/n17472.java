import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class n17472 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int num;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		visited = new boolean[N][M];
		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					bfs(new Pos(i, j), num);
					num++;
				}
			}
		}
		num--;
		dist = new int[num + 1][num + 1];

		for (int i = 0; i <= num; i++) {
			for (int j = 0; j <= num; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] > 0 && !visited[i][j]) {

					int n = map[i][j];
					findBridge(new Pos(i, j), n);

				}
			}
		}
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (dist[i][j] == Integer.MAX_VALUE)
					dist[i][j] = 0;
			}
		}

		int res = getMST();

		bw.write(res + "\n");
		bw.flush();
	}

	public static int getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[num + 1];
		int sum = 0;

		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;
			sum += pair.w;

			for (int i = 1; i <= num; i++) {
				if (0 < dist[pair.n][i] && dist[pair.n][i] < Integer.MAX_VALUE && !visited[i]) {
					pq.offer(new Pair(i, dist[pair.n][i]));
				}
			}

		}

		for (int i = 1; i <= num; i++) {
			if (!visited[i])
				return -1;
		}
		return sum;
	}

	public static void findBridge(Pos pos, int num) {

		int[] r = { 1, 0, -1, 0 };
		int[] c = { 0, 1, 0, -1 };

		visited[pos.r][pos.c] = true;

		for (int i = pos.r + 1; i < N; i++) {

			if (map[i][pos.c] == num)
				break;

			if (map[i][pos.c] > 0) {
				if (i - pos.r - 1 > 1) {
					int dest = map[i][pos.c];
					dist[num][dest] = Math.min(dist[num][dest], i - pos.r - 1);
				}
				break;
			}

		}

		for (int i = pos.r - 1; i >= 0; i--) {

			if (map[i][pos.c] == num)
				break;

			if (map[i][pos.c] > 0) {
				if (pos.r - i - 1 > 1) {
					int dest = map[i][pos.c];
					dist[num][dest] = Math.min(dist[num][dest], pos.r - i - 1);
				}
				break;
			}

		}

		for (int i = pos.c + 1; i < M; i++) {

			if (map[pos.r][i] == num)
				break;

			if (map[pos.r][i] > 0) {
				if (i - pos.c - 1 > 1) {
					int dest = map[pos.r][i];
					dist[num][dest] = Math.min(dist[num][dest], i - pos.c - 1);
				}
				break;
			}

		}

		for (int i = pos.c - 1; i >= 0; i--) {

			if (map[pos.r][i] == num)
				break;

			if (map[pos.r][i] > 0) {
				if (pos.c - i - 1 > 1) {
					int dest = map[pos.r][i];
					dist[num][dest] = Math.min(dist[num][dest], pos.c - i - 1);
				}
				break;
			}

		}

		for (int i = 0; i < 4; i++) {
			int nr = pos.r + r[i];
			int nc = pos.c + c[i];

			if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && !visited[nr][nc] && map[nr][nc] > 0) {
				findBridge(new Pos(nr, nc), num);
			}
		}
	}

	public static void bfs(Pos start, int num) {

		int[] r = { 1, 0, -1, 0 };
		int[] c = { 0, 1, 0, -1 };
		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		visited[start.r][start.c] = true;
		map[start.r][start.c] = num;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && map[nr][nc] > 0 && !visited[nr][nc]) {
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
					map[nr][nc] = num;
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

	static class Pair implements Comparable<Pair> {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			return w - o.w;
		}
	}

}
