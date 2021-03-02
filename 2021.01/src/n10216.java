import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10216 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Pair[] arr = new Pair[N];
			DisjointSet ds = new DisjointSet(N);
			ds.makeSet();

			for (int i = 0; i < N; i++) {
				String[] sarr = br.readLine().split(" ");
				int x = Integer.parseInt(sarr[0]);
				int y = Integer.parseInt(sarr[1]);
				int R = Integer.parseInt(sarr[2]);

				arr[i] = new Pair(x, y, R);

			}

			for (int i = 0; i < N; i++) {
				Pair pair = arr[i];
				for (int j = i + 1; j < N; j++) {
					double dist = Math
							.sqrt(Math.pow(Math.abs(pair.x - arr[j].x), 2) + Math.pow(Math.abs(pair.y - arr[j].y), 2));

					if (dist <= pair.r + arr[j].r) {
						ds.union(i, j);
					}
				}
			}
			boolean[] check = new boolean[N];
			for (int i = 0; i < N; i++) {
				int n = ds.find(i);
				check[n] = true;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (check[i])
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();

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

			x = find(x);
			y = find(y);

			if (x != y) {

				if (rank[x] < rank[y]) {
					root[x] = y;
				} else if (rank[x] > rank[y]) {
					root[y] = x;
				} else if (rank[x] == rank[y]) {
					root[y] = x;
					rank[x]++;
				}

			}
		}
	}

	static class Pair {

		int x, y, r;

		Pair(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

}
