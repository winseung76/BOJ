import java.io.*;
import java.util.*;

public class n17141 {

	static int N, M;
	static int[][] board;
	static List<Pos> virus = new ArrayList<>();
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(input[j]);

				if (board[i][j] == 2) {
					virus.add(new Pos(i, j));
				}
			}
		}

		solve(new ArrayList<>(), 0);

		if (res == Integer.MAX_VALUE)
			bw.write(-1 + "\n");
		else
			bw.write(res + "\n");
		bw.flush();

	}

	public static void solve(List<Pos> list, int idx) {

		if (list.size() == M) {
			res = Math.min(res, bfs(list));
			return;
		}

		for (int i = idx; i < virus.size(); i++) {
			Pos pos = virus.get(i);

			if (!list.contains(pos)) {
				list.add(pos);
				solve(list, i + 1);
				list.remove(pos);
			}
		}
	}

	public static int bfs(List<Pos> list) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		int max = 0;
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int[][] time = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				time[i][j] = -1;
			}
		}

		for (Pos pos : list) {
			q.offer(pos);
			visited[pos.r][pos.c] = true;
			time[pos.r][pos.c] = 0;
		}

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && board[nr][nc] != 1 && !visited[nr][nc]) {
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
					time[nr][nc] = time[pos.r][pos.c] + 1;
					max = Math.max(max, time[nr][nc]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 1 && time[i][j] == -1)
					return Integer.MAX_VALUE;
			}
		}

		return max;
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
