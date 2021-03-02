import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n03197 {

	static int R, C;
	static char[][] lake;
	static Queue<Pair> q = new LinkedList<>();
	static Pos swan1, swan2;
	static DisjointSet ds;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		R = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);

		lake = new char[R][C];
		ds = new DisjointSet(R * C);
		ds.makeSet();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {

				lake[i][j] = str.charAt(j);

				if (lake[i][j] != 'X')
					q.offer(new Pair(new Pos(i, j), 0));

				if (lake[i][j] == 'L') {
					if (swan1 == null)
						swan1 = new Pos(i, j);
					else
						swan2 = new Pos(i, j);
				}

			}
		}

		int res;
		if (bfs())
			res = 0;
		else
			res = meltIce();

		bw.write(res + "\n");
		bw.flush();

	}

	public static boolean bfs() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		boolean[][] visited = new boolean[R][C];
		Queue<Pos> q = new LinkedList<>();

		visited[swan1.r][swan1.c] = true;
		q.offer(swan1);

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			if (pos.r == swan2.r && pos.c == swan2.c)
				return true;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && lake[nr][nc] != 'X' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}

		}
		return false;

	}

	public static int meltIce() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		int preTime = 0;

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			preTime = pair.time;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < R) && (0 <= nc && nc < C)) {

					ds.union(nr * C + nc, pos.r * C + pos.c);

					if (lake[nr][nc] == 'X') {
						lake[nr][nc] = '.';

						for (int j = 0; j < 4; j++) {
							int nr2 = nr + r[j];
							int nc2 = nc + c[j];

							if ((0 <= nr2 && nr2 < R) && (0 <= nc2 && nc2 < C) && lake[nr2][nc2] != 'X')
								ds.union(nr * C + nc, nr2 * C + nc2);
						}
						q.offer(new Pair(new Pos(nr, nc), pair.time + 1));
					}
				}

			}

			if (ds.find(swan1.r * C + swan1.c) == ds.find(swan2.r * C + swan2.c))
				return pair.time + 1;

		}

		return preTime;
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
			}
		}
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Pair {

		Pos pos;
		int time;

		Pair(Pos pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}

}
