import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n11055 {

	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		for (int n = 0; n < N; n++) {
			int max = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] < arr[n])
					max = Math.max(max, dp[j]);
			}
			dp[n] = max + 1;
		}
		
		Arrays.sort(dp);
		bw.write(dp[N - 1] + "\n");
		bw.flush();

	}

}
