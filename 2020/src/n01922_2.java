import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01922_2 {

	static int N, M;
	static Pair[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new Pair[M];

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);

			arr[i] = new Pair(a, b, c);

		}

		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static int getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();
		int sum = 0;

		for (int i = 0; i < M; i++) {
			if (arr[i].s != arr[i].e)
				pq.offer(arr[i]);
		}

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
				else if (rank[x] == rank[y]) {
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
