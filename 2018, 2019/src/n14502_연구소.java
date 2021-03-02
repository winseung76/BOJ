import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n14502_¿¬±¸¼Ò {
	private static Queue<Pair> q = new LinkedList<>();
	private static boolean[][] isvisited;
	private static int[][] arr, tmp;
	private static int N, M;
	private static int zero_count = 0;
	private static int max = 0;
	private static ArrayList<Pair> list = new ArrayList<>();
	private static int org_zero;
	private static int[] x = { 0, 0, -1, 1 };
	private static int[] y = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		tmp = new int[N][M];
		isvisited = new boolean[N][M];
		zero_count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 0)
					zero_count++;
				else if (arr[i][j] == 1) {
					isvisited[i][j] = true;
				} else if (arr[i][j] == 2) {
					isvisited[i][j] = true;
					list.add(new Pair(i, j));
				}
			}
		}
		org_zero = zero_count;
		setWalls(0);
		System.out.println(max);

	}

	public static void setWalls(int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < arr.length; i++)
				System.arraycopy(arr[i], 0, tmp[i], 0, arr[i].length);
			isvisited = new boolean[N][M];
			zero_count = org_zero - 3;

			for (int i = 0; i < list.size(); i++)
				bfs(list.get(i).r, list.get(i).c);
			max = Math.max(max, zero_count);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					setWalls(cnt + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	public static void bfs(int r, int c) {

		q.add(new Pair(r, c));
		isvisited[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M && !isvisited[nr][nc] && tmp[nr][nc] == 0) {
					zero_count--;
					isvisited[nr][nc] = true;
					tmp[nr][nc] = 2;
					q.add(new Pair(nr, nc));
				}
			}
		}
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
