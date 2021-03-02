import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10159 {

	static int N, M;
	static int[][] arr;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			arr[b][a] = 1;
		}

		floydWarshall();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (0 < arr[i][j] && arr[i][j] < INF)
					arr[j][i] = -arr[i][j];
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (i != j && arr[i][j] == INF)
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();

	}

	public static void floydWarshall() {

		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					arr[s][e] = Math.min(arr[s][e], arr[s][k] + arr[k][e]);
				}
			}
		}

	}

}
