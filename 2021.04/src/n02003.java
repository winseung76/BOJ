import java.io.*;

public class n02003 {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		A = new int[N];

		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(input[i]);

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int s = 0;
		int e = 0;
		int sum = 0;
		int cnt = 0;

		while (s < A.length) {

			if (sum == M) {
				cnt++;
				sum -= A[s++];
			}

			else if (sum > M || e == A.length)
				sum -= A[s++];

			else if (sum < M)
				sum += A[e++];

		}

		return cnt;
	}

}
