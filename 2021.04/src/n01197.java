import java.io.*;
import java.util.*;

public class n01197 {

	static int V, E;
	static List<Pair>[] v;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);

		v = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			v[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
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

		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (visited[p.n])
				continue;

			sum += p.w;
			visited[p.n] = true;

			for (Pair np : v[p.n]) {
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
