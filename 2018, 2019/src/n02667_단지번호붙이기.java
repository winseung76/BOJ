import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n02667_단지번호붙이기 {
	private static int[][] map;
	private static boolean[][] isvisited;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		isvisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !isvisited[i][j]) {
					list.add(bfs(i, j));
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

	}

	public static int bfs(int r, int c) {
		Queue<Pair> q = new LinkedList<>();
		int count = 1;
		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		q.offer(new Pair(r, c));
		isvisited[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 1 && !isvisited[nr][nc]) {
					q.offer(new Pair(nr, nc));
					isvisited[nr][nc] = true;
					count++;
				}
			}

		}

		return count;

	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
