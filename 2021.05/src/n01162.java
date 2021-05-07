import java.io.*;
import java.util.*;

public class n01162 {

	static int N, M, K;
	static long[][] dist;
	static List<Pair>[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		dist = new long[N + 1][K + 1];
		v = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			v[a].add(new Pair(b, w));
			v[b].add(new Pair(a, w));
		}

		bw.write(dijkstra() + "\n");
		bw.flush();
	}

	public static long dijkstra() {

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i == 1)
					dist[i][j] = 0;
				else
					dist[i][j] = Long.MAX_VALUE;
			}
		}

		PriorityQueue<Pair2> pq = new PriorityQueue<>();
		for (int i = 0; i <= K; i++) {
			pq.offer(new Pair2(1, 0, i));
		}

		while (!pq.isEmpty()) {

			Pair2 pair = pq.poll();
			int k = pair.k;

			if (dist[pair.n][k] < pair.w)
				continue;

			for (Pair np : v[pair.n]) {

				if (dist[np.n][k] > dist[pair.n][k] + np.w) {
					dist[np.n][k] = dist[pair.n][k] + np.w;
					pq.offer(new Pair2(np.n, dist[np.n][k], k));
				}

				if (k < K && dist[np.n][k + 1] > dist[pair.n][k]+0) {
					dist[np.n][k + 1] = dist[pair.n][k];
					pq.offer(new Pair2(np.n, dist[np.n][k + 1], k + 1));
				}
			}
		}

		return dist[N][K];
	}

	static class Pair {

		int n;
		long w;

		Pair(int n, long w) {
			this.n = n;
			this.w = w;
		}
	}

	static class Pair2 implements Comparable<Pair2> {

		int n, k;
		long w;

		Pair2(int n, long w, int k) {
			this.n = n;
			this.w = w;
			this.k = k;
		}

		@Override
		public int compareTo(Pair2 o) {
			return (int) (w - o.w);
		}
	}
}
