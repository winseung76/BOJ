import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01717 {

	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		DisjointSet ds = new DisjointSet(n + 1);
		ds.makeSet();

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");

			int n = Integer.parseInt(s[0]);
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);

			if (n == 0) {
				ds.union(a, b);
			} else if (n == 1) {
				if (ds.find(a) == ds.find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}
		bw.flush();

	}

	static class DisjointSet {

		int[] root;
		int[] rank;
		int[] nodeCount;

		DisjointSet(int n) {
			root = new int[n];
			rank = new int[n];
			nodeCount = new int[n];
		}

		public int find(int x) {

			if (root[x] == x)
				return x;

			return root[x] = find(root[x]);
		}

		public void union(int x, int y) {

			x = find(x);
			y = find(y);

			if (x == y)
				return;

			if (rank[x] < rank[y])
				root[x] = y;
			else if (rank[x] > rank[y])
				root[y] = x;
			else if (rank[x] == rank[y]) {
				root[y] = x; // root[x]=y;
				rank[x]++; // root[y]++;
			}
		}

		public int union2(int x, int y) {
			
			x = find(x);
			y = find(y);

			if (x != y) {
				root[y] = x;
				nodeCount[x] += nodeCount[y];
				nodeCount[y] = 1;
			}
			
			return nodeCount[x];

		}

		public void makeSet() {
			for (int i = 1; i < root.length; i++) {
				root[i] = i;
				rank[i] = 0;
			}
		}

	}
}
