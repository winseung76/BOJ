import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 크루스칼 알고리즘
public class n01647_2 {

	static int N, M;
	static Pair[] arr;
	static int sum, max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new Pair[M];

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);

			arr[i] = new Pair(A, B, C);
		}
		getMST();
		bw.write(sum - max + "\n");
		bw.flush();

	}

	public static void getMST() {

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 0; i < M; i++) {
			pq.offer(arr[i]);
		}

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (ds.find(pair.s) == ds.find(pair.e))
				continue;

			sum += pair.w;
			max = Math.max(max, pair.w);
			ds.union(pair.s, pair.e);

		}

	}

	static class DisjointSet {

		int[] root, rank;

		DisjointSet(int n) {
			root = new int[n];
			rank = new int[n];
		}

		public void makeSet() {
			for (int i = 0; i < root.length; i++) {
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

			x = root[x];
			y = root[y];

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
