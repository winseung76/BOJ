import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n02146_다리_만들기 {
	static int[][] map;
	static boolean[][] isvisited;
	static int N;
	static int res = Integer.MAX_VALUE;
	static int[] x = { 0, 1, 0, -1 };
	static int[] y = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(arr[j]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					isvisited = new boolean[N][N];
					sameLand(i, j); // 같은 섬에 속하는 위치들의 isvisited를 true로 변경
					bfs(i, j);
				}
			}
		}
		if (res == Integer.MAX_VALUE)
			res = 0;

		bw.write(res + "\n");
		bw.flush();
	}

	public static void bfs(int sn, int sm) {
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(sn, sm, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int n = p.n + y[i];
				int m = p.m + x[i];

				if ((0 <= n && n < N) && (0 <= m && m < N)) {

					if (map[n][m] == 0 && !isvisited[n][m]) {
						isvisited[n][m] = true;
						q.add(new Pair(n, m, p.count + 1));
					}

					else if (map[n][m] == 1 && p.count > 0 && !isvisited[n][m])
						res = Math.min(res, p.count);
				}
			}
		}
	}

	public static void sameLand(int sn, int sm) {

		isvisited[sn][sm] = true;

		for (int i = 0; i < 4; i++) {
			int n = sn + y[i];
			int m = sm + x[i];

			if ((0 <= n && n < N) && (0 <= m && m < N)) {
				if (map[n][m] == 1 && !isvisited[n][m])
					sameLand(n, m);
			}
		}
	}

	static class Pair {
		int n, m, count;

		Pair(int n, int m, int count) {
			this.n = n;
			this.m = m;
			this.count = count;
		}
	}
}
