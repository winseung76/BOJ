import java.io.*;
import java.util.*;

public class n01941 {

	static List<Pos> poses = new ArrayList<>();
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

		solve(new ArrayList<>(), 0, 0, 0, -1);

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void solve(List<Pos> list, int s, int y, int r, int c) {

		if (s + y == 7 && s >= 4) {
			boolean res = bfs(list);

			if (res) {

				cnt++;
			}
			tmp++;
			return;
		}

		for (int i = r; i < 5; i++) {
			int j = 0;
			if (i == r)
				j = c + 1;
			for (; j < 5; j++) {

				if (!visited[i][j]) {

					Pos pos = new Pos(i, j);
					visited[i][j] = true;
					list.add(pos);

					if (board[i][j] == 'S')
						solve(list, s + 1, y, i, j);
					else if (y < 3)
						solve(list, s, y + 1, i, j);

					list.remove(pos);
					visited[i][j] = false;
				}
			}
		}
	}

	public static boolean bfs(List<Pos> list) {

		Queue<Pos> q = new LinkedList<>();
		boolean[][] check = new boolean[5][5];

		Pos start = list.get(0);
		check[start.r][start.c] = true;
		q.offer(start);

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (Pos p : list) {
				if (!check[p.r][p.c] && Math.abs(p.r - pos.r) + Math.abs(p.c - pos.c) == 1) {
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
