import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n01562_°è´Ü¼ö {
	private static boolean[][] isvisited;
	private static int[][] arr;
	private static int r1, c1, r2, c2, l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			l = sc.nextInt();
			arr = new int[l][l];
			isvisited = new boolean[l][l];
			r1 = sc.nextInt();
			c1 = sc.nextInt();
			r2 = sc.nextInt();
			c2 = sc.nextInt();
			System.out.println(bfs(r1, c1));
		}

	}

	public static int bfs(int r, int c) {
		int[] x = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int[] y = { 1, 2, 2, 1, -1, -2, -2, -1 };
		Pair p = null;
		Queue<Pair> q = new LinkedList<>();

		isvisited[r][c] = true;
		q.offer(new Pair(r, c, 0));

		while (!q.isEmpty()) {
			p = q.poll();

			if (p.r == r2 && p.c == c2)
				break;

			for (int i = 0; i < 8; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if (0 <= nr && nr < l && 0 <= nc && nc < l && !isvisited[nr][nc]) {
					isvisited[nr][nc] = true;
					q.offer(new Pair(nr, nc, p.count + 1));
				}
			}
		}
		return p.count;
	}

	static class Pair {
		int r, c, count;

		Pair(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

}
