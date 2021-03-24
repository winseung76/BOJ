import java.io.*;

public class n01719 {

	static int n, m;
	static int[][] dist, ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		dist = new int[n + 1][n + 1];
		ans = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			dist[a][b] = dist[b][a] = w;
			ans[a][b] = b;
			ans[b][a] = a;
		}

		floydWarshall();

		StringBuffer buf = new StringBuffer();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (ans[i][j] == 0)
					buf.append("- ");

				else {

					int t = j;
					while (ans[i][t] != t) {
						t = ans[i][t];
					}

					buf.append(ans[i][j] + " ");
				}
			}
			buf.append("\n");
		}

		bw.write(buf.toString());
		bw.flush();

	}

	public static void floydWarshall() {

		for (int t = n; t >= 1; t--) {
			for (int s = 1; s <= n; s++) {
				for (int e = 1; e <= n; e++) {
					if (dist[s][e] > dist[s][t] + dist[t][e]) {
						dist[s][e] = dist[s][t] + dist[t][e];
						ans[s][e] = t;
					}
				}
			}
		}
	}

}
