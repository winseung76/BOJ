import java.io.*;
import java.util.*;

public class n01922 {

	static int N, M;
	static List<Pair>[] v;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		v = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);

			v[a].add(new Pair(b, c));
			v[b].add(new Pair(a, c));
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (!visited[p.n]) {

				visited[p.n] = true;
				sum += p.w;

				for (Pair np : v[p.n]) {
					if (!visited[np.n]) {
						pq.offer(np);
					}
				}
			}
		}

		return sum;

	}

	static class Pair implements Comparable<Pair> {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			return w - o.w;
		}
	}
}
