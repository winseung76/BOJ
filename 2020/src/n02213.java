import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

public class n02213 {

	static Vector<Integer>[] arr;
	static int[] weight;
	static int[][] dp;
	static Vector<Integer>[][] set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new Vector[n + 1];
		weight = new int[n + 1];
		dp = new int[n + 1][2];
		set = new Vector[n + 1][2];

		for (int i = 0; i <= n; i++) {
			set[i][0] = new Vector<>();
			set[i][1] = new Vector<>();
		}
		for (int i = 0; i <= n; i++)
			arr[i] = new Vector<>();

		String[] s = br.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			weight[i] = Integer.parseInt(s[i - 1]);

		String str = "";
		while ((str = br.readLine()) != null) {
			s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			arr[a].add(b);
			arr[b].add(a);
		}

		getMaxSet(1, 0);

		Collections.sort(set[1][0]);
		Collections.sort(set[1][1]);

		if (dp[1][0] > dp[1][1]) {
			bw.write(dp[1][0] + "\n");
			for (int i = 0; i < set[1][0].size(); i++)
				bw.write(set[1][0].get(i) + " ");
		} 
		else {
			bw.write(dp[1][1] + "\n");
			for (int i = 0; i < set[1][1].size(); i++)
				bw.write(set[1][1].get(i) + " ");
		}

		// bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
		bw.flush();

	}

	public static void getMaxSet(int n, int parent) {

		dp[n][0] = 0;
		dp[n][1] = weight[n];
		set[n][1].add(n);

		for (int i = 0; i < arr[n].size(); i++) {
			int m = arr[n].get(i);

			if (m != parent) {
				getMaxSet(m, n);

				dp[n][0] += Math.max(dp[m][0], dp[m][1]);
				dp[n][1] += dp[m][0];

				if (dp[m][0] < dp[m][1]) {
					for (int j = 0; j < set[m][1].size(); j++)
						set[n][0].add(set[m][1].get(j));
				} 
				else {
					for (int j = 0; j < set[m][0].size(); j++)
						set[n][0].add(set[m][0].get(j));
				}
				for (int j = 0; j < set[m][0].size(); j++)
					set[n][1].add(set[m][0].get(j));
			}
		}
	}

	static class Pair {
		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
