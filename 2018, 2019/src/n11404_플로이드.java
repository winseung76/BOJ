import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n11404_플로이드 {
	private static boolean[] isvisited;
	private static int n;
	private static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		graph = new int[n][n];
		int min;
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (graph[a - 1][b - 1] == 0)
				min = c;
			else
				min = Math.min(graph[a - 1][b - 1], c);
			graph[a - 1][b - 1] = min;

		}
		for (int i = 0; i < n; i++) {
			isvisited = new boolean[n];
			for (int j = 0; j < n; j++) {
				System.out.print(bfs(i, j) + " ");
			}
			System.out.println();
		}

	}

	public static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList();
		int min = 0;
		int node;
		isvisited[start] = true;
		q.offer(start);
		int w = 0;
		while (!q.isEmpty()) {
			node = q.poll();

			for (int i = 0; i < n; i++) {
				if (graph[node][i] > 0 && !isvisited[i]) {
					w += graph[node][i];
					isvisited[i] = true;
					q.offer(i);
					if (i == end && graph[node][i] > 0) {
						if (min == 0)
							min = w;
						else
							min = Math.min(min, w);
						w = 0;
						// isvisited = new boolean[n];
					}
				}
			}
		}
		return min;
	}
}
