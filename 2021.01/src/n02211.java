import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n02211 {

	static int N, M;
	static int[] dist;
	static Vector<Pair>[] arr;
	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		dist = new int[N + 1];
		parent = new int[N + 1];
		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			arr[i] = new Vector<>();
		}

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int A = Integer.parseInt(sarr[0]);
			int B = Integer.parseInt(sarr[1]);
			int C = Integer.parseInt(sarr[2]);

			arr[A].add(new Pair(B, C));
			arr[B].add(new Pair(A, C));
		}
		dijkstra();

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (parent[i] != 0) {
				cnt++;
			}
		}
		bw.write(cnt + "\n");
		for (int i = 1; i <= N; i++) {
			if (parent[i] != 0) {
				bw.write(i + " " + parent[i] + "\n");
			}
		}

		bw.flush();

	}

	public static void dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[1] = 0;
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (Pair np : arr[pair.n]) {

				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					parent[np.n] = pair.n;
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
