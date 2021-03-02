import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n07576_≈‰∏∂≈‰ {
	private static int[][] graph;
	private static int N, M;
	private static int max = 0;
	private static ArrayList<Pair> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int x = sc.nextInt();
				graph[i][j] = x;
				if (graph[i][j] == 1)
					list.add(new Pair(i, j, 0));
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(max);

	}

	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			q.offer(new Pair(pair.n, pair.m, 0));
		}

		while (!q.isEmpty()) {

			Pair p = q.poll();
			max = Math.max(max, p.count);

			for (int i = 0; i < 4; i++) {
				int nx = p.m + x[i];
				int ny = p.n + y[i];

				if (0 <= nx && nx < M && 0 <= ny && ny < N && graph[ny][nx] == 0) {
					graph[ny][nx] = 1;
					q.offer(new Pair(ny, nx, p.count + 1));

				}
			}

		}
	}

	static class Pair {
		int n, m, count;

		Pair(int n, int m, int count) {
			this.m = m;
			this.n = n;
			this.count = count;
		}
	}
}
