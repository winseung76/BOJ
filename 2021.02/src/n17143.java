import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n17143 {

	static int R, C, M;
	static Shark[][] board;
	static Vector<Shark> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		R = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);
		M = Integer.parseInt(sarr[2]);

		board = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");

			int r = Integer.parseInt(sarr[0]);
			int c = Integer.parseInt(sarr[1]);
			int s = Integer.parseInt(sarr[2]);
			int d = Integer.parseInt(sarr[3]);
			int z = Integer.parseInt(sarr[4]);

			Shark shark = new Shark(s, d, z);
			board[r][c] = shark;
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int fisherman = 1;
		int sum = 0;

		while (fisherman <= C) {

			for (int r = 1; r <= R; r++) {
				if (board[r][fisherman] != null) {
					sum += board[r][fisherman].z;
					board[r][fisherman] = null;
					break;
				}
			}

			sharkMove();
			fisherman++;

		}

		return sum;

	}

	public static void sharkMove() {

		Shark[][] tmp = new Shark[R + 1][C + 1];

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (board[r][c] != null) {
					Shark shark = board[r][c];
					int diff = 0;
					int nr = r;
					int nc = c;

					switch (shark.d) {
					case 1:
						diff = r - 1;
						if (diff >= shark.s)
							nr = r - shark.s;
						else {
							int n = Math.abs(r - shark.s - 1);
							int p = n / (R - 1);
							int rest = n % (R - 1);

							if (p % 2 == 1)
								nr = R - rest;
							else {
								shark.d = 2;
								nr = 1 + rest;
							}
						}
						break;
					case 2:
						diff = R - r;
						if (diff >= shark.s)
							nr = r + shark.s;
						else {
							int n = Math.abs(r + shark.s - R);
							int p = n / (R - 1);
							int rest = n % (R - 1);

							if (p % 2 == 1)
								nr = 1 + rest;
							else {
								shark.d = 1;
								nr = R - rest;
							}
						}
						break;
					case 3:
						diff = C - c;
						if (diff >= shark.s)
							nc = c + shark.s;
						else {
							int n = Math.abs(c + shark.s - C);
							int p = n / (C - 1);
							int rest = n % (C - 1);

							if (p % 2 == 1)
								nc = 1 + rest;
							else {
								shark.d = 4;
								nc = C - rest;
							}
						}
						break;
					case 4:
						diff = c - 1;
						if (diff >= shark.s)
							nc = c - shark.s;
						else {
							int n = Math.abs(c - shark.s - 1);
							int p = n / (C - 1);
							int rest = n % (C - 1);

							if (p % 2 == 1)
								nc = C - rest;
							else {
								shark.d = 3;
								nc = 1 + rest;
							}
						}
						break;
					}
					if (tmp[nr][nc] != null)
						tmp[nr][nc] = (tmp[nr][nc].z < shark.z) ? shark : tmp[nr][nc];
					else
						tmp[nr][nc] = shark;

					board[r][c] = null;
				}
			}
		}

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (board[r][c] == null)
					board[r][c] = tmp[r][c];
				else
					board[r][c] = (tmp[r][c].z < board[r][c].z) ? board[r][c] : tmp[r][c];
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

	static class Shark {

		int s, d, z;

		Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
