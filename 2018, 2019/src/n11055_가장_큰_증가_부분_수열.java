import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n11055_가장_큰_증가_부분_수열 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] A = new int[N + 1];
		String[] arr = br.readLine().split(" ");

		for (int i = 0; i < arr.length; i++)
			A[i + 1] = Integer.parseInt(arr[i]);

		for (int i = 1; i <= N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += A[i];
		}
		Arrays.sort(dp);

		bw.write(dp[N] + "\n");
		bw.flush();

	}
}
