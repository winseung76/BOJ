import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n02638 {

	static int N, M;
	static int[][] map;
	static Vector<Pos> cheese = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);

				if (map[i][j] == 1)
					cheese.add(new Pos(i, j));

				else if (map[i][j] == 0) {
					if ((0 < i && i < N - 1) && (0 < j && j < M - 1))
						map[i][j] = -1;
				}
			}
		}
		int time = cheeseMelting();
		bw.write(time + "\n");
		bw.flush();

	}

	public static int cheeseMelting() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		int time = 0;

		while (true) {

			bfs();

			Vector<Pos> list = new Vector<>();
			for (int i = 0; i < cheese.size(); i++) {
				Pos pos = cheese.get(i);
				int cnt = 0;

				for (int j = 0; j < 4; j++) {
					int nr = pos.r + r[j];
					int nc = pos.c + c[j];

					if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && map[nr][nc] == 0)
						cnt++;
				}

				if (cnt >= 2)
					list.add(pos);
			}

			for (int i = 0; i < list.size(); i++) {
				Pos pos = list.get(i);
				map[pos.r][pos.c] = 0;
				cheese.remove(pos);
			}
			time++;

			if (cheese.size() == 0)
				break;

		}
		return time;
	}

	public static void bfs() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		q.offer(new Pos(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && !visited[nr][nc]) {
					if (map[nr][nc] == 0) {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					} else if (map[nr][nc] == -1) {
						map[nr][nc] = 0;
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
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
