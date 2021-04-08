import java.io.*;
import java.util.*;

public class n12852 {

	static int N;
	static int[] visited, parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		visited = new int[N + 1];
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++)
			visited[i] = Integer.MAX_VALUE;

		visited[N] = 0;

		bfs(N);

		bw.write(visited[1] + "\n");

		List<Integer> list = new ArrayList<>();
		list.add(1);
		for (int i = 1; i < N; i = parent[i])
			list.add(parent[i]);

		for (int i = list.size() - 1; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.flush();

	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();

		q.offer(start);

		while (!q.isEmpty()) {

			int n = q.poll();

			if (n == 1) {
				return;
			}

			if (n % 3 == 0 && visited[n / 3] > visited[n] + 1) {
				visited[n / 3] = visited[n] + 1;
				parent[n / 3] = n;
				q.offer(n / 3);
			}

			if (n % 2 == 0 && visited[n / 2] > visited[n] + 1) {
				visited[n / 2] = visited[n] + 1;
				parent[n / 2] = n;
				q.offer(n / 2);
			}

			if (n - 1 >= 1 && visited[n - 1] > visited[n] + 1) {
				visited[n - 1] = visited[n] + 1;
				parent[n - 1] = n;
				q.offer(n - 1);
			}

		}

	}
}
