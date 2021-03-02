import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11054_가장_긴_바이토닉_부분_수열 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][2];
		int[] arr = new int[N + 1];
		String[] s = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(s[i - 1]);

		int max = 1;
		dp[1][0] = dp[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i])
					dp[i][0] = Math.max(dp[j][0], dp[i][0]);
				else if (arr[j] > arr[i])
					dp[i][1] = Math.max(Math.max(dp[j][0], dp[j][1]), dp[i][1]);
			}
			dp[i][0]++;
			dp[i][1]++;
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		bw.write(max + "\n");
		bw.flush();
	}
}
