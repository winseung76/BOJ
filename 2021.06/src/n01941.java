import java.io.*;
import java.util.*;

public class n01941 {

	static char[][] board = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int cnt;
	static int tmp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		solve(new ArrayList<>(), 0, 0);

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void solve(List<Pos> list, int s, int y) {

		if (list.size() == 7) {
			boolean res = bfs(list);
			if (tmp == 0) {
				for (Pos p : list) {
					System.out.println(p.r + " " + p.c);
				}
				System.out.println(res);
				System.out.println();
			}

			// System.out.println(res);
			if (res) {
				cnt++;
			}
			tmp++;
			return;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				if (!visited[i][j]) {

					Pos pos = new Pos(i, j);
					visited[i][j] = true;
					list.add(pos);

					if (board[i][j] == 'S')
						solve(list, s + 1, y);
					else if (y < 3)
						solve(list, s, y + 1);

					list.remove(pos);
					visited[i][j] = false;
				}
			}
		}
	}

	public static boolean bfs(List<Pos> list) {

		Queue<Pos> q = new LinkedList<>();
		boolean[][] check = new boolean[5][5];

		/*
		 * for (Pos p : list) { System.out.println(p.r + " " + p.c); }
		 * System.out.println();
		 * 
		 */
		Pos start = list.get(0);
		check[start.r][start.c] = true;
		q.offer(start);

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (Pos p : list) {
				if (!check[p.r][p.c] && Math.abs(p.r - pos.r) + Math.abs(p.c - pos.c) == 1) {
					// System.out.println(np.r + " " + np.c + " " + check[np.r][np.c]);
					q.offer(p);
					check[p.r][p.c] = true;
				}
			}

		}

		for (Pos p : list) {
			if (!check[p.r][p.c])
				return false;
		}

		return true;

	}

	static class Pair {

		Pos pos;
		int sum;
		int s, y;

		Pair(Pos pos, int sum, int s, int y) {
			this.pos = pos;
			this.sum = sum;
			this.s = s;
			this.y = y;
		}
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
