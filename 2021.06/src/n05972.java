import java.io.*;
import java.util.*;

public class n05972 {

	static int N, M;
	static List<Pair>[] w;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		dist = new int[N + 1];
		w = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			w[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);

			w[A].add(new Pair(B, C));
			w[B].add(new Pair(A, C));

		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[1] = 0;
		pq.offer(new Pair(1, dist[1]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (pair.w > dist[pair.n])
				continue;
			
			for (Pair np : w[pair.n]) {
				if (dist[np.n] > dist[pair.n] + np.w) {
					dist[np.n] = dist[pair.n] + np.w;
					pq.offer(new Pair(np.n, dist[np.n]));
				}
			}
		}

		return dist[N];
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
