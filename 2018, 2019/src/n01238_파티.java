import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n01238_ÆÄÆ¼ {
	private static int N, M, X;
	private static int[][] w;
	private static int[] total_time;
	private static int[] dist;
	private static int[][] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		w = new int[N][N];
		total_time = new int[N];
		dist = new int[N];
		res = new int[N][N];

		for (int i = 0; i < M; i++)
			w[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt();

		for (int i = 0; i < N; i++) {
			dist[i] = 0;
			for (int j = 0; j < N; j++) {
				if (j != i)
					dist[j] = Integer.MAX_VALUE;
			}

			dijkstra(i);
		}

		for (int i = 0; i < N; i++)
			total_time[i] = res[i][X - 1] + res[X - 1][i];

		Arrays.sort(total_time);
		System.out.println(total_time[N - 1]);

	}

	public static void dijkstra(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(start);

		while (!q.isEmpty()) {
			int n = q.poll();

			for (int i = 0; i < N; i++) {
				if (w[n][i] > 0 && dist[i] > w[n][i] + dist[n]) {
					dist[i] = w[n][i] + dist[n];
					q.offer(i);
				}

			}
		}

		for (int i = 0; i < N; i++)
			res[start][i] = dist[i];
	}
}
