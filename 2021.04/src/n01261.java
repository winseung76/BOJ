import java.io.*;
import java.util.*;

public class n01261 {

	static int M, N;
	static int[][] board;
	static int[][] dist;
	static int[] r = { 0, 1, 0, -1 };
	static int[] c = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		board = new int[N + 1][M + 1];
		dist = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = str.charAt(j - 1) == '0' ? 0 : 1;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		int res = dijkstra(1, 1, N, M);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}

		bw.write(res + "\n");
		bw.flush();

	}

	public static int dijkstra(int sr, int sc, int er, int ec) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[sr][sc] = 0;
		pq.offer(new Pair(sr, sc, dist[sr][sc]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.r][pair.c] < pair.w)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = pair.r + r[i];
				int nc = pair.c + c[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= M)) {

					if (dist[nr][nc] > dist[pair.r][pair.c] + board[nr][nc]) {
						dist[nr][nc] = dist[pair.r][pair.c] + board[nr][nc];
						pq.offer(new Pair(nr, nc, dist[nr][nc]));
					}
				}
			}

		}

		return dist[N][M];

	}

	static class Pair implements Comparable<Pair> {

		int r, c, w;

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
