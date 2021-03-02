import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n17135 {

	static int N, M, D;
	static int[][] map;
	static Vector<Pos> archer = new Vector<>();
	static int max = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		D = Integer.parseInt(sarr[2]);
		map = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		comb(0);
		bw.write(max + "\n");
		bw.flush();

	}

	public static void comb(int idx) {

		if (archer.size() == 3) {

			int res = 0;
			int[][] mapCopy = new int[N + 1][M];

			for (int k = 0; k < map.length; k++)
				System.arraycopy(map[k], 0, mapCopy[k], 0, map[k].length);

			while (true) {
				boolean flag = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) {
							flag = false;
							break;
						}
					}
					if (!flag)
						break;
				}
				if (flag)
					break;

				Vector<Pos> list = new Vector<>();
				for (int i = 0; i < archer.size(); i++) {
					bfs(archer.get(i), list);
				}
				res += list.size();

				for (int i = 0; i < list.size(); i++) {
					Pos pos = list.get(i);
					map[pos.r][pos.c] = 0;
				}

				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) {
							map[i][j] = 0;
							if (i < N - 1)
								map[i + 1][j] = 1;
						}
					}
				}
			}

			// System.out.println(res);
			max = Math.max(max, res);

			for (int k = 0; k < mapCopy.length; k++)
				System.arraycopy(mapCopy[k], 0, map[k], 0, mapCopy[k].length);
			return;
		}

		for (int i = idx; i < M; i++) {

			Pos pos = new Pos(N, i);
			archer.add(pos);
			comb(i + 1);
			archer.remove(pos);

		}

	}

	public static void bfs(Pos start, Vector<Pos> list) {

		int[] r = { 0, -1, 0 };
		int[] c = { -1, 0, 1 };
		boolean[][] visited = new boolean[N + 1][M];
		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			int dist = Math.abs(start.r - pos.r) + Math.abs(start.c - pos.c);

			if ((0 < dist && dist <= D) && map[pos.r][pos.c] == 1) {

				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					Pos p = list.get(i);
					if (p.r == pos.r && p.c == pos.c) {
						flag = true;
						break;
					}
				}

				if (!flag)
					list.add(pos);

				return;
			}

			for (int i = 0; i < 3; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && !visited[nr][nc]) {

					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
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

}
