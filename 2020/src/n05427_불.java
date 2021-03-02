import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class n05427_บา {

	static char[][] building;
	static Deque<Pos> q = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] arr = br.readLine().split(" ");
			int w = Integer.parseInt(arr[0]);
			int h = Integer.parseInt(arr[1]);

			building = new char[h][w];
			visited = new boolean[h][w];
			q.clear();

			for (int i = 0; i < h; i++) {
				String s = br.readLine();

				for (int j = 0; j < w; j++) {
					char ch = s.charAt(j);

					if (ch == '*')
						q.addLast(new Pos(i, j, 1));

					else if (ch == '@') {
						q.addFirst(new Pos(i, j, 1));
						visited[i][j] = true;
					}

					building[i][j] = ch;
				}
			}

			int res = bfs(q, h, w);

			if (res == -1)
				bw.write("IMPOSSIBLE\n");
			else
				bw.write(res + "\n");
		}
		bw.flush();
	}

	static int bfs(Deque<Pos> queue, int h, int w) {

		Deque<Pos> q = queue;
		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		while (!q.isEmpty()) {

			Pos p = q.poll();

			if ((building[p.h][p.w] == '.' || building[p.h][p.w] == '@')
					&& (p.h == 0 || p.h == h - 1 || p.w == 0 || p.w == w - 1))
				return p.cnt;

			for (int i = 0; i < 4; i++) {
				int ny = p.h + y[i];
				int nx = p.w + x[i];

				if ((0 <= ny && ny < h) && (0 <= nx && nx < w) && building[ny][nx] != '#') {
					if (building[p.h][p.w] == '*' && building[ny][nx] != '*') {
						building[ny][nx] = '*';
						q.add(new Pos(ny, nx, p.cnt + 1));
					}

					else if (building[ny][nx] == '.' && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx, p.cnt + 1));
					}
				}
			}
		}
		return -1;
	}

	static class Pos {
		int h, w, cnt;

		Pos(int h, int w, int cnt) {
			this.h = h;
			this.w = w;
			this.cnt = cnt;
		}
	}
}
