import java.io.*;
import java.util.*;

public class n20058 {

	static int N, Q;
	static int[][] A;
	static int size;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		Q = Integer.parseInt(input[1]);

		size = (int) Math.pow(2, N);
		A = new int[size][size];
		visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				A[i][j] = Integer.parseInt(input[j]);
			}
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < Q; i++) {
			list.add(Integer.parseInt(input[i]));
		}

		rotate();

		int sum = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				sum += A[r][c];
			}
		}

		int max = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (!visited[r][c] && A[r][c] > 0) {
					max = Math.max(max, bfs(r, c));
				}
			}
		}

		bw.write(sum + "\n");
		bw.write(max + "\n");
		bw.flush();
	}

	public static void rotate() {

		for (int l : list) {

			int n = (int) Math.pow(2, l);

			for (int r = 0; r < size; r += n) {
				for (int c = 0; c < size; c += n) {

					int[][] tmp = new int[n][n];

					int nr = 0;
					for (int j = c; j < c + n; j++) {
						int nc = 0;
						for (int i = r + n - 1; i >= r; i--) {
							tmp[nr][nc++] = A[i][j];
						}
						nr++;
					}

					nr = 0;
					for (int i = r; i < r + n; i++) {
						int nc = 0;
						for (int j = c; j < c + n; j++) {
							A[i][j] = tmp[nr][nc++];
						}
						nr++;
					}

				}

			}
			
			reduceIce();
			/*
			 * System.out.println("before : "); for (int r = 0; r < size; r++) { for (int c
			 * = 0; c < size; c++) { System.out.print(A[r][c] + " "); }
			 * System.out.println(); } System.out.println();
			 * 
			 * reduceIce();
			 * 
			 * System.out.println("after : "); for (int r = 0; r < size; r++) { for (int c =
			 * 0; c < size; c++) { System.out.print(A[r][c] + " "); } System.out.println();
			 * } System.out.println();
			 */
		}
	}

	public static void reduceIce() {

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		boolean[][] tmp = new boolean[size][size];

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {

				if (A[r][c] > 0) {
					int cnt = 0;

					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];

						if ((0 <= nr && nr < size) && (0 <= nc && nc < size) && A[nr][nc] > 0)
							cnt++;
					}

					if (cnt < 3)
						tmp[r][c] = true;
				}
			}
		}

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (tmp[r][c]) {
					A[r][c]--;
				}
			}
		}

	}

	public static int bfs(int r, int c) {

		int cnt = 0;

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();

		visited[r][c] = true;
		q.offer(new Pos(r, c));

		while (!q.isEmpty()) {

			Pos pos = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if ((0 <= nr && nr < size) && (0 <= nc && nc < size) && !visited[nr][nc] && A[nr][nc] > 0) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}

		return cnt;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
