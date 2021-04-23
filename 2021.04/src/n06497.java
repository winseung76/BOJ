import java.io.*;
import java.util.*;

public class n06497 {

	static int m, n;
	static List<Pair>[] v;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] input = br.readLine().split(" ");
			m = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);

			if (m == 0 && n == 0)
				break;

			visited = new boolean[m];
			v = new ArrayList[m];

			for (int i = 0; i < m; i++) {
				v[i] = new ArrayList<>();
			}

			int total = 0;

			for (int i = 0; i < n; i++) {
				input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				int z = Integer.parseInt(input[2]);

				v[x].add(new Pair(y, z));
				v[y].add(new Pair(x, z));
				total += z;
			}

			int res = total - getMST();

			bw.write(res + "\n");
		}
		bw.flush();

	}

	public static int getMST() {

		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (!visited[pair.n]) {

				visited[pair.n] = true;
				sum += pair.w;

				for (Pair np : v[pair.n]) {
					if (!visited[np.n]) {
						pq.offer(np);
					}
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
