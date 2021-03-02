import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n02178_¹Ì·ÎÅ½»ö {
	private static boolean[][] isvisited;
	private static int[][] dist;
	private static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		isvisited = new boolean[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) - '0' == 0) {
					isvisited[i][j] = true;
				}
			}
		}
		System.out.println(bfs(0, 0));
	}

	public static int bfs(int nx, int ny) {
		Queue<Point> q = new LinkedList();
		int[] x = { 1, 0, -1, 0 };
		int[] y = { 0, 1, 0, -1 };

		q.offer(new Point(nx, ny));
		isvisited[nx][ny] = true;
		dist[nx][ny] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == N - 1 && p.y == M - 1)
				return dist[p.x][p.y];

			for (int i = 0; i < 4; i++) {
				int new_x = p.x + x[i];
				int new_y = p.y + y[i];
				if ((new_x >= 0 && new_x < N) && (new_y >= 0 && new_y < M)) {
					if (!isvisited[new_x][new_y]) {
						q.offer(new Point(new_x, new_y));
						isvisited[new_x][new_y] = true;
						dist[new_x][new_y] = dist[p.x][p.y] + 1;
					}
				}

			}
		}
		return -1;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
