import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n14002 {

	static int N;
	static int[] arr;
	static Vector<Integer>[] dp;
	static int max, idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			dp[i] = new Vector<>();

		String[] sarr = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(sarr[i - 1]);

			int len = 0;
			int pos = 0;
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i] && len < dp[j].size()) {
					len = dp[j].size();
					pos = j;
				}
			}
			for (int j = 0; j < len; j++) {
				dp[i].add(dp[pos].get(j));
			}
			dp[i].add(arr[i]);

			if (max < dp[i].size()) {
				max = dp[i].size();
				idx = i;
			}

		}

		bw.write(max + "\n");
		for (int i = 0; i < max; i++)
			bw.write(dp[idx].get(i) + " ");
		bw.flush();

	}

}
