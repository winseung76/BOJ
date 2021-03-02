import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01976 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");

			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(s[j - 1]);
				if (a == 1)
					ds.union(i, j);
			}
		}
		String[] s = br.readLine().split(" ");
		int pre = 0, root;

		for (int i = 0; i < s.length; i++) {
			int a = Integer.parseInt(s[i]);
			root = ds.find(a);
			if (i > 0 && root != pre) {
				bw.write("NO\n");
				bw.flush();
				return;
			}
			pre = root;
		}

		bw.write("YES\n");
		bw.flush();

	}

	static class DisjointSet {

		int[] root;
		int[] rank;

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
					root[y] = x;
				else if (rank[x] > rank[y])
					root[x] = y;
				else if (rank[x] == rank[y]) {
					root[y] = x;
					rank[x]++;
				}
			}
		}

	}

}
