import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01613 {

	static int n, m, s;
	static int[][] dist;
	static final int INF = 99999;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		n = Integer.parseInt(sarr[0]);
		m = Integer.parseInt(sarr[1]);

		dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			dist[a][b] = 1;

		}

		floydWarshall();

		s = Integer.parseInt(br.readLine());

		for (int i = 0; i < s; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			if (a == b || (dist[a][b] == INF && dist[b][a] == INF))
				bw.write(0 + "\n");

			else if (dist[a][b] == INF && (0 < dist[b][a] && dist[b][a] < INF))
				bw.write(1 + "\n");

			else if (dist[b][a] == INF && (0 < dist[a][b] && dist[a][b] < INF))
				bw.write(-1 + "\n");

		}

		bw.flush();

	}

	public static void floydWarshall() {

		for (int k = 1; k <= n; k++) {
			for (int s = 1; s <= n; s++) {
				for (int e = 1; e <= n; e++) {
					dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
				}
			}
		}
	}
}
