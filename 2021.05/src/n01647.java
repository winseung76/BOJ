import java.io.*;
import java.util.*;

public class n01647 {

	static int N, M;
	static List<Pair>[] v;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		v = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			v[A].add(new Pair(B, C));
			v[B].add(new Pair(A, C));
		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static int getMST() {

		int max = 0;
		int sum = 0;

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;
			sum += pair.w;
			max = Math.max(max, pair.w);

			for (Pair np : v[pair.n]) {
				if (!visited[np.n]) {
					pq.offer(np);
				}
			}
		}

		return sum - max;
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
