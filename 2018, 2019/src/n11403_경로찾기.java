import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n11403_경로찾기 {
	private static int[][] graph;
	private static boolean[] isvisited;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new int[N][N];
		isvisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				isvisited = new boolean[N];
				System.out.print(bfs(i, j) + " ");
			}
			System.out.println();
		}

	}

	public static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();

		isvisited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < N; i++) {
				if (graph[x][i] == 1) {
					if (i == end) {
						return 1;
					}
					if (!isvisited[i]) {
						isvisited[i] = true;
						q.offer(i);
					}
				}
			}

		}
		return 0;

	}
}
