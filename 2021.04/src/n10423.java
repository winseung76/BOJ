import java.io.*;
import java.util.*;

public class n10423 {

	static int N, M, K;
	static List<Pair>[] V;
	static boolean[] visited, check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		V = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			V[i] = new ArrayList<>();
		}

		visited = new boolean[N + 1];
		check = new boolean[N + 1];

		input = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			check[Integer.parseInt(input[i])] = true;
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			V[u].add(new Pair(v, w));
			V[v].add(new Pair(u, w));

		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static int getMST() {

		int cnt = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (check[i])
				pq.offer(new Pair(i, 0));
		}

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (visited[p.n])
				continue;

			cnt += p.w;
			visited[p.n] = true;

			for (Pair np : V[p.n]) {
				if (!visited[np.n]) {
					pq.offer(np);
				}
			}
		}

		return cnt;
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
