import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n04179 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Vector<Pos> jihoon = new Vector<>();
	static Vector<Pos> fire = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		R = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'J')
					jihoon.add(new Pos(i, j));
				else if (map[i][j] == 'F')
					fire.add(new Pos(i, j));
			}
		}
		int res = bfs();

		if (res == -1)
			bw.write("IMPOSSIBLE\n");
		else
			bw.write(res + "\n");
		bw.flush();

	}

	public static int bfs() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < fire.size(); i++) {
			Pos pos = fire.get(i);
			q.offer(new Pair(pos, 0));
		}

		Pos p = jihoon.get(0);
		visited[p.r][p.c] = true;
		q.offer(new Pair(p, 0));

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			if (jihoon.contains(pos) && (pos.r == 0 || pos.r == R - 1 || pos.c == 0 || pos.c == C - 1))
				return pair.time + 1;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && (map[nr][nc] == '.' || map[nr][nc] == 'J')) {

					if (!jihoon.contains(pos)) {
						map[nr][nc] = 'F';
						q.offer(new Pair(new Pos(nr, nc), pair.time + 1));
					}

					else if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						Pos np = new Pos(nr, nc);
						q.offer(new Pair(np, pair.time + 1));
						jihoon.add(np);
					}

				}

			}

			if (jihoon.contains(pos))
				jihoon.remove(pos);
		}

		return -1;
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
