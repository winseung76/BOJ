import java.io.*;
import java.util.*;

public class n16948 {

	static int N;
	static Pos start, end;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		visited = new boolean[N][N];

		String[] input = br.readLine().split(" ");
		start = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		end = new Pos(Integer.parseInt(input[2]), Integer.parseInt(input[3]));

		bw.write(bfs() + "\n");
		bw.flush();

	}

	public static int bfs() {

		int[] r = { -2, -2, 0, 0, 2, 2 };
		int[] c = { -1, 1, -2, 2, -1, 1 };
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(start, 0));
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos pos = pair.pos;

			if (pos.r == end.r && pos.c == end.c) {
				return pair.cnt;
			}

			for (int i = 0; i < 6; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && !visited[nr][nc]) {
					q.offer(new Pair(new Pos(nr, nc), pair.cnt + 1));
					visited[nr][nc] = true;
				}
			}

		}

		return -1;
	}

	static class Pair {

		Pos pos;
		int cnt;

		Pair(Pos pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
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
