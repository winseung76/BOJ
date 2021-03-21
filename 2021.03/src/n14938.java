import java.io.*;

public class n14938 {

	static int n, m, r;
	static int[] arr;
	static int[][] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		n = Integer.parseInt(sarr[0]);
		m = Integer.parseInt(sarr[1]);
		r = Integer.parseInt(sarr[2]);

		arr = new int[n + 1];
		dist = new int[n + 1][n + 1];

		sarr = br.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(sarr[i - 1]);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < r; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			int l = Integer.parseInt(sarr[2]);

			dist[a][b] = dist[b][a] = l;
		}

		floydWarshall();

		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = arr[i];
			for (int j = 1; j <= n; j++) {
				if (i != j && dist[i][j] <= m)
					sum += arr[j];
			}
			max = Math.max(max, sum);
		}

		bw.write(max + "\n");
		bw.flush();
	}

	public static void floydWarshall() {

		for (int t = 1; t <= n; t++) {
			for (int s = 1; s <= n; s++) {
				for (int e = 1; e <= n; e++) {
					dist[s][e] = Math.min(dist[s][e], dist[s][t] + dist[t][e]);
				}
			}
		}

	}
}
