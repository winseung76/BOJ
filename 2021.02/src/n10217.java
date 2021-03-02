import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n10217 {

	static int T, N, M, K;
	static int[][] dp;
	static Vector<Pair>[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");
			N = Integer.parseInt(sarr[0]);
			M = Integer.parseInt(sarr[1]);
			K = Integer.parseInt(sarr[2]);

			arr = new Vector[N + 1];
			dp = new int[N + 1][M + 1];

			for (int j = 0; j <= N; j++) {
				for (int k = 0; k <= M; k++) {
					dp[j][k] = Integer.MAX_VALUE;
				}
			}
			for (int j = 0; j <= N; j++)
				arr[j] = new Vector<>();

			for (int j = 0; j < K; j++) {
				sarr = br.readLine().split(" ");
				int u = Integer.parseInt(sarr[0]);
				int v = Integer.parseInt(sarr[1]);
				int c = Integer.parseInt(sarr[2]);
				int d = Integer.parseInt(sarr[3]);

				arr[u].add(new Pair(v, d, c));
			}

			dijkstra();

			int min = Integer.MAX_VALUE;

			for (int j = 0; j <= M; j++) {
				min = Math.min(min, dp[N][j]);
			}

			if (min == Integer.MAX_VALUE)
				bw.write("Poor KCM\n");
			else
				bw.write(min + "\n");
		}
		bw.flush();

	}

	public static void dijkstra() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dp[1][0] = 0;
		pq.offer(new Pair(1, 0, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			for (Pair np : arr[pair.n]) {

				if (pair.c + np.c <= M && dp[np.n][pair.c + np.c] > dp[pair.n][pair.c] + np.w) {
					dp[np.n][pair.c + np.c] = dp[pair.n][pair.c] + np.w;
					pq.offer(new Pair(np.n, dp[np.n][pair.c + np.c], pair.c + np.c));
				}
			}

		}

	}

	static class Pair implements Comparable<Pair> {

		int n, w, c;

		Pair(int n, int w, int c) {
			this.n = n;
			this.w = w;
			this.c = c;
		}

		@Override
		public int compareTo(Pair o) {

			return w - o.w;
		}
	}

}
