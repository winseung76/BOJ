import java.io.*;

public class n02740 {

	static int[][] A, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int N = Integer.parseInt(sarr[0]);
		int M = Integer.parseInt(sarr[1]);

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		sarr = br.readLine().split(" ");
		M = Integer.parseInt(sarr[0]);
		int K = Integer.parseInt(sarr[1]);

		B = new int[M][K];
		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int sum = 0;
				for (int t = 0; t < M; t++) {
					sum += A[i][t] * B[t][j];
				}
				bw.write(sum + " ");
			}
			bw.write("\n");
		}

		bw.flush();

	}
}
