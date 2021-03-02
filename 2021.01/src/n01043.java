import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n01043 {

	static int N, M;
	static boolean[] party, people;
	static Vector<Integer>[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		party = new boolean[M];
		people = new boolean[N + 1];
		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new Vector<>();

		DisjointSet ds = new DisjointSet(N + 1);

		ds.makeSet();

		sarr = br.readLine().split(" ");
		for (int i = 1; i < sarr.length; i++)
			people[Integer.parseInt(sarr[i])] = true;

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");

			int pre = 0;
			for (int j = 1; j < sarr.length; j++) {
				int n = Integer.parseInt(sarr[j]);
				arr[n].add(i);

				if (j > 1)
					ds.union(n, pre);

				pre = n;

			}
		}

		for (int i = 1; i <= N; i++) {
			if (people[ds.find(i)])
				people[i] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (people[i]) {
				for (int j = 0; j < arr[i].size(); j++)
					party[arr[i].get(j)] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (!party[i])
				cnt++;
		}

		bw.write(cnt + "\n");
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

				if (rank[x] < rank[y])
					root[x] = y;
				else if (rank[x] > rank[y])
					root[y] = x;
				else {
					root[y] = x;
					rank[x]++;
				}

				if (people[x] || people[y])
					people[x] = people[y] = true;
			}
		}

	}

}
