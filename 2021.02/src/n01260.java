import java.io.*;
import java.util.*;

public class n01260 {

	static int N, M, V;
	static Vector<Integer>[] v; // 인접 리스트
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		V = Integer.parseInt(sarr[2]);

		v = new Vector[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]); // 5, 5
			int b = Integer.parseInt(sarr[1]); // 4, 2

			v[a].add(b);
			v[b].add(a);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(v[i]);

		dfs();
		bfs();
		bw.flush();

	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];

		q.offer(V);
		visited[V] = true;
		System.out.print(V + " ");

		while (!q.isEmpty()) {

			int n = q.poll();
			for (int node : v[n]) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
					System.out.print(node + " ");
				}
			}
		}
		System.out.println();
	}

	public static void dfs() {

		Stack<Integer> stack = new Stack<>();

		stack.push(V);
		visited[V] = true;
		System.out.print(V + " ");

		while (!stack.isEmpty()) {

			int n = stack.peek();

			boolean flag = false;

			for (int node : v[n]) {

				if (!visited[node]) {
					stack.push(node);
					visited[node] = true;
					System.out.print(node + " ");
					flag = true;
					break;
				}
			}

			if (!flag)
				stack.pop();
		}
		System.out.println();
	}

	public static void dfs(int n) {

		visited[n] = true;

		for (int node : v[n]) {
			if (!visited[node]) {
				dfs(node);
			}
		}
	}
}
