import java.io.*;
import java.util.*;

public class n02056 {

	static int N;
	static Vector<Integer>[] v;
	static int[] indegree, time, total;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		v = new Vector[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new Vector<>();
		}

		indegree = new int[N + 1];
		time = new int[N + 1];
		total = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			int t = Integer.parseInt(input[0]);
			int cnt = Integer.parseInt(input[1]);

			time[i] = t;

			for (int j = 0; j < cnt; j++) {
				int n = Integer.parseInt(input[2 + j]);
				v[n].add(i);
				indegree[i]++;
			}
		}

		solve();

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, total[i]);
		}

		bw.write(max + "\n");
		bw.flush();

	}

	public static void solve() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				total[i] = time[i];
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {

			int n = q.poll();

			for (int m : v[n]) {
				indegree[m]--;
				total[m] = Math.max(total[m], total[n]);

				if (indegree[m] == 0) {
					total[m] += time[m];
					q.offer(m);
				}
			}
		}

	}

}
