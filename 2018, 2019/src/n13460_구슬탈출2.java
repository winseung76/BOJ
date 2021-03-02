import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n13460_구슬탈출2 {
	private static char[][] graph;
	private static int N, M;
	private static int count = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		graph = new char[N][M];

		Pos redPos = null, bluePos = null;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = str.charAt(j);
				if (str.charAt(j) == 'R')
					redPos = new Pos(i, j, 0);
				if (str.charAt(j) == 'B')
					bluePos = new Pos(i, j, 0);
			}
		}

		bfs(redPos, bluePos);

		bw.write(count + "\n");
		bw.flush();

	}

	public static void bfs(Pos red, Pos blue) {
		Queue<Pos> red_queue = new LinkedList<>();
		Queue<Pos> blue_queue = new LinkedList<>();
		boolean redflag = false;
		boolean blueflag = false;

		int[] x = { 1, 0, -1, 0 };
		int[] y = { 0, 1, 0, -1 };

		red_queue.add(red);
		blue_queue.add(blue);

		while (!red_queue.isEmpty() && !blue_queue.isEmpty()) {

			Pos p1 = red_queue.poll();
			Pos p2 = blue_queue.poll();

			if (p1.count < 10) {

				// 상,하,좌,우 4가지 경우
				for (int i = 0; i < 4; i++) {

					Pos redPos = new Pos(p1.n, p1.m, p1.count);
					Pos bluePos = new Pos(p2.n, p2.m, p2.count);
					graph[redPos.n][redPos.m] = 'R';
					graph[bluePos.n][bluePos.m] = 'B';

					redflag = false;
					blueflag = false;

					// 한번 기울이면 장애물을 만날때까지는 계속 이동하므로 while문을 사용
					while (true) {

						if (graph[redPos.n + y[i]][redPos.m + x[i]] == 'O') {
							redflag = true;
							graph[redPos.n][redPos.m] = '.';
							redPos.n = redPos.n + y[i];
							redPos.m = redPos.m + x[i];
						}

						// 파란구슬이 구멍에 빠지면 기우는 것을 멈춤
						if (graph[bluePos.n + y[i]][bluePos.m + x[i]] == 'O') {
							blueflag = true;
							break;
						}
						// 빨간구슬, 파란구슬 둘 다 움직일 수 없는 경우 멈춤
						// 파란구슬이 장애물(벽,빨간구슬)에 막히고, 빨간구슬도 장애물에 막히거나 빨간구슬이 구멍이 빠진 경우
						if ((graph[redPos.n + y[i]][redPos.m + x[i]] != '.' || redflag)
								&& graph[bluePos.n + y[i]][bluePos.m + x[i]] != '.')
							break;

						if (graph[redPos.n + y[i]][redPos.m + x[i]] == '.' && !redflag) {
							graph[redPos.n][redPos.m] = '.';
							redPos.n = redPos.n + y[i];
							redPos.m = redPos.m + x[i];
							graph[redPos.n][redPos.m] = 'R';
						}
						if (graph[bluePos.n + y[i]][bluePos.m + x[i]] == '.') {
							graph[bluePos.n][bluePos.m] = '.';
							bluePos.n = bluePos.n + y[i];
							bluePos.m = bluePos.m + x[i];
							graph[bluePos.n][bluePos.m] = 'B';
						}
					}

					if (redflag && !blueflag) {
						count = p1.count + 1;
						return;
					}

					if (blueflag)
						count = -1;
					else {
						red_queue.add(new Pos(redPos.n, redPos.m, p1.count + 1));
						blue_queue.add(new Pos(bluePos.n, bluePos.m, p2.count + 1));
					}

					if (graph[redPos.n][redPos.m] == 'R')
						graph[redPos.n][redPos.m] = '.';
					if (graph[bluePos.n][bluePos.m] == 'B')
						graph[bluePos.n][bluePos.m] = '.';
				}
			} else
				count = -1;
		}
	}

	static class Pos {

		int n, m, count;

		Pos(int n, int m, int count) {
			this.n = n;
			this.m = m;
			this.count = count;
		}
	}
}
