import java.io.*;
import java.util.*;

public class n11437 {

	static int N, M;
	static Vector<Integer>[] v;
	static int[][] dp;
	static int[] depth;
	static int maxLevel;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		v = new Vector[N + 1];
		maxLevel = (int) (Math.log(N) / Math.log(2));
		dp = new int[N + 1][maxLevel + 1];
		depth = new int[N + 1];

		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		for (int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			v[a].add(b);
			v[b].add(a);
		}

		getDPArr(1, 0);

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			bw.write(getLCA(a, b) + "\n");
		}

		bw.flush();

	}

	public static void getDPArr(int n, int parent) {

		dp[n][0] = parent;
		depth[n] = depth[parent] + 1;

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
			if (diff % 2 != 0)
				b = dp[b][i];
			diff = diff / 2;
			i++;
		}

		if (a != b) {

			for (int j = maxLevel; j >= 0; j--) {
				if (depth[a] != 0 && dp[a][j] != dp[b][j]) {
					a = dp[a][j];
					b = dp[b][j];
				}
			}
			a = dp[a][0];
		}

		return a;
	}

}
