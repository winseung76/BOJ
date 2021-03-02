import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11060 {

	static int N;
	static int[] A;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(sarr[i]);
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			if (dp[i] < Integer.MAX_VALUE) {
				for (int j = 1; j <= A[i]; j++) {
					if (i + j < N)
						dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}

		if (dp[N - 1] == Integer.MAX_VALUE)
			bw.write(-1 + "\n");
		else
			bw.write(dp[N - 1] + "\n");
		bw.flush();

	}

}
