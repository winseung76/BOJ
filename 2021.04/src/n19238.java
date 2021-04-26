import java.io.*;
import java.util.*;

public class n19238 {

	static int N, M, fuel;
	static int[][] map;
	static Pos start;
	static Guest[] guest;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		fuel = Integer.parseInt(input[2]);

		map = new int[N + 1][N + 1];
		guest = new Guest[M];
		dist = new int[M];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		input = br.readLine().split(" ");
		start = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int sr = Integer.parseInt(input[0]);
			int sc = Integer.parseInt(input[1]);
			int er = Integer.parseInt(input[2]);
			int ec = Integer.parseInt(input[3]);

			guest[i] = new Guest(new Pos(sr, sc), new Pos(er, ec));
		}

		for (int i = 0; i < M; i++) {
			int d = bfs(guest[i].start, guest[i].end);

			if (d == -1) {
				bw.write(-1 + "\n");
				bw.flush();
				return;
			}

			dist[i] = d;
		}

		if (solve())
			bw.write(fuel + "\n");
		else
			bw.write(-1 + "\n");

		bw.flush();
	}

	public static boolean solve() {

		Pos taxi = start;

		while (!isCompleted()) {

			int num = getPriorityGuest(taxi);

			if (num == -1) {
				return false;
			}

			fuel -= dist[num];

			if (fuel < 0)
				return false;

			fuel += dist[num] * 2;
			taxi.r = guest[num].end.r;
			taxi.c = guest[num].end.c;

			guest[num].complete = true;
		}

		return true;
	}

	public static boolean isCompleted() {

		for (int i = 0; i < M; i++) {
			if (!guest[i].complete) {
				return false;
			}
		}

		return true;
	}

	public static int getPriorityGuest(Pos taxi) {

		int min = Integer.MAX_VALUE;
		int num = -1;

		for (int i = 0; i < M; i++) {
			Guest g = guest[i];

			if (!g.complete) {
				int dist = bfs(taxi, g.start);

				if (dist == -1)
					return -1;

				if (min == dist) {
					if (guest[num].start.r == g.start.r) {
						if (guest[num].start.c > g.start.c) {
							min = dist;
							num = i;
						}
					}

					else if (guest[num].start.r > g.start.r) {
						min = dist;
						num = i;

					}
				}

				else if (min > dist) {
					min = dist;
					num = i;
				}
			}
		}

		fuel -= min;

		return num;

	}

	public static int bfs(Pos start, Pos end) {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<Pair> q = new LinkedList<>();

		visited[start.r][start.c] = true;
		q.offer(new Pair(start, 0));

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Pos p = pair.pos;

			if (p.r == end.r && p.c == end.c) {
				return pair.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && !visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.offer(new Pair(new Pos(nr, nc), pair.cnt + 1));
				}
			}
		}

		return -1;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Pair {

		Pos pos;
		int cnt;

		Pair(Pos pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
	}

	static class Guest {

		Pos start, end;
		boolean complete;

		Guest(Pos start, Pos end) {
			this.start = start;
			this.end = end;
			this.complete = false;
		}
	}

}
