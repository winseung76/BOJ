import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01854 {

	static int n, m, k;
	static Vector<Pair>[] arr;
	static PriorityQueue<Integer>[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);

		dist = new PriorityQueue[n + 1];
		arr = new Vector[n + 1];

		for (int i = 0; i <= n; i++) {
			dist[i] = new PriorityQueue<>(k, Collections.reverseOrder());
			arr[i] = new Vector<>();
		}

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			arr[a].add(new Pair(b, c));
		}

		dijkstra();

		for (int i = 1; i <= n; i++) {
			if (dist[i].size() == k)
				bw.write(dist[i].peek() + "\n");
			else
				bw.write(-1 + "\n");

		}

		bw.flush();

	}

	public static void dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[1].offer(0);
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			for (Pair np : arr[pair.n]) {

				int nw = pair.w + np.w;

				if (dist[np.n].size() < k) {
					dist[np.n].offer(nw);
					pq.offer(new Pair(np.n, nw));
				}

				else if (dist[np.n].size() == k) {
					if (dist[np.n].peek() > nw) {
						dist[np.n].poll();
						dist[np.n].offer(nw);
						pq.offer(new Pair(np.n, nw));
					}
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
