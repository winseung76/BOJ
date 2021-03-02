import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11048 {

	private static int[][] dp;
	private static int[][] candy;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		dp = new int[N + 1][M + 1];
		// candy = new int[N + 1][M + 1];

		// 각 방마다 사탕개수 세팅
		for (int i = 1; i <= N; i++) {

			String[] arr2 = br.readLine().split(" ");

			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(arr2[j - 1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				dp[i][j] += Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
			}
		}

		bw.write(dp[N][M] + "\n");
		bw.flush();

	}
}
