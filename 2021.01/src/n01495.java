import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01495 {

	static int N, S, M;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		S = Integer.parseInt(sarr[1]);
		M = Integer.parseInt(sarr[2]);

		int[] V = new int[N + 1];
		dp = new int[M + 1];
		dp[S] = 0;
		for (int i = 0; i <= M; i++) {
			if (i != S)
				dp[i] = -1;
		}

		int[] tmp = new int[M + 1];

		sarr = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(sarr[i - 1]);
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j <= M; j++) {
				if (dp[j] == i - 1) {
					if (0 <= j + V[i] && j + V[i] <= M)
						tmp[j + V[i]] = i;

					if (0 <= j - V[i] && j - V[i] <= M)
						tmp[j - V[i]] = i;
				}
			}

			boolean flag = false;
			for (int j = 0; j <= M; j++) {
				if (tmp[j] == i) {
					flag = true;
					dp[j] = tmp[j];
				}
			}

			if (!flag) {
				bw.write(-1 + "\n");
				bw.flush();
				return;
			}

		}
		int max = 0;
		for (int j = 0; j <= M; j++) {
			if (dp[j] == N) {
				max = Math.max(max, j);
			}
		}

		bw.write(max + "\n");
		bw.flush();

	}

}
