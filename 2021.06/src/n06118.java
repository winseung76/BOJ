import java.io.*;
import java.util.*;

public class n06118 {

	static int N, M;
	static List<Integer>[] w;
	static int[] dist;
	static int d, cnt, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		w = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			w[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			w[a].add(b);
			w[b].add(a);
		}

		solve();

		for (int i = 1; i <= N; i++) {
			if (dist[i] == d) {
				cnt++;
				min = Math.min(min, i);
			}
		}

		bw.write(min + " " + d + " " + cnt);
		bw.flush();

	}

	public static void solve() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));
		dist[1] = 0;

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (pair.w > dist[pair.n])
				continue;

			for (int n : w[pair.n]) {
				if (dist[n] > dist[pair.n] + 1) {
					dist[n] = dist[pair.n] + 1;
					pq.offer(new Pair(n, dist[n]));
					d = Math.max(d, dist[n]);
				}
			}
		}
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
