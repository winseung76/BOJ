import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01926 {

	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int max;
	static int painting;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		n = Integer.parseInt(sarr[0]);
		m = Integer.parseInt(sarr[1]);

		paper = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1 && !visited[i][j]) {
					bfs(new Pos(i, j));
					painting++;
				}
			}
		}
		bw.write(painting + "\n");
		bw.write(max + "\n");
		bw.flush();

	}

	public static void bfs(Pos start) {

		int cnt = 0;
		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();

		visited[start.r][start.c] = true;
		q.offer(start);

		while (!q.isEmpty()) {

			Pos pos = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < n) && (0 <= nc && nc < m) && !visited[nr][nc] && paper[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}

		max = Math.max(max, cnt);

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
