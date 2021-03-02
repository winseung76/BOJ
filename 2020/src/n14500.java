import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14500 {

	static int N, M;
	static int[][] map;
	static int max = 0;
	static Pos[] box = new Pos[4];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				getSum(new Pos(i, j), 1);
				getSum(new Pos(i, j), 2);
				getSum(new Pos(i, j), 3);
				getSum(new Pos(i, j), 4);
				getSum(new Pos(i, j), 5);
			}
		}
		bw.write(max + "\n");
		bw.flush();

	}

	public static void getSum(Pos s, int type) {

		int sum = 0;

		switch (type) {
		case 1:
			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r, s.c + 3);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r + 1, s.c);
			box[2] = new Pos(s.r + 2, s.c);
			box[3] = new Pos(s.r + 3, s.c);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c - 1);
			box[2] = new Pos(s.r, s.c - 2);
			box[3] = new Pos(s.r, s.c - 3);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r - 1, s.c);
			box[2] = new Pos(s.r - 2, s.c);
			box[3] = new Pos(s.r - 3, s.c);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			break;
		case 2:
			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r + 1, s.c);
			box[3] = new Pos(s.r + 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c - 1);
			box[2] = new Pos(s.r + 1, s.c);
			box[3] = new Pos(s.r + 1, s.c - 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r - 1, s.c);
			box[2] = new Pos(s.r, s.c - 1);
			box[3] = new Pos(s.r - 1, s.c - 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r - 1, s.c);
			box[2] = new Pos(s.r, s.c + 1);
			box[3] = new Pos(s.r - 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			break;
		case 3:
			box[1] = new Pos(s.r + 1, s.c);
			box[2] = new Pos(s.r + 2, s.c);
			box[3] = new Pos(s.r + 2, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r + 1, s.c);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r + 1, s.c + 2);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r + 1, s.c + 1);
			box[3] = new Pos(s.r + 2, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r - 1, s.c + 2);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r - 1, s.c);
			box[2] = new Pos(s.r, s.c + 1);
			box[3] = new Pos(s.r, s.c + 2);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r + 1, s.c);
			box[3] = new Pos(s.r + 2, s.c);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r - 1, s.c + 1);
			box[3] = new Pos(s.r - 2, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);
			break;
		case 4:
			box[1] = new Pos(s.r + 1, s.c);
			box[2] = new Pos(s.r + 1, s.c + 1);
			box[3] = new Pos(s.r + 2, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r - 1, s.c + 1);
			box[3] = new Pos(s.r - 1, s.c + 2);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r + 1, s.c);
			box[2] = new Pos(s.r, s.c + 1);
			box[3] = new Pos(s.r - 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r + 1, s.c + 1);
			box[3] = new Pos(s.r + 1, s.c + 2);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);
			break;
		case 5:
			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r - 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r - 1, s.c);
			box[2] = new Pos(s.r - 2, s.c);
			box[3] = new Pos(s.r - 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r, s.c + 2);
			box[3] = new Pos(s.r + 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}
			max = Math.max(max, sum);

			box[1] = new Pos(s.r, s.c + 1);
			box[2] = new Pos(s.r - 1, s.c + 1);
			box[3] = new Pos(s.r + 1, s.c + 1);
			if (box[1].check() && box[2].check() && box[3].check()) {
				sum = map[s.r][s.c];
				for (int i = 1; i < 4; i++) {
					sum += map[box[i].r][box[i].c];
				}
			}

			max = Math.max(max, sum);
			break;
		}
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public boolean check() {
			if ((0 <= r && r < N) && (0 <= c && c < M))
				return true;

			return false;
		}
	}

}
