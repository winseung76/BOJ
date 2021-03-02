import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01197 {

	static int V, E;
	static Vector<Pair>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);
		arr = new Vector[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i <= V; i++)
			arr[i] = new Vector();

		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			arr[A].add(new Pair(B, C));
			arr[B].add(new Pair(A, C));
		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static long getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		long sum = 0;

		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			visited[pair.n] = true;
			sum += pair.w;

			for (Pair np : arr[pair.n]) {
				if (!visited[np.n])
					pq.offer(np);
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
