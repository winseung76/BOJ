import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n01012_¿Ø±‚≥ÛπË√ﬂ {
	private static int[] x = { 0, 0, 1, -1 };
	private static int[] y = { 1, -1, 0, 0 };
	private static int[][] graph;
	private static boolean[][] isvisited;
	private static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			graph = new int[N][M];
			isvisited = new boolean[N][M];
			res = 0;

			for (int j = 0; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[y][x] = 1;
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (graph[r][c] == 1 && !isvisited[r][c]) {
						res += bfs(r, c);
					}
				}
			}
			System.out.println(res);
		}

	}

	public static int bfs(int r, int c) {
		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(r, c));
		isvisited[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && graph[nr][nc] == 1) {
					if (!isvisited[nr][nc]) {
						q.offer(new Pair(nr, nc));
						isvisited[nr][nc] = true;
					}

				}
			}
		}
		return 1;
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
