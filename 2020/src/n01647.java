import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01647 {

	static int N, M;
	static Vector<Pair>[] arr;
	static int sum, max;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		visited = new boolean[N + 1];
		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new Vector();

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			arr[A].add(new Pair(B, C));
			arr[B].add(new Pair(A, C));
		}

		getMST();
		bw.write(sum - max + "\n");
		bw.flush();

	}

	public static void getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (visited[pair.n])
				continue;

			sum += pair.w;
			max = Math.max(max, pair.w);
			visited[pair.n] = true;

			for (Pair np : arr[pair.n]) {
				if (!visited[np.n])
					pq.offer(np);
			}

		}
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
