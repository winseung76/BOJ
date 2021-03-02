import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01956 {

	static int V, E;
	static int[][] dist;
	static int min = Integer.MAX_VALUE;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		V = Integer.parseInt(sarr[0]);
		E = Integer.parseInt(sarr[1]);

		dist = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dist[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			int c = Integer.parseInt(sarr[2]);

			dist[a][b] = c;
		}

		floydWarshall();

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i != j && dist[i][j] < INF && dist[j][i] < INF)
					min = Math.min(min, dist[i][j] + dist[j][i]);
			}
		}

		if (min >= INF)
			min = -1;

		bw.write(min + "\n");
		bw.flush();

	}

	public static void floydWarshall() {

		for (int t = 1; t <= V; t++) {
			for (int s = 1; s <= V; s++) {
				for (int e = 1; e <= V; e++) {
					dist[s][e] = Math.min(dist[s][e], dist[s][t] + dist[t][e]);
				}
			}
		}
	}
}
