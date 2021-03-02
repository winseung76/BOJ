import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class n01260_DFS¿ÍBFS {
	private static int[][] graph;
	private static int N, M, V;
	private static boolean[] isvisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new int[N][N];
		isvisited = new boolean[N];
		M = sc.nextInt();
		V = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x - 1][y - 1] = 1;
			graph[y - 1][x - 1] = 1;
		}
		Stack<Integer> s = new Stack<>();
		dfs(V, s);
		System.out.println();
		isvisited = new boolean[N];
		bfs(V);

	}

	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();

		isvisited[n - 1] = true;
		System.out.print(n + " ");
		q.offer(n);

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int y = 0; y < N; y++) {
				if (graph[x - 1][y] == 1) {
					if (isvisited[y] == false) {
						System.out.print(y + 1 + " ");
						isvisited[y] = true;
						q.offer(y + 1);
					}
				}
			}
		}
		System.out.println();
	}

	public static void dfs(int n, Stack<Integer> s) {

		isvisited[n - 1] = true;
		System.out.print(n + " ");
		s.push(n);

		while (!s.isEmpty()) {
			int x = s.pop();

			for (int y = 0; y < N; y++) {
				if (graph[x - 1][y] == 1) {
					if (isvisited[y] == false)
						dfs(y + 1, s);

				}
			}
		}

	}
}
