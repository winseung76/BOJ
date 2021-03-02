import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

public class n09370 {

	static int n;
	static Vector<Pair>[] arr;
	static int[] dist;
	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");
			n = Integer.parseInt(sarr[0]);
			int m = Integer.parseInt(sarr[1]);
			int t = Integer.parseInt(sarr[2]);

			arr = new Vector[n + 1];
			dist = new int[n + 1];
			parent = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				arr[j] = new Vector<>();
			}

			sarr = br.readLine().split(" ");
			int s = Integer.parseInt(sarr[0]);
			int g = Integer.parseInt(sarr[1]);
			int h = Integer.parseInt(sarr[2]);

			for (int j = 0; j < m; j++) {
				sarr = br.readLine().split(" ");
				int a = Integer.parseInt(sarr[0]);
				int b = Integer.parseInt(sarr[1]);
				int d = Integer.parseInt(sarr[2]);

				arr[a].add(new Pair(b, d));
				arr[b].add(new Pair(a, d));
			}

			int d1 = dijkstra(s, g);
			int d2 = dijkstra(s, h);

			Vector<Integer> list = new Vector<>();
			for (int j = 0; j < t; j++) {
				int x = Integer.parseInt(br.readLine());

				if (d1 < d2) {
					if (dijkstra(s, h) + dijkstra(h, x) == dijkstra(s, x))
						list.add(x);
				} else if (d1 > d2) {
					if (dijkstra(s, g) + dijkstra(g, x) == dijkstra(s, x))
						list.add(x);
				}
			}
			Collections.sort(list);
			for (int j = 0; j < list.size(); j++)
				bw.write(list.get(j) + " ");
			bw.write("\n");

		}
		bw.flush();

	}

	public static int dijkstra(int start, int end) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int j = 0; j <= n; j++) {
			dist[j] = Integer.MAX_VALUE;
		}

		dist[start] = 0;
		pq.offer(new Pair(start, dist[start]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (Pair np : arr[pair.n]) {

				if (dist[np.n] > dist[pair.n] + np.w) {

					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
					parent[np.n] = pair.n;
				}
			}

		}

		return dist[end];
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
