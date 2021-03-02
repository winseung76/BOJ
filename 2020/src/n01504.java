import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01504 {

	static int N, E;
	static Vector<Pair>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);

		arr = new Vector[N + 1];
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new Vector<>();

		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		s = br.readLine().split(" ");
		int v1 = Integer.parseInt(s[0]);
		int v2 = Integer.parseInt(s[1]);

		int d1 = dijkstra(1, v1);
		int d2 = dijkstra(1, v2);
		int d3 = dijkstra(v1, v2);
		int d4 = dijkstra(v1, N);
		int d5 = dijkstra(v2, N);

		int res1, res2;

		if (d1 == Integer.MAX_VALUE || d3 == Integer.MAX_VALUE || d5 == Integer.MAX_VALUE)
			res1 = -1;
		else
			res1 = d1 + d3 + d5;

		if (d2 == Integer.MAX_VALUE || d3 == Integer.MAX_VALUE || d4 == Integer.MAX_VALUE)
			res2 = -1;
		else
			res2 = d2 + d3 + d4;

		if (res1 == -1 && res2 != -1)
			bw.write(res2 + "\n");
		else if (res1 != -1 && res2 == -1)
			bw.write(res1 + "\n");
		else if (res1 == -1 && res2 == -1)
			bw.write(res1 + "\n");
		else
			bw.write(Math.min(res1, res2) + "\n");

		bw.flush();

	}

	public static int dijkstra(int s, int e) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (dist[p.n] < p.w)
				continue;

			for (int i = 0; i < arr[p.n].size(); i++) {
				Pair np = arr[p.n].get(i);

				if (dist[np.n] > dist[p.n] + np.w) {
					dist[np.n] = dist[p.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
				}
			}
		}

		return dist[e];

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
