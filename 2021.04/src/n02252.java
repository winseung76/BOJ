import java.io.*;
import java.util.*;

public class n02252 {

	static int N, M;
	static Vector<Integer>[] v;
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		indegree = new int[N + 1];
		v = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			indegree[B]++;
			v[A].add(B);
		}

		solve();

		bw.write(sb.toString() + "\n");
		bw.flush();

	}

	public static void solve() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {

			int n = q.poll();

			sb.append(n + " ");

			for (int m : v[n]) {

				indegree[m]--;

				if (indegree[m] == 0) {
					q.offer(m);
				}
			}
		}
	}

}
