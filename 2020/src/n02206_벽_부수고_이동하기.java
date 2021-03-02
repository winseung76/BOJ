import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n02206_벽_부수고_이동하기 {
	static int[][] map;
	static int[][] wallcnt;
	static int N, M, res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		map = new int[N][M];
		wallcnt = new int[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(s.substring(m, m + 1));
				wallcnt[n][m] = Integer.MAX_VALUE;
			}
		}

		res = move();
		bw.write(res + "\n");
		bw.flush();

	}

	public static int move() {

		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };

		Queue<Pos> q = new LinkedList<>();

		q.add(new Pos(0, 0, 1, 0));

		while (!q.isEmpty()) {

			Pos p = q.poll();

			if (p.n == N - 1 && p.m == M - 1) {
				return p.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int n = p.n + y[i];
				int m = p.m + x[i];

				if ((0 <= n && n < N) && (0 <= m && m < M)) {

					if (map[n][m] == 0 && p.breakWall <= 1 && wallcnt[n][m] > p.breakWall) {
						q.add(new Pos(n, m, p.cnt + 1, p.breakWall));
						wallcnt[n][m] = p.breakWall;
					}

					else if (map[n][m] == 1 && p.breakWall == 0 && wallcnt[n][m] > p.breakWall + 1) {
						q.add(new Pos(n, m, p.cnt + 1, p.breakWall + 1));
						wallcnt[n][m] = p.breakWall + 1;
					}
				}

			}

		}
		return -1;
	}

	static class Pos {
		int n, m;
		int cnt;
		int breakWall;

		Pos(int n, int m, int cnt, int breakWall) {
			this.n = n;
			this.m = m;
			this.cnt = cnt;
			this.breakWall = breakWall;
		}
	}
}
