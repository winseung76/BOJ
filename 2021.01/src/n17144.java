import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n17144 {

	static int R, C, T;
	static int[][] room;
	static Pos up, down;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		R = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);
		T = Integer.parseInt(sarr[2]);

		room = new int[R][C];

		for (int i = 0; i < R; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(sarr[j]);
				if (room[i][j] == -1) {
					if (up == null)
						up = new Pos(i, j);
					else
						down = new Pos(i, j);
				}
			}
		}

		int t = 0;
		while (t < T) {
			expandDust();
			machineWork();
			t++;
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0)
					sum += room[i][j];
			}
		}
		bw.write(sum + "\n");
		bw.flush();
	}

	public static void expandDust() {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		int[][] tmp = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (room[i][j] > 0) {

					int cnt = 0;

					for (int k = 0; k < 4; k++) {
						int nr = i + r[k];
						int nc = j + c[k];
						if ((0 <= nr && nr < R) && (0 <= nc && nc < C) && room[nr][nc] >= 0) {
							tmp[nr][nc] += room[i][j] / 5;
							cnt++;
						}
					}

					room[i][j] = room[i][j] - (room[i][j] / 5) * cnt;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (tmp[i][j] > 0) {
					room[i][j] += tmp[i][j];
				}
			}
		}

	}

	public static void machineWork() {

		// 공기청정기 위
		for (int i = up.r - 2; i >= 0; i--)
			room[i + 1][0] = room[i][0];

		for (int i = 1; i < C; i++)
			room[0][i - 1] = room[0][i];

		for (int i = 1; i <= up.r; i++)
			room[i - 1][C - 1] = room[i][C - 1];

		for (int i = C - 2; i >= 1; i--)
			room[up.r][i + 1] = room[up.r][i];
		room[up.r][1] = 0;

		// 공기청정기 아래
		for (int i = down.r + 2; i < R; i++)
			room[i - 1][0] = room[i][0];

		for (int i = 1; i < C; i++)
			room[R - 1][i - 1] = room[R - 1][i];

		for (int i = R - 2; i >= down.r; i--)
			room[i + 1][C - 1] = room[i][C - 1];

		for (int i = C - 2; i >= 1; i--)
			room[down.r][i + 1] = room[down.r][i];
		room[down.r][1] = 0;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
