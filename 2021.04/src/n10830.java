import java.io.*;

public class n10830 {

	static int N;
	static long B;
	static int[][] A;
	static final int MOD = 1000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		B = Long.parseLong(input[1]);

		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(input[j]) % MOD;
			}
		}

		int[][] res = solve(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(res[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();

	}

	public static int[][] solve(long cnt) {

		if (cnt == 1) {
			return A;
		}

		int[][] res = solve(cnt / 2);

		if (cnt % 2 == 0) {
			return calculate(res, res);
		}

		else {
			int[][] res2 = calculate(res, A);
			return calculate(res, res2);
		}

	}

	public static int[][] calculate(int[][] A, int[][] B) {

		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[i][j] += (A[i][k] * B[k][j]) % MOD;
				}

				tmp[i][j] %= MOD;
			}
		}

		return tmp;
	}
}
