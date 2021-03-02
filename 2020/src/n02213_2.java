import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

// 开眠利窍绰 规过
public class n02213_2 {

	static Vector<Integer>[] arr;
	static int[] weight;
	static int[][] dp;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new Vector[n + 1];
		weight = new int[n + 1];
		dp = new int[n + 1][2];

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

		getMax(1, 0);
		getNodeNum(1, 0);

		Collections.sort(list);

		bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");

		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + " ");

		bw.flush();

	}

	public static void getMax(int n, int parent) {

		dp[n][0] = 0;
		dp[n][1] = weight[n];

		for (int i = 0; i < arr[n].size(); i++) {
			int m = arr[n].get(i);

			if (m != parent) {
				getMax(m, n);

				dp[n][0] += Math.max(dp[m][0], dp[m][1]);
				dp[n][1] += dp[m][0];
			}
		}
	}

	public static void getNodeNum(int n, int parent) {

		if (dp[n][0] < dp[n][1]) {
			list.add(n);

			for (int i = 0; i < arr[n].size(); i++) {
				int m = arr[n].get(i);
				
				if (m != parent) {
					for (int j = 0; j < arr[m].size(); j++) {
						int k = arr[m].get(j);
						if (k != n)
							getNodeNum(k, m);
					}
				}
			}
		} else {
			for (int i = 0; i < arr[n].size(); i++) {
				int m = arr[n].get(i);
				if (m != parent)
					getNodeNum(m, n);

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
