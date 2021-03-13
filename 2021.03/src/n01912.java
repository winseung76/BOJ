import java.io.*;
import java.util.Arrays;

public class n01912 {

	static int n;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
		}

		Arrays.sort(dp);
		bw.write(dp[n - 1] + "\n");
		bw.flush();
	}

}
