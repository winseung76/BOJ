import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01197_2 {

	static int V, E;
	static Pair[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		V = Integer.parseInt(s[0]);
		E = Integer.parseInt(s[1]);
		arr = new Pair[E];

		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			arr[i] = new Pair(A, B, C);
		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static long getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		DisjointSet ds = new DisjointSet(V + 1);
		ds.makeSet();
		long sum = 0;

		for (int i = 0; i < E; i++)
			pq.offer(arr[i]);

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (ds.find(pair.s) == ds.find(pair.e))
				continue;

			sum += pair.w;
			ds.union(pair.s, pair.e);

		}
		
		return sum;

	}

	static class DisjointSet {

		int[] root, rank;

		DisjointSet(int n) {
			root = new int[n];
			rank = new int[n];
		}

		public void makeSet() {
			for (int i = 1; i < root.length; i++) {
				root[i] = i;
				rank[i] = 0;
			}
		}

		public int find(int x) {

			if (root[x] == x)
				return x;

			return root[x] = find(root[x]);
		}

		public void union(int x, int y) {

			x = find(x);
			y = find(y);

			if (x != y) {
				if (rank[x] < rank[y])
					root[x] = y;
				else if (rank[x] > rank[y])
					root[y] = x;
				else {
					root[y] = x;
					rank[x]++;
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {

		int s, e, w;

		Pair(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			return w - o.w;
		}
	}
}
