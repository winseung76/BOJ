import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n06593_»ó¹üºôµù {

	static char[][][] building;
	static Pos S, E;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] arr = br.readLine().split(" ");
			int L = Integer.parseInt(arr[0]);
			int R = Integer.parseInt(arr[1]);
			int C = Integer.parseInt(arr[2]);

			if (L == 0 && R == 0 && C == 0)
				break;

			building = new char[L][R][C];
			visited = new boolean[L][R][C];

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String str = br.readLine();

					for (int c = 0; c < C; c++) {
						char ch = str.charAt(c);
						building[l][r][c] = ch;

						if (ch == 'S')
							S = new Pos(l, r, c, 0);
						if (ch == 'E')
							E = new Pos(l, r, c, 0);
					}
				}
				br.readLine();
			}
			int res = bfs(L, R, C);
			if (res > 0)
				bw.write("Escaped in " + res + " minute(s).\n");
			else
				bw.write("Trapped!\n");
		}

		bw.flush();
	}

	static int bfs(int L, int R, int C) {

		int[] x = { 0, 1, 0, -1, 0, 0 };
		int[] y = { 1, 0, -1, 0, 0, 0 };
		int[] z = { 0, 0, 0, 0, 1, -1 };
		Queue<Pos> q = new LinkedList<>();

		q.add(S);
		visited[S.l][S.r][S.c] = true;

		while (!q.isEmpty()) {

			Pos p = q.poll();

			if (building[p.l][p.r][p.c] == 'E')
				return p.cnt;

			for (int i = 0; i < 6; i++) {
				int nl = p.l + z[i];
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if ((0 <= nl && nl < L) && (0 <= nr && nr < R) && (0 <= nc && nc < C) && !visited[nl][nr][nc]
						&& building[nl][nr][nc] != '#') {

					q.add(new Pos(nl, nr, nc, p.cnt + 1));
					visited[nl][nr][nc] = true;
				}
			}
		}

		return -1;

	}

	static class Pos {
		int l, r, c, cnt;

		Pos(int l, int r, int c, int cnt) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
