import java.io.*;
import java.util.*;

public class n11438 {

	static int N;
	static int[][] dp;
	static int[] depth;
	static int maxLevel;
	static List<Integer>[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		maxLevel = (int) Math.floor(Math.log(N) / Math.log(2));

		depth = new int[N + 1];
		dp = new int[N + 1][maxLevel + 1];
		v = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			v[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			v[a].add(b);
			v[b].add(a);
		}

		getDPArr(1, 0);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			bw.write(getLCA(a, b) + "\n");
		}
		bw.flush();

	}

	public static void getDPArr(int n, int parent) {

		depth[n] = depth[parent] + 1;
		dp[n][0] = parent;

		for (int i = 1; i <= maxLevel; i++) {
			dp[n][i] = dp[dp[n][i - 1]][i - 1];
		}

		for (int m : v[n]) {
			if (m != parent) {
				getDPArr(m, n);
			}
		}
	}

	public static int getLCA(int a, int b) {

		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		int diff = depth[b] - depth[a];

		int i = 0;
		while (diff > 0) {
			if (diff % 2 == 1) {
				b = dp[b][i];
			}
			diff /= 2;
			i++;
		}

		if (a != b) {

			for (i = maxLevel; i >= 0; i--) {
				if (depth[a] != 0 && dp[a][i] != dp[b][i]) {
					a = dp[a][i];
					b = dp[b][i];
				}
			}
			a = dp[a][0];
		}

		return a;
	}

}
