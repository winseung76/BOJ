import java.io.*;
import java.util.*;

public class n14594 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			for (int j = s; j < e; j++) {
				ds.union(j, j + 1);
			}
		}

		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(ds.find(i));
		}

		bw.write(set.size() + "\n");
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

			x = find(x);
			y = find(y);

			if (x == y)
				return;

			if (rank[x] > rank[y])
				root[y] = x;
			else if (rank[x] < rank[y])
				root[x] = y;
			else {
				root[y] = x;
				rank[x]++;
			}
		}
	}

}
