import java.io.*;

public class n10971 {

	static int N;
	static int[][] w;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		w = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				w[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}

		visited[1] = true;
		dfs(1, 1, 0);

		bw.write(min + "\n");
		bw.flush();

	}

	public static void dfs(int start, int now, int cost) {

		if (now == start && cost > 0) {

			min = Math.min(min, cost);
			return;
		}

		for (int n = 1; n <= N; n++) {

			if (w[now][n] > 0) {

				if (n == start) {
					boolean flag = true;
					for (int i = 1; i <= N; i++) {
						if (!visited[i]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						cost += w[now][n];
						dfs(start, n, cost);
					}
				}

				else if (!visited[n]) {
					visited[n] = true;
					cost += w[now][n];

					dfs(start, n, cost);

					cost -= w[now][n];
					visited[n] = false;
				}
			}
		}
	}

}
