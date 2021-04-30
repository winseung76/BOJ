import java.io.*;
import java.util.*;

public class n02178 {

	static int N, M;
	static boolean[][] board;
	static int[][] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		board = new boolean[N + 1][M + 1];
		dist = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = (str.charAt(j - 1) == '1' ? true : false);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		dist[1][1] = 1;
		pq.offer(new Pair(new Pos(1, 1), dist[1][1]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();
			Pos p = pair.pos;

			if (dist[p.r][p.c] < pair.w)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= M) && board[nr][nc]
						&& dist[nr][nc] > dist[p.r][p.c] + 1) {
					dist[nr][nc] = dist[p.r][p.c] + 1;
					pq.offer(new Pair(new Pos(nr, nc), dist[nr][nc]));
				}
			}

		}

		return dist[N][M];
	}

	static class Pair implements Comparable<Pair> {

		Pos pos;
		int w;

		Pair(Pos pos, int w) {
			this.pos = pos;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			return w - o.w;
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
