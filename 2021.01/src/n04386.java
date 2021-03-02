import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n04386 {

	static int n;
	static Pos[] stars;
	static Vector<Pair> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		stars = new Pos[n];

		for (int i = 0; i < n; i++) {
			String[] sarr = br.readLine().split(" ");
			double x = Double.parseDouble(sarr[0]);
			double y = Double.parseDouble(sarr[1]);
			stars[i] = new Pos(x, y);
		}

		for (int i = 0; i < n; i++) {
			Pos s = stars[i];
			for (int j = i + 1; j < n; j++) {
				Pos e = stars[j];

				double w = Math.sqrt(Math.pow(s.x - e.x, 2) + Math.pow(s.y - e.y, 2));

				list.add(new Pair(i, j, w));
			}
		}
		bw.write(getMST() + "\n");
		bw.flush();

	}

	public static double getMST() {

		double sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 0; i < list.size(); i++)
			pq.offer(list.get(i));

		DisjointSet ds = new DisjointSet(n);
		ds.makeSet();

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (ds.find(pair.s) == ds.find(pair.e))
				continue;

			ds.union(pair.s, pair.e);
			sum += pair.w;

		}

		return Math.floor(sum * 100) / 100.0;
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

			x = root[x];
			y = root[y];

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

	static class Pos {

		double x, y;

		Pos(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Pair implements Comparable<Pair> {
		int s, e;
		double w;

		Pair(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			return (int) (w - o.w);
		}

	}

}
