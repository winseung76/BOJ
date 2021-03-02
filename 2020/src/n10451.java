import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10451 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			DisjointSet ds = new DisjointSet(N + 1);
			ds.makeSet();

			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++)
				ds.union(j, Integer.parseInt(s[j - 1]));

			boolean[] root = new boolean[N + 1];
			int cnt = 0;

			for (int j = 1; j <= N; j++) {
				int n = ds.find(j);

				if (!root[n]) {
					root[n] = true;
					cnt++;
				}
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

}
