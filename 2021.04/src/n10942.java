import java.io.*;

public class n10942 {

	static int N, M;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}

		for (int size = 1; size <= N; size++) {
			for (int start = 1; start <= N - size; start++) {
				int end = start + size;

				if (size == 1) {
					if (arr[start] == arr[end])
						dp[start][end] = 1;
				}

				else if (dp[start + 1][end - 1] == 1 && arr[start] == arr[end])
					dp[start][end] = 1;
			}
		}

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			bw.write(dp[start][end] + "\n");
		}

		bw.flush();

	}

}
