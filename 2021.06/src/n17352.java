import java.io.*;

public class n17352 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 0; i < N - 2; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ds.union(a, b);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (ds.find(i) != ds.find(j)) {
					bw.write(i + " " + j + "\n");
					bw.flush();
					return;
				}
			}
		}

	}

	static class DisjointSet {

		private int[] root, rank;

		DisjointSet(int n) {
			root = new int[n];
			rank = new int[n];
		}

		public void makeSet() {

			for (int i = 0; i < root.length; i++) {
				root[i] = i;
				rank[i] = 1;
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

			if (x == y)
				return;

			if (root[x] > root[y])
				root[y] = x;
			else if (root[x] < root[y])
				root[x] = y;
			else {
				root[y] = x;
				rank[x]++;
			}
		}
	}

}
