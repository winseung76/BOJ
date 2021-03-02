import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n04963_¼¶ÀÇ°³¼ö {
	private static int[][] arr;
	private static boolean[][] isvisited;
	private static int w, h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while ((w = sc.nextInt()) != 0 && (h = sc.nextInt()) != 0) {
			arr = new int[h][w];
			isvisited = new boolean[h][w];
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 0)
						isvisited[i][j] = true;
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!isvisited[i][j])
						count += bfs(j, i);
				}
			}
			System.out.println(count);
		}

	}

	public static int bfs(int nx, int ny) {
		Queue<Pair> q = new LinkedList<>();
		int[] y = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] x = { -1, 0, 1, -1, 1, -1, 0, 1 };

		isvisited[ny][nx] = true;
		q.offer(new Pair(nx, ny));

		while (!q.isEmpty()) {
			Pair pair = q.poll();

			for (int i = 0; i < 8; i++) {
				int c = pair.x + x[i];
				int r = pair.y + y[i];
				if (0 <= r && r < h && 0 <= c && c < w && !isvisited[r][c]) {
					isvisited[r][c] = true;
					q.offer(new Pair(c, r));
				}
			}
		}
		return 1;
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
