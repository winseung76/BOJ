import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02458 {

	static int N, M;
	static int[][] dist;
	static int cnt;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			dist[a][b] = 1;
		}

		solve();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j && dist[i][j] < INF)
					dist[j][i] = -dist[i][j];
			}
		}

		boolean flag;
		for (int i = 1; i <= N; i++) {
			flag = false;
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == INF) {
					flag = true;
					break;
				}
			}
			if (!flag)
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	public static void solve() {

		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					dist[s][e] = Math.min(dist[s][e], dist[s][t] + dist[t][e]);
				}
			}
		}
	}

}
