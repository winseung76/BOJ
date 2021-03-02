import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10942_팰린드롬_물음표 {

	static int N, M, S, E;
	static int[] str;
	static int[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		str = new int[N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				dp[i][j] = -1;
		}

		String[] arr = br.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			str[n] = Integer.parseInt(arr[n]);
			dp[n][n] = 1;
		}

		M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			arr = br.readLine().split(" ");
			S = Integer.parseInt(arr[0]) - 1;
			E = Integer.parseInt(arr[1]) - 1;

			palindrome(S, E);

			bw.write(dp[S][E] + "\n");
		}
		bw.flush();
	}

	static void palindrome(int S, int E) {

		if (str[S] == str[E]) {
			if (S + 1 < E) {
				if (dp[S + 1][E - 1] == -1)
					palindrome(S + 1, E - 1);

				dp[S][E] = dp[S + 1][E - 1];

			} else if (S + 1 == E)
				dp[S][E] = 1;
		} else
			dp[S][E] = 0;
	}

}
