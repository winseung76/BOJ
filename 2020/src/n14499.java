import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14499 {

	static int N, M, K;
	static int[][] map;
	static int[][] dice = new int[4][3];
	static Pos pos = new Pos(0, 0);

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int x = Integer.parseInt(s[2]);
		int y = Integer.parseInt(s[3]);
		K = Integer.parseInt(s[4]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}

		pos.r = x;
		pos.c = y;

		int[] r = { 0, 0, -1, 1 };
		int[] c = { 1, -1, 0, 0 };

		s = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(s[i]);

			int nr = pos.r + r[n - 1];
			int nc = pos.c + c[n - 1];

			if ((0 <= nr && nr < N) && (0 <= nc && nc < M)) {
				switch (n) {
				case 1:
					int tmp = dice[1][2];
					for (int j = 1; j >= 0; j--) {
						dice[1][(j + 1) % 3] = dice[1][j];
					}
					dice[1][0] = dice[3][1];
					dice[3][1] = tmp;

					break;
				case 2:
					tmp = dice[1][0];
					for (int j = 1; j < 3; j++) {
						dice[1][(j - 1) % 3] = dice[1][j];
					}
					dice[1][2] = dice[3][1];
					dice[3][1] = tmp;
					break;
				case 3:
					tmp = dice[0][1];
					for (int j = 1; j < 4; j++) {
						dice[(j - 1) % 4][1] = dice[j][1];
					}
					dice[3][1] = tmp;
					break;
				case 4:
					tmp = dice[3][1];
					for (int j = 2; j >= 0; j--) {
						dice[(j + 1) % 4][1] = dice[j][1];
					}
					dice[0][1] = tmp;
					break;
				}

				if (map[nr][nc] > 0) {
					dice[3][1] = map[nr][nc];
					map[nr][nc] = 0;
				} else if (map[nr][nc] == 0)
					map[nr][nc] = dice[3][1];

				/*
				for (int m = 0; m < 4; m++) {
					for (int j = 0; j < 3; j++)
						System.out.print(dice[m][j]);
					System.out.println();
				}
				System.out.println();
				*/
				bw.write(dice[1][1] + "\n");

				pos.r = nr;
				pos.c = nc;
			}
		}
		bw.flush();

	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
