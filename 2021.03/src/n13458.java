import java.io.*;

public class n13458 {

	static int N, B, C;
	static int[] A;
	static long cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(input[i]);

		input = br.readLine().split(" ");
		B = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		for (int i = 0; i < N; i++) {
			cnt++;
			int rest = A[i] - B;

			if (rest > 0) {
				cnt += rest / C;
				if (rest % C > 0)
					cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

}
