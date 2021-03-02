import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02738 {

	static int N, M;
	static int[][] A, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				B[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write((A[i][j] + B[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}

}
