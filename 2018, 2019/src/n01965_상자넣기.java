import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n01965_상자넣기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		String[] arr = br.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			int max = 0;
			for (int j = 1; j < i; j++) {
				if (Integer.parseInt(arr[j - 1]) < Integer.parseInt(arr[i - 1])) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] += max;
		}
		Arrays.sort(dp);
		bw.write(dp[n] + "\n");
		bw.flush();
	}
}
