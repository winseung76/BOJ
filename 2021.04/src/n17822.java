import java.io.*;
import java.util.*;

public class n17822 {

	static int N, M, T;
	static int[][] circle;
	static Command[] cmd;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		T = Integer.parseInt(input[2]);

		circle = new int[N + 1][M + 1];
		cmd = new Command[T];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				circle[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		for (int i = 0; i < T; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
			cmd[i] = new Command(x, d, k);
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		for (int t = 0; t < T; t++) {
			Command c = cmd[t];
			int x = c.x;
			int d = c.d;
			int k = c.k;

			for (int m = x; m <= N; m += x) {

				int[] tmp = new int[M + 1];

				if (d == 0) { // 시계 방향
					for (int j = 1; j <= M; j++) {
						tmp[(j - 1 + k) % M + 1] = circle[m][j];
					}
				}

				else if (d == 1) { // 반시계 방향
					for (int j = 1; j <= M; j++) {
						tmp[(j - 1 - (k % M) + M) % M + 1] = circle[m][j];
					}
				}

				for (int j = 1; j <= M; j++) {
					circle[m][j] = tmp[j];
				}
			}

			Set<Pos> set = new HashSet<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (circle[i][j] > 0) {
						int nj = (j + 1) <= M ? j + 1 : 1;
						if (circle[i][nj] == circle[i][j]) {
							set.add(new Pos(i, nj));
						}

						nj = (j - 1) >= 1 ? j - 1 : M;
						if (circle[i][nj] == circle[i][j]) {
							set.add(new Pos(i, nj));
						}

						if (i + 1 <= N && circle[i + 1][j] == circle[i][j]) {
							set.add(new Pos(i + 1, j));
						}

						if (i - 1 >= 1 && circle[i - 1][j] == circle[i][j]) {
							set.add(new Pos(i - 1, j));
						}
					}

				}
			}

			if (set.size() == 0) { // 집합의 크기가 0인 경우
				int sum = 0;
				int cnt = 0;

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (circle[i][j] > 0) {
							sum += circle[i][j];
							cnt++;
						}
					}
				}

				double avg = (double) sum / (double) cnt;

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (circle[i][j] > 0) {

							if (circle[i][j] < avg)
								circle[i][j]++;

							else if (circle[i][j] > avg)
								circle[i][j]--;
						}
					}
				}
			}

			else {  // 집합의 크기가 0이 아닌경우

				Iterator<Pos> it = set.iterator();
				while (it.hasNext()) {
					Pos pos = it.next();
					circle[pos.i][pos.j] = 0;
				}
			}

		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum += circle[i][j];
			}
		}

		return sum;
	}

	static class Pos {

		int i, j;

		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Command {

		int x, d, k;

		Command(int x, int d, int k) {
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}

}
