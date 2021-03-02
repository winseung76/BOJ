import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01922 {

	static int N, M;
	static Vector<Pair>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new Vector[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++)
			graph[i] = new Vector();

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);

			if (a != b) {
				graph[a].add(new Pair(b, c));
				graph[b].add(new Pair(a, c));
			}
		}

		bw.write(getMST(1) + "\n");
		bw.flush();

	}

	public static int getMST(int s) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int sum = 0;

		pq.offer(new Pair(s, 0));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;
			sum += pair.w;

			for (Pair p : graph[pair.n]) {
				if (!visited[p.n])
					pq.offer(p);
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
