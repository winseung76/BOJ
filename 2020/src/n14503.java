import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14503 {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N][M];

		s = br.readLine().split(" ");
		int r = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		bw.write(getCount(r, c, d) + "\n");
		bw.flush();

	}

	public static int getCount(int r, int c, int d) {

		int[] x = { 0, 1, 0, -1 };
		int[] y = { -1, 0, 1, 0 };
		int cnt = 0;
		int nr, nc;

		while (true) {

			if (map[r][c] == 0) {
				cnt++;
				map[r][c] = -1;
			}

			boolean find = false;

			for (int i = 0; i < 4; i++) {
				nr = r + y[(d + 3) % 4];
				nc = c + x[(d + 3) % 4];

				if (map[nr][nc] == 0) {
					find = true;
					d = (d + 3) % 4;
					r = nr; // 이동
					c = nc;
					break;
				}
				d = (d + 3) % 4;
			}

			if (find)
				continue;

			nr = r + y[(d + 2) % 4];
			nc = c + x[(d + 2) % 4];

			if (map[nr][nc] == 1)
				return cnt;

			r = nr; // 이동
			c = nc;

		}
	}
}
