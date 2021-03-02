import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n02589_º¸¹°¼¶ {
	static char[][] map;
	static boolean[][] isvisited;
	static int N, M;
	static int max = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N][M];
		isvisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					isvisited = new boolean[N][M];
					max = Math.max(max, bfs(new Pair(i, j, 0)));
				}
			}
		}
		bw.write(max + "\n");
		bw.flush();
	}

	public static int bfs(Pair sp) {

		Queue<Pair> q = new LinkedList<>();
		Pair p = null;
		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };

		isvisited[sp.n][sp.m] = true;
		q.add(sp);

		while (!q.isEmpty()) {

			p = q.poll();

			for (int i = 0; i < 4; i++) {
				int n = p.n + y[i];
				int m = p.m + x[i];

				if (0 <= n && n < N && 0 <= m && m < M) {
					if (map[n][m] == 'L' && !isvisited[n][m]) {
						isvisited[n][m] = true;
						q.add(new Pair(n, m, p.count + 1));
					}
				}
			}
		}
		return p.count;
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
