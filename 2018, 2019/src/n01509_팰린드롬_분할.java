import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01509_팰린드롬_분할 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int N = str.length();
		int[] dp = new int[N + 1];
		boolean[][] palindrome = new boolean[N + 1][N + 1];

		for (int i = 1; i < N; i++) {
			palindrome[i][i] = true;

			if (str.charAt(i - 1) == str.charAt(i))
				palindrome[i][i + 1] = palindrome[i + 1][i] = true;
		}
		palindrome[N][N] = true;

		int min;
		for (int i = 1; i <= N; i++) {
			min = dp[i - 1];
			for (int j = 1; j < i; j++) {

				if (str.charAt(j - 1) == str.charAt(i - 1)) {
					if (palindrome[j + 1][i - 1]) {
						palindrome[j][i] = true;
						min = Math.min(dp[j - 1], min);
					}
				}
			}
			dp[i] = min + 1;
		}
		bw.write(dp[N] + "\n");
		bw.flush();
	}
}
