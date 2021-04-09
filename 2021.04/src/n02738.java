import java.io.*;

public class n02738 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		int[][] a = new int[N][M];
		int[][] b = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				b[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write((a[i][j] + b[i][j]) + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}

}
