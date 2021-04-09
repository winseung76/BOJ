import java.io.*;

public class n02740 {

	static int N, M, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		int[][] A = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(input[j]);
			}
		}

		input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		int[][] B = new int[M][K];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(input[j]);
			}
		}

		int[][] C = new int[N][K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int m = 0; m < M; m++) {
					C[i][j] += A[i][m] * B[m][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				bw.write(C[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();

	}

}
