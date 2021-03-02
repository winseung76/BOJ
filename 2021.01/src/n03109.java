import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n03109 {

	static int R, C;
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = s[j].charAt(0);
			}
		}

		int cnt = 0;

		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(new Pos(i, 0));
		}

		for (int i = 0; i < R; i++) {
			if (visited[i][C - 1])
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static int dfs(Pos pos) {

		int[] y = { -1, 0, 1 };

		if (pos.c == C - 1) {
			return 1;
		}

		for (int i = 0; i < 3; i++) {
			int nr = pos.r + y[i];
			int nc = pos.c + 1;

			if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && map[nr][nc] == '.' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				int res = dfs(new Pos(nr, nc));
				if (res == 1)
					return 1;
			}
		}
		return 0;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
