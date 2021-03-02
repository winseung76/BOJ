import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n02887 {

	static int N;
	static Pos[] planet;
	static Pos[] dx, dy, dz;
	static long min = Long.MAX_VALUE;
	static int e;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		planet = new Pos[N + 1];
		dx = new Pos[N + 1];
		dy = new Pos[N + 1];
		dz = new Pos[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int z = Integer.parseInt(s[2]);
			planet[i] = new Pos(i, x, y, z);
			dx[i] = new Pos(i, x, y, z);
			dy[i] = new Pos(i, x, y, z);
			dz[i] = new Pos(i, x, y, z);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		mergeSort(dx, 1, N, 1);
		mergeSort(dy, 1, N, 2);
		mergeSort(dz, 1, N, 3);

		for (int s = 1; s < N; s++) {

			long diff1 = Math.abs(dx[s].x - dx[s + 1].x);
			long diff2 = Math.abs(dx[s].y - dx[s + 1].y);
			long diff3 = Math.abs(dx[s].z - dx[s + 1].z);
			long min = Math.min(diff1, Math.min(diff2, diff3));
			pq.offer(new Pair(dx[s].n, dx[s + 1].n, min));

			diff1 = Math.abs(dy[s].x - dy[s + 1].x);
			diff2 = Math.abs(dy[s].y - dy[s + 1].y);
			diff3 = Math.abs(dy[s].z - dy[s + 1].z);
			min = Math.min(diff1, Math.min(diff2, diff3));
			pq.offer(new Pair(dy[s].n, dy[s + 1].n, min));

			diff1 = Math.abs(dz[s].x - dz[s + 1].x);
			diff2 = Math.abs(dz[s].y - dz[s + 1].y);
			diff3 = Math.abs(dz[s].z - dz[s + 1].z);
			min = Math.min(diff1, Math.min(diff2, diff3));
			pq.offer(new Pair(dz[s].n, dz[s + 1].n, min));
		}

		bw.write(getMST(pq) + "\n");
		bw.flush();

	}

	public static void mergeSort(Pos[] arr, int left, int right, int flag) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center, flag);
			mergeSort(arr, center + 1, right, flag);

			int size = center - left + 1;
			Pos[] buf = new Pos[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right) {
				if (flag == 1)
					arr[k++] = (buf[pl].x < arr[pr].x) ? buf[pl++] : arr[pr++];
				else if (flag == 2)
					arr[k++] = (buf[pl].y < arr[pr].y) ? buf[pl++] : arr[pr++];
				else if (flag == 3)
					arr[k++] = (buf[pl].z < arr[pr].z) ? buf[pl++] : arr[pr++];
			}

			while (pl < size)
				arr[k++] = buf[pl++];

		}

	}

	public static int getMST(PriorityQueue<Pair> pq) {

		DisjointSet ds = new DisjointSet(N + 1);
		ds.makeSet();
		int sum = 0;

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (ds.find(pair.s) == ds.find(pair.e))
				continue;

			sum += pair.w;
			ds.union(pair.s, pair.e);

		}

		return sum;

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
				else {
					root[y] = x;
					rank[x]++;
				}
			}
		}
	}

	static class Pos {

		int n, x, y, z;

		Pos(int n, int x, int y, int z) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Pair implements Comparable<Pair> {

		int s, e;
		long w;

		Pair(int s, int e, long w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {

			if (w < o.w)
				return -1;
			else if (w > o.w)
				return 1;
			else
				return 0;

		}
	}

}
