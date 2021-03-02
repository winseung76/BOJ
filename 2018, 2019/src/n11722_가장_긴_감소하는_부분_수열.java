import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n11722_가장_긴_감소하는_부분_수열 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j < i; j++) {
				if (arr[j - 1] > arr[i - 1])
					max = Math.max(max, dp[j]);
			}

			dp[i] = max + 1;
		}

		Arrays.sort(dp);

		bw.write(dp[N] + "\n");
		bw.flush();
	}
}
