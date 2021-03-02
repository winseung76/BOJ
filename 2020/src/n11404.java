import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n11404 {

	static int n, m;
	static Vector<Pair>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dist = new int[n + 1];
		arr = new Vector[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new Vector();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);

			boolean flag = false;
			for (Pair p : arr[a]) {
				if (p.n == b) {
					flag = true;

					if (p.w > c) {
						arr[a].remove(p);
						arr[a].add(new Pair(b, c));
					}
					break;
				}
			}
			if (!flag)
				arr[a].add(new Pair(b, c));
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dist[j] = Integer.MAX_VALUE;

			dijkstra(i);
			for (int j = 1; j <= n; j++) {
				if (dist[j] == Integer.MAX_VALUE)
					dist[j] = 0;
				bw.write(dist[j] + " ");
			}

			bw.write("\n");
		}
		bw.flush();

	}

	public static void dijkstra(int s) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (Pair np : arr[pair.n]) {
				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
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
