import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class n01238_3 {

	static int N, M, X;

	static List<Pair>[] arr;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		X = Integer.parseInt(s[2]);

		arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int w = Integer.parseInt(s[2]);

			arr[a].add(new Pair(b, w));
		}

		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));

		bw.write(max + "\n");
		bw.flush();

	}

	public static int dijkstra(int s, int e) {

		dist = new int[N + 1];
		Arrays.fill(dist, 0, N + 1, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();
			int index = pair.n;

			if (dist[index] < pair.w)
				continue;

			for (int j = 0; j < arr[index].size(); j++) {
				Pair p = arr[index].get(j);

				if (dist[p.n] > dist[index] + p.w) {
					dist[p.n] = dist[index] + p.w;
					pq.offer(new Pair(p.n, dist[p.n]));
				}
			}
		}

		return dist[e];
	}

	static class Pair implements Comparable {

		int n;
		int w;

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
