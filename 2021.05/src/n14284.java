import java.io.*;
import java.util.*;

public class n14284 {

	static int n, m, s, t;
	static List<Pair>[] v;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		v = new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			v[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			v[a].add(new Pair(b, w));
			v[b].add(new Pair(a, w));
		}

		input = br.readLine().split(" ");
		s = Integer.parseInt(input[0]);
		t = Integer.parseInt(input[1]);

		bw.write(dijkstra() + "\n");
		bw.flush();

	}

	public static int dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (Pair np : v[pair.n]) {
				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
				}
			}
		}

		return dist[t];

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
