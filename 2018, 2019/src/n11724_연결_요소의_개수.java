import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n11724_연결_요소의_개수 {
	private static int N, M;
	private static int[][] graph;
	private static boolean[] isvisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N][N];
		isvisited = new boolean[N];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u - 1][v - 1] = 1;
			graph[v - 1][u - 1] = 1;
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!isvisited[i])
				cnt += bfs(i);
		}
		System.out.println(cnt);
	}

	public static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(n);
		isvisited[n] = true;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < N; i++) {
				if (graph[x][i] == 1 && !isvisited[i]) {
					q.offer(i);
					isvisited[i] = true;
				}
			}
		}

		return 1;
	}
}
