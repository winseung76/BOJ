import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n02636 {

	static int N, M;
	static Vector<Pos> cheese = new Vector();
	static Vector<Pos> air = new Vector();
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 1)
					cheese.add(new Pos(i, j));
				if (i == 0 || i == N - 1 || j == 0 || j == M - 1)
					air.add(new Pos(i, j));

			}
		}

		isAir();

		int time = 0;
		int n = 0;
		while (true) {

			n = bfs();
			isAir();
			time++;

			if (cheese.size() == 0)
				break;

		}
		bw.write(time + "\n" + n);
		bw.flush();

	}

	public static void isAir() {

		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		Queue<Pos> q = new LinkedList<>();

		for (int i = 0; i < air.size(); i++)
			q.add(air.get(i));

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + y[i];
				int nc = pos.c + x[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					air.add(new Pos(nr, nc));
					q.offer(new Pos(nr, nc));

				}
			}

		}
	}

	public static int bfs() {

		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };
		int size = cheese.size();

		int idx = 0;
		boolean flag;

		while (idx < cheese.size()) {
			Pos pos = cheese.get(idx);
			flag = false;

			for (int j = 0; j < 4; j++) {
				int nr = pos.r + y[j];
				int nc = pos.c + x[j];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && map[nr][nc] == 2) {
					map[pos.r][pos.c] = 0;
					cheese.remove(pos);
					flag = true;
					break;
				}
			}

			if (!flag)
				idx++;

		}

		return size;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
