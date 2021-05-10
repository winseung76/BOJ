import java.io.*;
import java.util.*;

public class n14496 {

	static int N, M;
	static int start, end;
	static int[] dist;
	static List<Integer>[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		dist = new int[N + 1];
		v = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			v[a].add(b);
			v[b].add(a);
		}

		bw.write(dijkstra() + "\n");
		bw.flush();

	}

	public static int dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Pair(start, dist[start]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (int n : v[pair.n]) {
				if (dist[n] > dist[pair.n] + 1) {
					dist[n] = dist[pair.n] + 1;
					pq.offer(new Pair(n, dist[n]));
				}
			}
		}

		if (dist[end] == Integer.MAX_VALUE)
			return -1;

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
