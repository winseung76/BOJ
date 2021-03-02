import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n03184 {

	static int R, C;
	static char[][] yard;
	static boolean[][] visited;
	static int sheep, wolf;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		R = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);

		yard = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				yard[i][j] = str.charAt(j);

				if (yard[i][j] == 'o')
					sheep++;
				else if (yard[i][j] == 'v')
					wolf++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (yard[i][j] != '#' && !visited[i][j])
					bfs(new Pos(i, j));
			}
		}

		bw.write(sheep + " " + wolf + "\n");
		bw.flush();

	}

	public static void bfs(Pos start) {

		int[] r = { 1, 0, -1, 0 };
		int[] c = { 0, 1, 0, -1 };
		int sheepCnt = 0;
		int wolfCnt = 0;
		Queue<Pos> q = new LinkedList<>();

		visited[start.r][start.c] = true;
		q.offer(start);

		if (yard[start.r][start.c] == 'o')
			sheepCnt++;
		else if (yard[start.r][start.c] == 'v')
			wolfCnt++;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && !visited[nr][nc] && yard[nr][nc] != '#') {

					if (yard[nr][nc] == 'o')
						sheepCnt++;
					else if (yard[nr][nc] == 'v')
						wolfCnt++;

					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}

			}
		}

		if (sheepCnt > wolfCnt)
			wolf -= wolfCnt;
		else
			sheep -= sheepCnt;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
