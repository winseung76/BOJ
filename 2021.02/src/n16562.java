import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n16562 {

	static int N, M, k;
	static int[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		k = Integer.parseInt(sarr[2]);

		A = new int[N + 1];

		sarr = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(sarr[i - 1]);

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int v = Integer.parseInt(sarr[0]);
			int w = Integer.parseInt(sarr[1]);

			ds.union(v, w);
		}

		int sum = 0;

		for (int i = 1; i <= N; i++) {
			sum += ds.cost[i];
		}

		if (sum <= k)
			bw.write(sum + "\n");
		else
			bw.write("Oh no\n");

		bw.flush();

	}

	static class DisjointSet {

		int[] root, rank, cost;

		DisjointSet(int n) {

			root = new int[n];
			rank = new int[n];
			cost = new int[n];
		}

		public void makeSet() {

			for (int i = 0; i < root.length; i++) {
				root[i] = i;
				rank[i] = 0;
				cost[i] = A[i];
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

				if (rank[x] < rank[y]) {
					root[x] = y;
					cost[y] = Math.min(cost[y], cost[x]);
					cost[x] = 0;
				} else if (rank[x] > rank[y]) {
					root[y] = x;
					cost[x] = Math.min(cost[x], cost[y]);
					cost[y] = 0;
				} else {
					root[y] = x;
					rank[x]++;
					cost[x] = Math.min(cost[x], cost[y]);
					cost[y] = 0;
				}

			}
		}
	}

}
