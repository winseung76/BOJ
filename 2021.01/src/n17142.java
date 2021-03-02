import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n17142 {

	static int N, M;
	static int[][] map, mapCopy;
	static Vector<Pos> active = new Vector<>();
	static int min = Integer.MAX_VALUE;
	static int zeroCnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N][N];
		mapCopy = new int[N][N];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);

				if (map[i][j] == 2)
					active.add(new Pos(i, j, 0));

				else if (map[i][j] == 0)
					zeroCnt++;
			}
		}
		
		if (zeroCnt == 0)
			bw.write(0 + "\n");
		else {
			Vector<Pos> list = new Vector<>();
			comb(list, 0);

			if (min == Integer.MAX_VALUE)
				bw.write(-1 + "\n");
			else
				bw.write(min + "\n");
		}
		bw.flush();

	}

	public static void comb(Vector<Pos> list, int idx) {

		if (list.size() == M) {

			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, mapCopy[i], 0, N);

			for (int i = 0; i < active.size(); i++) {
				Pos p = active.get(i);
				if (!list.contains(p)) {
					mapCopy[p.r][p.c] = -1;
				}
			}

			int res = bfs(list, mapCopy, zeroCnt);

			if (res > 0)
				min = Math.min(min, res);
			return;
		}

		for (int i = idx; i < active.size(); i++) {
			Pos p = active.get(i);

			if (!list.contains(p)) {
				list.add(p);
				comb(list, i + 1);
				list.remove(p);
			}
		}

	}

	public static int bfs(Vector<Pos> list, int[][] map, int cnt) {

		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++)
			q.offer(list.get(i));

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		int time = 0;
		int zeroCnt = cnt;

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && (map[nr][nc] == 0 || map[nr][nc] == -1)) {
					if (map[nr][nc] == 0) {
						zeroCnt--;
						time = pos.time + 1;
					}
					map[nr][nc] = 2;
					q.offer(new Pos(nr, nc, pos.time + 1));
	
				}
			}
		}

		if (zeroCnt > 0)
			return -1;

		return time;

	}

	static class Pos {

		int r, c;
		int time;

		Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
