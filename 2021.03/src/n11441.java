import java.io.*;

public class n11441 {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		A = new int[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(input[i - 1]);

		for (int i = 1; i <= N; i++)
			A[i] += A[i - 1];

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			bw.write((A[end] - A[start - 1]) + "\n");
		}

		bw.flush();

	}

}
