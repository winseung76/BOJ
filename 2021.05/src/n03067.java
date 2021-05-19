import java.io.*;

public class n03067 {

	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			String[] input = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(input[i - 1]);
			}
			int price = Integer.parseInt(br.readLine());

			int[][] dp = new int[N + 1][price + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= price; j++) {

					if (j < arr[i])
						dp[i][j] = dp[i - 1][j];
					else {
						if (i == 1) {
							if (j % arr[i] == 0)
								dp[i][j] = 1;
						}

						else {
							dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
							if (j == arr[i])
								dp[i][j]++;
						}
					}
				}
			}

			bw.write(dp[N][price] + "\n");
		}
		bw.flush();

	}

}
