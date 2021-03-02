import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n10026_적록색약 {
	private static boolean[][] isvisited;
	private static char[][] color;
	private static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int result1 = 0, result2 = 0;
		n = sc.nextInt();
		isvisited = new boolean[n][n];
		color = new char[n][n];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++)
				color[i][j] = str.charAt(j);

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isvisited[i][j]) {
					isvisited[i][j] = true;
					result1 += bfs(i, j, false);
				}
			}
		}
		isvisited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isvisited[i][j]) {
					isvisited[i][j] = true;
					result2 += bfs(i, j, true);
				}
			}
		}
		System.out.println(result1 + " " + result2);

	}

	public static int bfs(int nx, int ny, boolean cw) {

		Queue<Point> q = new LinkedList<>();
		char p_color = color[nx][ny];
		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, -1, 0, 1 };
		int count = 0;

		q.add(new Point(nx, ny));

		while (!q.isEmpty()) {

			Point p = q.poll();
			count++;

			for (int i = 0; i < 4; i++) {
				int new_x = p.x + x[i];
				int new_y = p.y + y[i];

				if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && !isvisited[new_x][new_y]) {
					char new_color = color[new_x][new_y];

					if (cw) { // 적록색약인 경우
						if ((p_color != 'B' && new_color != 'B') || (p_color == 'B' && new_color == 'B')) {
							isvisited[new_x][new_y] = true;
							q.add(new Point(new_x, new_y));
						}

					}

					else { // 적록색약이 아닌 경우
						if (new_color == p_color) {
							isvisited[new_x][new_y] = true;
							q.add(new Point(new_x, new_y));
						}
					}

				}
			}
		}

		return 1;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
