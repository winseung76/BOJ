import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n07569_≈‰∏∂≈‰ {
	private static boolean[][][] isvisited;
	private static int res;
	private static int M, N, H;
	private static Queue<Pos> q = new LinkedList<>();
	private static int[][][] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);

		graph = new int[H][N][M];
		isvisited = new boolean[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				String[] s = br.readLine().split(" ");
				for (int m = 0; m < M; m++) {
					graph[h][n][m] = Integer.parseInt(s[m]);
					if (graph[h][n][m] == 1)
						q.add(new Pos(n, m, h, 0));
				}
			}
		}
		bfs();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {

					if (graph[h][n][m] == 0)
						res = -1;
				}
			}
		}
		bw.write(res + "\n");
		bw.flush();

	}

	public static void bfs() {

		int[] n = { 1, -1, 0, 0, 0, 0 };
		int[] m = { 0, 0, 1, -1, 0, 0 };
		int[] h = { 0, 0, 0, 0, 1, -1 };

		while (!q.isEmpty()) {

			Pos p = q.poll();
			res = Math.max(res, p.count);

			for (int i = 0; i < 6; i++) {
				int new_n = p.n + n[i];
				int new_m = p.m + m[i];
				int new_h = p.h + h[i];

				if (0 <= new_h && new_h < H && 0 <= new_n && new_n < N && 0 <= new_m && new_m < M) {
					if (graph[new_h][new_n][new_m] == 0 && !isvisited[new_h][new_n][new_m]) {
						q.add(new Pos(new_n, new_m, new_h, p.count + 1));
						isvisited[new_h][new_n][new_m] = true;
						graph[new_h][new_n][new_m] = 1;
					}
				}

			}
		}

	}

	static class Pos {
		int m, n, h;
		int count;

		public Pos(int n, int m, int h, int count) {
			this.m = m;
			this.n = n;
			this.h = h;
			this.count = count;
		}

	}
}
