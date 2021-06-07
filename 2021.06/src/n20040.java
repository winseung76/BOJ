import java.io.*;
import java.util.*;

public class n20040 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		DisjointSet ds = new DisjointSet(N);
		ds.makeSet();

		for (int i = 1; i <= M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			if (ds.find(a) == ds.find(b)) {
				bw.write(i + "\n");
				bw.flush();
				return;
			}

			ds.union(a, b);
		}

		bw.write(0 + "\n");
		bw.flush();

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

			x = root[x];
			y = root[y];

			if (x == y)
				return;

			if (rank[x] > rank[y]) {
				root[y] = x;
			}

			else if (rank[x] < rank[y]) {
				root[x] = y;
			}

			else {
				root[y] = x;
				rank[x]++;
			}
		}
	}

}
