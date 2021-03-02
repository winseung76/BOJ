import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n03055_≈ª√‚ {
	static int R, C;
	static char[][] map;
	static boolean[][] isvisited;
	static ArrayList<Pos> waters = new ArrayList<>();
	static Pos s, d;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);

		map = new char[R][C];
		isvisited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			char[] chs = br.readLine().toCharArray();

			for (int c = 0; c < C; c++) {
				map[r][c] = chs[c];

				if (map[r][c] == 'S')
					s = new Pos(r, c, 0);
				if (map[r][c] == '*')
					waters.add(new Pos(r, c, 0));
				if (map[r][c] == 'D')
					d = new Pos(r, c, 0);
			}
		}
		if (s == null || d == null) {
			bw.write("KAKTUS\n");

		} else {
			int res = flood();
			if (res == -1)
				bw.write("KAKTUS\n");
			else
				bw.write(res + "\n");
		}
		bw.flush();

	}

	public static int flood() {

		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, -1, 0, 1 };
		Queue<Pos> q = new LinkedList<>();

		q.add(s);
		isvisited[s.r][s.c] = true;

		for (int i = 0; i < waters.size(); i++)
			q.add(waters.get(i));

		while (!q.isEmpty()) {
			Pos p = q.poll();

			if (p.r == d.r && p.c == d.c)
				return p.cnt;

			if (map[p.r][p.c] == '*') {
				for (int i = 0; i < 4; i++) {
					int r = p.r + y[i];
					int c = p.c + x[i];

					if ((0 <= r && r < R) && (0 <= c && c < C) && map[r][c] == '.') {
						map[r][c] = '*';
						q.add(new Pos(r, c, 0));
					}
				}

			} else {
				for (int i = 0; i < 4; i++) {
					int r = p.r + y[i];
					int c = p.c + x[i];

					if ((0 <= r && r < R) && (0 <= c && c < C) && (map[r][c] == '.' || map[r][c] == 'D')
							&& !isvisited[r][c]) {
						isvisited[r][c] = true;
						q.add(new Pos(r, c, p.cnt + 1));
					}
				}
			}
		}
		return -1;
	}

	static class Pos {
		int r, c, cnt;

		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
