import java.io.*;
import java.util.*;

public class n14950 {

	static int N, M, t;
	static List<Pair>[] v;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		t = Integer.parseInt(input[2]);

		visited = new boolean[N + 1];
		v = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
		}

		cnt = N - 1;

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);

			v[A].add(new Pair(B, C + t * (N - 2)));
			v[B].add(new Pair(A, C + t * (N - 2)));
		}

		bw.write(prim() + "\n");
		bw.flush();

	}

	public static int prim() {

		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;

			if (pair.w != 0) {
				sum += pair.w - cnt * t;
			}
			cnt--;

			for (Pair np : v[pair.n]) {
				if (!visited[np.n]) {
					pq.offer(np);
				}
			}
		}

		return sum;
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
