import java.io.*;
import java.util.*;

public class n14621 {

	static int N, M;
	static int[] kind;
	static List<Pair>[] V;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		kind = new int[N + 1];
		V = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			kind[i] = input[i - 1].equals("W") ? 0 : 1;
			V[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int d = Integer.parseInt(input[2]);
			V[u].add(new Pair(v, d));
			V[v].add(new Pair(u, d));
		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static int getMST() {

		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;
			sum += pair.w;

			for (Pair np : V[pair.n]) {
				if (kind[np.n] != kind[pair.n] && !visited[np.n]) {
					pq.offer(np);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return -1;
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
