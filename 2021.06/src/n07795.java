import java.io.*;
import java.util.Arrays;

public class n07795 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(input[i]);
			}

			input = br.readLine().split(" ");
			int[] B = new int[M];
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(input[i]);
			}

			int cnt = 0;
			Arrays.sort(B);
			for (int i = 0; i < N; i++) {
				cnt += binSearch(B, A[i]);
			}

			bw.write(cnt + "\n");

		}
		bw.flush();

	}

	public static int binSearch(int[] arr, int n) {

		int pl = 0;
		int pr = arr.length - 1;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pr + 1;
	}

}
