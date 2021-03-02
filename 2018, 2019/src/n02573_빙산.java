import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n02573_ºù»ê {
	static int[][] arr;
	static int[][] arr2;
	static boolean[][] isvisited;
	static int N, M;
	static int year;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		while (true) {

			arr2 = new int[N][M];
			isvisited = new boolean[N][M];
			after2Year();
			for (int i = 0; i < N; i++)
				System.arraycopy(arr2[i], 0, arr[i], 0, M);

			year++;

			int iceberg = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr2[i][j] != 0 && !isvisited[i][j]) {
						iceberg += dfs(new Pair(i, j));
					}
				}
			}
			if (iceberg > 1)
				break;

			if (iceberg == 0) {
				year = 0;
				break;
			}

		}
		bw.write(year + "\n");
		bw.flush();

	}

	public static void after2Year() {

		int count = 0;
		int[] x = { 0, -1, 0, 1 };
		int[] y = { 1, 0, -1, 0 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (arr[i][j] != 0) {
					count = 0;
					for (int k = 0; k < 4; k++) {
						int n = i + y[k];
						int m = j + x[k];

						if ((0 <= n && n < N) && (0 <= m && m < M) && arr[n][m] == 0)
							count++;
					}
					arr2[i][j] = Math.max(0, arr[i][j] - count);
				} else
					arr2[i][j] = 0;
			}
		}
	}

	public static int dfs(Pair p) {
		Stack<Pair> s = new Stack<>();
		int[] x = { 0, -1, 0, 1 };
		int[] y = { 1, 0, -1, 0 };

		s.push(p);
		isvisited[p.n][p.m] = true;

		while (!s.isEmpty()) {
			Pair pair = s.pop();

			for (int i = 0; i < 4; i++) {
				int n = pair.n + y[i];
				int m = pair.m + x[i];

				if ((0 <= n && n < N) && (0 <= m && m < M) && arr2[n][m] != 0 && !isvisited[n][m]) {
					dfs(new Pair(n, m));
				}
			}
		}
		return 1;
	}

	static class Pair {
		int n, m;

		Pair(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

}
