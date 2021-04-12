import java.io.*;
import java.util.*;

public class n01766 {

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

		v = new Vector[N + 1];
		indegree = new int[N + 1];
		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			v[A].add(B);
			indegree[B]++;
		}

		solve();

		bw.write(sb.toString() + "\n");
		bw.flush();

	}

	public static void solve() {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				pq.offer(i);
		}

		while (!pq.isEmpty()) {

			int n = pq.poll();

			sb.append(n + " ");

			for (int m : v[n]) {
				indegree[m]--;
				if (indegree[m] == 0)
					pq.offer(m);
			}
		}
	}

}
