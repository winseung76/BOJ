import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n17406 {

	static int N, M, K;
	static int[][] A;
	static Pair[] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		A = new int[N + 1][M + 1];
		arr = new Pair[K];
		visited = new boolean[K];

		for (int i = 1; i <= N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}

		for (int i = 0; i < K; i++) {
			sarr = br.readLine().split(" ");
			int r = Integer.parseInt(sarr[0]);
			int c = Integer.parseInt(sarr[1]);
			int s = Integer.parseInt(sarr[2]);

			arr[i] = new Pair(r, c, s);
		}

		comb(0);

		bw.write(min + "\n");
		bw.flush();

	}

	public static void comb(int cnt) {

		if (cnt == K) {
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += A[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}

		int[][] tmp = new int[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			if (!visited[i]) {

				visited[i] = true;
				for (int j = 0; j < N + 1; j++)
					System.arraycopy(A[j], 0, tmp[j], 0, M + 1);

				operate(arr[i]);

				comb(cnt + 1);

				visited[i] = false;
				for (int j = 0; j < N + 1; j++)
					System.arraycopy(tmp[j], 0, A[j], 0, M + 1);
			}
		}
	}

	public static void operate(Pair pair) {

		int sr = pair.r - pair.s;
		int sc = pair.c - pair.s;
		int er = pair.r + pair.s;
		int ec = pair.c + pair.s;

		while (sr < er && sc < ec) {

			int tmp = A[sr][sc];

			for (int r = sr + 1; r <= er; r++) {
				A[r - 1][sc] = A[r][sc];
			}

			for (int c = sc + 1; c <= ec; c++) {
				A[er][c - 1] = A[er][c];
			}

			for (int r = er - 1; r >= sr; r--) {
				A[r + 1][ec] = A[r][ec];
			}

			for (int c = ec - 1; c > sc; c--) {
				A[sr][c + 1] = A[sr][c];
			}

			A[sr][sc + 1] = tmp;

			sr = sr + 1;
			sc = sc + 1;
			er = er - 1;
			ec = ec - 1;
		}

	}

	static class Pair {

		int r, c, s;

		Pair(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

}
