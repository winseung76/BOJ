import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class n01753 {

	static List<Pair>[] arr;
	static int[] dist;
	static int V, E, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);

		arr = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 0; i <= V; i++)
			arr[i] = new ArrayList<>();

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			int w = Integer.parseInt(s[2]);
			arr[u].add(new Pair(v, w));
		}
		dijkstra();

		for (int i = 1; i <= V; i++) {

			if (dist[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(dist[i] + "\n");
		}
		bw.flush();

	}

	public static void dijkstra() {

		Arrays.fill(dist, 0, V + 1, Integer.MAX_VALUE);
		dist[K] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		pq.add(new Pair(K, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (int i = 0; i < arr[pair.n].size(); i++) {
				Pair p = arr[pair.n].get(i);

				if (dist[p.n] > dist[pair.n] + p.w) {
					dist[p.n] = dist[pair.n] + p.w;
					pq.offer(new Pair(p.n, dist[p.n]));
				}
			}

		}

	}

	static class Pair implements Comparable {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Object o) {
			return w - ((Pair) o).w;
		}
	}

}
