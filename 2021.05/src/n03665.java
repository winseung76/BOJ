import java.io.*;
import java.util.*;

public class n03665 {

	static int T;
	static int[] arr, indegree;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			indegree = new int[n + 1];
			List<Integer>[] v = new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				v[i] = new ArrayList<>();
			}

			String[] input = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(input[i - 1]);

				for (int j = 1; j < i; j++) {
					v[arr[j]].add(arr[i]);
					indegree[arr[i]]++;
				}
			}

			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");

				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);

				if (v[a].contains(b)) {
					v[a].remove((Integer) b);
					v[b].add(a);
					indegree[b]--;
					indegree[a]++;
				}

				else {
					v[b].remove((Integer) a);
					v[a].add(b);
					indegree[a]--;
					indegree[b]++;
				}
			}

			solve(n, v);
		}

		bw.flush();

	}

	public static void solve(int n, List<Integer>[] v) throws Exception {

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> res = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[arr[i]] == 0) {
				q.offer(arr[i]);
			}
		}

		while (!q.isEmpty()) {

			if (q.size() > 1) {
				bw.write("?\n");
				return;
			}

			int m = q.poll();

			res.offer(m);

			for (int d : v[m]) {
				indegree[d]--;
				if (indegree[d] == 0)
					q.offer(d);
			}
		}

		if (res.size() < n) {
			bw.write("IMPOSSIBLE\n");
			return;
		}
		while (!res.isEmpty()) {
			bw.write(res.poll() + " ");
		}
		bw.write("\n");
	}

}
