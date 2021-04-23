import java.io.*;
import java.util.*;

public class n01761 {

	static int N, M;
	static int[] depth;
	static int[][] dp;
	static int maxLevel;
	static int[][] w;
	static List<Pair>[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		maxLevel = (int) Math.floor((Math.log(N) / Math.log(2)));
		depth = new int[N + 1];
		dp = new int[N + 1][maxLevel + 1];
		w = new int[N + 1][maxLevel + 1];
		v = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			v[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {

			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int d = Integer.parseInt(input[2]);

			v[a].add(new Pair(b, d));
			v[b].add(new Pair(a, d));
		}

		getDPArr(1, 0, 0);

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int n1 = Integer.parseInt(input[0]);
			int n2 = Integer.parseInt(input[1]);

			bw.write(getLCA(n1, n2) + "\n");
		}

		bw.flush();

	}

	public static void getDPArr(int n, int parent, int weight) {

		dp[n][0] = parent;
		depth[n] = depth[parent] + 1;
		w[n][0] = weight;

		for (int i = 1; i <= maxLevel; i++) {
			dp[n][i] = dp[dp[n][i - 1]][i - 1];
			w[n][i] = w[n][i - 1] + w[dp[n][i - 1]][i - 1];
		}

		for (Pair p : v[n]) {
			if (p.n != parent) {
				getDPArr(p.n, n, p.w);
			}
		}
	}

	public static int getLCA(int a, int b) {

		int dist = 0;

		if (depth[a] > depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}

		int diff = depth[b] - depth[a];

		int i = 0;
		while (diff > 0) {
			if (diff % 2 != 0) {
				dist += w[b][i];
				b = dp[b][i];
			}
			diff /= 2;
			i++;
		}

		if (a != b) {

			for (i = maxLevel; i >= 0; i--) {
				if (depth[a] != 0 && dp[a][i] != dp[b][i]) {
					dist += w[a][i] + w[b][i];
					a = dp[a][i];
					b = dp[b][i];
				}
			}
			dist += w[a][0] + w[b][0];
			a = dp[a][0];
		}

		return dist;

	}

	static class Pair {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
