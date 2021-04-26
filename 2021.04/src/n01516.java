import java.io.*;
import java.util.*;

public class n01516 {

	static List<Integer>[] parent, v;
	static int[] time; // 건물별로 시간
	static int[] indegree; // 차수
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		parent = new ArrayList[N + 1];
		v = new ArrayList[N + 1];
		time = new int[N + 1];
		indegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			v[i] = new ArrayList<>();
			parent[i] = new ArrayList<>();
		}

		for (int n = 1; n <= N; n++) {
			String[] input = br.readLine().split(" ");

			int t = Integer.parseInt(input[0]);

			for (int i = 1; i < input.length - 1; i++) {
				int m = Integer.parseInt(input[i]);
				v[m].add(n);
				parent[n].add(m);
				indegree[n]++;
			}

			time[n] = t;
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < v[i].size(); j++) {
				System.out.print(v[i].get(j) + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < parent[i].size(); j++) {
				System.out.print(parent[i].get(j) + " ");
			}
			System.out.println();
		}

		solve();

		for (int i = 1; i <= N; i++) {
			bw.write(time[i] + "\n");
		}
		bw.flush();

	}

	public static void solve() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {

			int n = q.poll();

			int max = 0;
			for (int p : parent[n]) {
				max = Math.max(max, time[p]);
			}
			time[n] += max;

			for (int m : v[n]) {

				indegree[m]--;

				if (indegree[m] == 0)
					q.offer(m);

			}
		}
	}

}
