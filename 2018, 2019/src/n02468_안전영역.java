import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n02468_안전영역 {
	private static boolean[][] isvisited;
	private static int[][] arr;
	private static int N;
	private static int[] x = { 0, 0, 1, -1 };
	private static int[] y = { 1, -1, 0, 0 };
	private static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][N];
		int max_height = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				max_height = Math.max(max_height, arr[i][j]);
			}
		}
		res = new int[max_height];

		for (int k = 0; k <= max_height; k++) {
			isvisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= k)
						isvisited[i][j] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isvisited[i][j])
						res[k] += bfs(i, j);
				}
			}
		}

		Arrays.sort(res);
		System.out.println(res[res.length - 1]);

	}

	public static int bfs(int r, int c) {
		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(r, c));
		isvisited[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < N && !isvisited[nr][nc]) {
					q.offer(new Pair(nr, nc));
					isvisited[nr][nc] = true;
				}
			}
		}
		return 1;
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
