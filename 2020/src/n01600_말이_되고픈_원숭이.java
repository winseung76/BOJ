import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01600_¸»ÀÌ_µÇ°íÇÂ_¿ø¼þÀÌ {

	static int K, W, H;
	static int[][] board;
	static int[][] move;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		W = Integer.parseInt(arr[0]);
		H = Integer.parseInt(arr[1]);
		board = new int[H][W];
		move = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int h = 0; h < H; h++) {
			arr = br.readLine().split(" ");
			for (int w = 0; w < W; w++) {
				board[h][w] = Integer.parseInt(arr[w]);
				if (h == 0 && w == 0)
					move[h][w] = 0;
				else
					move[h][w] = Integer.MAX_VALUE;
			}
		}
		bfs();

		if (move[H - 1][W - 1] == Integer.MAX_VALUE)
			move[H - 1][W - 1] = -1;

		bw.write(move[H - 1][W - 1] + "\n");
		bw.flush();

	}

	static void bfs() {

		Queue<Pos> q = new LinkedList<>();
		int[] mh = { 1, 0, -1, 0 };
		int[] mw = { 0, 1, 0, -1 };
		int[] hh = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] hw = { -2, -1, 1, 2, -2, -1, 1, 2 };

		q.add(new Pos(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {

			Pos p = q.poll();
			if (p.h == H - 1 && p.w == W - 1)
				break;

			// System.out.println(p.h + " " + p.w + " : " + p.cnt + " " + p.horse);

			for (int i = 0; i < 4; i++) {
				int nw = p.w + mw[i];
				int nh = p.h + mh[i];
				if ((0 <= nw && nw < W) && (0 <= nh && nh < H) && board[nh][nw] == 0 && !visited[nh][nw][p.horse]) {
					q.add(new Pos(nh, nw, p.cnt + 1, p.horse));
					move[nh][nw] = p.cnt + 1;
					visited[nh][nw][p.horse] = true;
				}
			}
			if (p.horse < K) {

				for (int i = 0; i < 8; i++) {
					int nw = p.w + hw[i];
					int nh = p.h + hh[i];
					if ((0 <= nw && nw < W) && (0 <= nh && nh < H) && board[nh][nw] == 0
							&& !visited[nh][nw][p.horse + 1]) {
						q.add(new Pos(nh, nw, p.cnt + 1, p.horse + 1));
						move[nh][nw] = p.cnt + 1;
						visited[nh][nw][p.horse + 1] = true;
					}
				}
			}
		}
	}

	static class Pos {
		int h, w, cnt, horse;

		Pos(int h, int w, int cnt, int horse) {
			this.w = w;
			this.h = h;
			this.cnt = cnt;
			this.horse = horse;
		}
	}
}
