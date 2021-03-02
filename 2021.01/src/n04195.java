import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class n04195 {

	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int idx;

		for (int i = 0; i < N; i++) {
			DisjointSet ds = new DisjointSet(200000);
			ds.makeSet();
			map.clear();
			idx = 0;

			int F = Integer.parseInt(br.readLine());
			for (int j = 0; j < F; j++) {

				String[] s = br.readLine().split(" ");
				String a = s[0];
				String b = s[1];

				if (!map.containsKey(a))
					map.put(a, idx++);

				if (!map.containsKey(b))
					map.put(b, idx++);

				ds.union(map.get(a), map.get(b));

				int root = ds.find(map.get(a));
				bw.write(ds.getNodeCount(root) + "\n");
			}

		}
		bw.flush();

	}

	static class DisjointSet {

		int[] root, rank, nodeCount;

		DisjointSet(int n) {
			root = new int[n];
			rank = new int[n];
			nodeCount = new int[n];
		}

		public void makeSet() {
			for (int i = 0; i < root.length; i++) {
				root[i] = i;
				rank[i] = 0;
				nodeCount[i] = 1;
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
					nodeCount[y] += nodeCount[x];
					nodeCount[x] = 1;
				} else if (rank[x] > rank[y]) {
					root[y] = x;
					nodeCount[x] += nodeCount[y];
					nodeCount[y] = 1;
				} else if (rank[x] == rank[y]) {
					root[y] = x;
					rank[x]++;
					nodeCount[x] += nodeCount[y];
					nodeCount[y] = 1;
				}

			}
		}

		public int getNodeCount(int x) {
			return nodeCount[x];
		}
	}

}
