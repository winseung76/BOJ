import java.io.*;
import java.util.*;

public class n13306 {

	static int N, Q;
	static int[] parent;
	static List<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		Q = Integer.parseInt(input[1]);
		parent = new int[N + 1];

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 2; i <= N; i++) {
			int a = Integer.parseInt(br.readLine());
			parent[i] = a;
		}

		for (int i = 0; i < N - 1 + Q; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);

			if (x == 0) {
				int b = Integer.parseInt(input[1]);
				list.add(new Pair(0, b, parent[b]));
			}

			else if (x == 1) {
				int c = Integer.parseInt(input[1]);
				int d = Integer.parseInt(input[2]);
				list.add(new Pair(1, c, d));
			}
		}

		Collections.reverse(list);
		List<String> ans = new ArrayList<>();

		for (Pair pair : list) {
			if (pair.x == 0) {
				ds.union(pair.a, pair.b);
			}

			else {
				if (ds.find(pair.a) == ds.find(pair.b))
					ans.add("YES");
				else
					ans.add("NO");
			}
		}

		Collections.reverse(ans);
		for (String s : ans) {
			bw.write(s + "\n");
		}

		bw.flush();

	}

	static class DisjointSet {

		private int[] root, rank;

		DisjointSet(int size) {
			root = new int[size];
			rank = new int[size];
		}

		public void makeSet() {

			for (int i = 1; i <= N; i++) {
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
				}

				else if (rank[x] > rank[y]) {
					root[y] = x;
				}

				else {
					root[y] = x;
					rank[x]++;
				}
			}
		}

	}

	static class Pair {

		int x, a, b;

		Pair(int x, int a, int b) {
			this.x = x;
			this.a = a;
			this.b = b;
		}
	}

}
