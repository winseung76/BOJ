import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n15685 {

	static int N;
	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");

			int x = Integer.parseInt(sarr[0]);
			int y = Integer.parseInt(sarr[1]);
			int d = Integer.parseInt(sarr[2]);
			int g = Integer.parseInt(sarr[3]);

			Vector<Pos> list = new Vector<>();
			list.add(new Pos(y, x));
			map[y][x] = true;

			switch (d) {
			case 0:
				list.add(new Pos(y, x + 1));
				map[y][x + 1] = true;
				break;
			case 1:
				list.add(new Pos(y - 1, x));
				map[y - 1][x] = true;
				break;
			case 2:
				list.add(new Pos(y, x - 1));
				map[y][x - 1] = true;
				break;
			case 3:
				list.add(new Pos(y + 1, x));
				map[y + 1][x] = true;
				break;

			}

			int cnt = 0;
			int[] r = { 0, -1, 0, 1 };
			int[] c = { 1, 0, -1, 0 };

			while (cnt < g) {

				int size = list.size();
				Pos newPos = list.get(size - 1);

				for (int k = size - 2; k >= 0; k--) {
					Pos pos = list.get(k);
					Pos pre = list.get(k + 1);

					int dx = pre.x - pos.x;
					int dy = pre.y - pos.y;

					for (int j = 0; j < 4; j++) {
						if (c[j] == dx && r[j] == dy) {
							int nx = newPos.x + c[(j + 1) % 4];
							int ny = newPos.y + r[(j + 1) % 4];

							newPos = new Pos(ny, nx);

							list.add(newPos);
							map[ny][nx] = true;

							break;
						}
					}
				}
				cnt++;
			}
		}

		int res = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (map[i][j]) {
					if ((0 <= (i + 1) && (i + 1) <= 100) && (0 <= (j + 1) && (j + 1) <= 100) && map[i][j + 1]
							&& map[i + 1][j + 1] && map[i + 1][j]) {
						res++;
					}
				}
			}
		}
		bw.write(res + "\n");
		bw.flush();

	}

	static class Pos {

		int x, y;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
