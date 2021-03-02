import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n10282 {

	static Vector<Pair>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] sarr = br.readLine().split(" ");
			int n = Integer.parseInt(sarr[0]);
			int d = Integer.parseInt(sarr[1]);
			int c = Integer.parseInt(sarr[2]);

			arr = new Vector[n + 1];
			dist = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				arr[i] = new Vector<>();
				dist[i] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < d; i++) {
				sarr = br.readLine().split(" ");
				int a = Integer.parseInt(sarr[0]);
				int b = Integer.parseInt(sarr[1]);
				int s = Integer.parseInt(sarr[2]);

				arr[b].add(new Pair(a, s));

			}
			int time = dijkstra(c);
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] < Integer.MAX_VALUE)
					cnt++;
			}
			bw.write(cnt + " " + time + "\n");
		}
		bw.flush();

	}

	public static int dijkstra(int start) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int max = 0;

		dist[start] = 0;
		pq.offer(new Pair(start, dist[start]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			max = Math.max(max, dist[pair.n]);

			for (Pair np : arr[pair.n]) {

				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
				}
			}
		}
		return max;
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
