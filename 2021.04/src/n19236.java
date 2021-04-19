import java.io.*;
import java.util.*;

public class n19236 {

	static int[][] size = new int[4][4];
	static int[][] direct = new int[4][4];
	static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(input[j * 2]);
				int d = Integer.parseInt(input[j * 2 + 1]);
				size[i][j] = n;
				direct[i][j] = d;
			}
		}

		int n = size[0][0];
		size[0][0] = 0;
		moveFish();
		solve(0, 0, n);

		bw.write(max + "\n");
		bw.flush();

	}

	public static void solve(int r, int c, int sum) {

		int d = direct[r][c];
		int nr = r + dr[d];
		int nc = c + dc[d];

		List<Pos> list = new ArrayList<>();

		while ((0 <= nr && nr < 4) && (0 <= nc && nc < 4)) {

			if (size[nr][nc] > 0) {
				list.add(new Pos(nr, nc));
			}
			nr = nr + dr[d];
			nc = nc + dc[d];
		}

		if (list.size() == 0) {
			max = Math.max(max, sum);
			return;
		}

		int[][] tmpSize = new int[4][4];
		int[][] tmpDirect = new int[4][4];
		for (int i = 0; i < 4; i++) {
			System.arraycopy(size[i], 0, tmpSize[i], 0, 4);
			System.arraycopy(direct[i], 0, tmpDirect[i], 0, 4);
		}

		for (int k = 0; k < list.size(); k++) {

			Pos pos = list.get(k);
			nr = pos.r;
			nc = pos.c;

			// 상어 이동
			int tmpn = size[nr][nc]; // 물고기의 원래 크기
			size[nr][nc] = 0; // 상어는 -1
			size[r][c] = -1;
			direct[r][c] = 0;
			sum += tmpn;

			moveFish();
			solve(nr, nc, sum);

			for (int i = 0; i < 4; i++) {
				System.arraycopy(tmpSize[i], 0, size[i], 0, 4);
				System.arraycopy(tmpDirect[i], 0, direct[i], 0, 4);
			}

			sum -= tmpn;

		}

	}

	public static void moveFish() {

		for (int i = 1; i <= 16; i++) {

			boolean flag = false;

			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {

					if (size[r][c] == i) {

						int rotate = 0;
						int d = direct[r][c];

						while (true) {

							if (rotate == 8) {
								flag = true;
								break;
							}

							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || size[nr][nc] == 0) {
								d = d % 8 + 1;
								rotate++;
								continue;
							}

							direct[r][c] = d;

							if (size[nr][nc] == -1) { // 이동한 곳에 물고기가 없으면
								size[nr][nc] = size[r][c];
								direct[nr][nc] = direct[r][c];
								size[r][c] = -1;
								direct[r][c] = 0;
							}

							else {
								int tmpSize = size[r][c];
								int tmpDirect = direct[r][c];
								size[r][c] = size[nr][nc];
								direct[r][c] = direct[nr][nc];
								size[nr][nc] = tmpSize;
								direct[nr][nc] = tmpDirect;
							}

							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
				if (flag)
					break;
			}
		}
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
