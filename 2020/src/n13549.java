import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class n13549 {

	static int N, K;
	static List<Pair>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		arr = new ArrayList[100001];
		dist = new int[100001];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length)
				arr[i].add(new Pair(i + 1, 1));
			if (i > 0)
				arr[i].add(new Pair(i - 1, 1));
			if (2 * i < arr.length)
				arr[i].add(new Pair(2 * i, 0));
		}
		bw.write(dijkstra() + "\n");
		bw.flush();

	}

	public static int dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[N] = 0;
		pq.offer(new Pair(N, dist[N]));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (int i = 0; i < arr[pair.n].size(); i++) {
				Pair np = arr[pair.n].get(i);

				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
				}
			}
		}
		return dist[K];
	}

	static class Pair implements Comparable<Pair> {
		int n;
		int w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return this.w - o.w;
		}
	}

}
