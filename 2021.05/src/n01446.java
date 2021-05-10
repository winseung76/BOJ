import java.io.*;
import java.util.*;

public class n01446 {

	static int N, D;
	static List<Pair>[] v;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		D = Integer.parseInt(input[1]);

		dist = new int[D + 1];
		v = new ArrayList[D + 1];
		for (int i = 0; i <= D; i++) {
			v[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
			if (i != D)
				v[i].add(new Pair(i + 1, 1));
		}

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			if (b - a > w && a <= D && b <= D) {
				boolean flag = false;
				for (Pair p : v[a]) {
					if (p.n == b) {
						p.w = Math.min(p.w, w);
						flag = true;
						break;
					}
				}
				if (!flag)
					v[a].add(new Pair(b, w));
			}
		}

		bw.write(dijkstra() + "\n");
		bw.flush();

	}

	public static int dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[0] = 0;
		pq.offer(new Pair(0, dist[0]));

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

		return dist[D];
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
