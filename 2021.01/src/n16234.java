import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n16234 {

	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}

		while (true) {
			visited = new boolean[N][N];
			flag = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					if (!visited[i][j]) {
						bfs(new Pos(i, j));
					}
			}

			if (!flag)
				break;

			res++;
		}

		bw.write(res + "\n");
		bw.flush();

	}

	public static void bfs(Pos s) {

		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		Vector<Pos> list = new Vector<>();
		int sum = 0;

		q.offer(s);
		visited[s.r][s.c] = true;
		sum += map[s.r][s.c];
		list.add(s);

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + y[i];
				int nc = pos.c + x[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && !visited[nr][nc]) {

					int diff = Math.abs(map[pos.r][pos.c] - map[nr][nc]);

					if (L <= diff && diff <= R) {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
						sum += map[nr][nc];
						list.add(new Pos(nr, nc));
					}
				}
			}

		}

		if (list.size() > 1) {
			flag = true;

			int n = sum / list.size();
			for (int i = 0; i < list.size(); i++) {
				Pos p = list.get(i);
				map[p.r][p.c] = n;
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
