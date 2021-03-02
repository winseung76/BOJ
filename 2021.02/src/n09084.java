import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09084 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());
			String[] sarr = br.readLine().split(" ");
			int M = Integer.parseInt(br.readLine());

			int[][] dp = new int[N + 1][M + 1];
			int[] arr = new int[N + 1];

			for (int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(sarr[i - 1]);

			for (int i = 1; i <= N; i++) {

				for (int j = 0; j <= M; j++) {

					if (i == 1 && j % arr[i] == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i - 1][j];

					int k = 1;
					while (arr[i] * k <= j) {
						dp[i][j] += dp[i - 1][j - arr[i] * k];
						k++;
					}
				}
			}

			bw.write(dp[N][M] + "\n");
		}
		bw.flush();

	}

}
