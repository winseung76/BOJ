import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class n03176 {

	static List<Node>[] arr;
	static int[][] dp;
	static int[][] max;
	static int[][] min;
	static int[] depth;
	static int maxlevel;
	static int maxDist, minDist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		arr = new ArrayList[N + 1];
		maxlevel = (int) Math.floor(Math.log(N) / Math.log(2));
		dp = new int[N + 1][maxlevel + 1];
		max = new int[N + 1][maxlevel + 1];
		min = new int[N + 1][maxlevel + 1];
		depth = new int[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);

			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));
		}

		getDPArr(new Node(1, 0), 0);

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {

			maxDist = 0;
			minDist = 1000000;

			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			getLCA(a, b);

			bw.write(minDist + " " + maxDist + "\n");
		}
		bw.flush();

	}

	public static void getDPArr(Node n, int parent) {

		dp[n.n][0] = parent;
		depth[n.n] = depth[parent] + 1;
		max[n.n][0] = n.w;
		min[n.n][0] = n.w;

		for (int i = 1; i <= maxlevel; i++) {
			dp[n.n][i] = dp[dp[n.n][i - 1]][i - 1];
			max[n.n][i] = Math.max(max[n.n][i - 1], max[dp[n.n][i - 1]][i - 1]);
			min[n.n][i] = Math.min(min[n.n][i - 1], min[dp[n.n][i - 1]][i - 1]);
		}

		for (int i = 0; i < arr[n.n].size(); i++) {
			Node node = arr[n.n].get(i);
			if (node.n != parent)
				getDPArr(node, n.n);
		}

	}

	public static void getLCA(int a, int b) {

		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		int diff = depth[b] - depth[a];

		int i = 0;
		while (diff > 0) {
			if (diff % 2 > 0) {
				maxDist = Math.max(maxDist, max[b][i]);
				minDist = Math.min(minDist, min[b][i]);
				b = dp[b][i];

			}

			diff = diff / 2;
			i++;
		}

		if (a != b) {
			for (int k = maxlevel; k >= 0; k--) {
				if (depth[a] > 0 && dp[a][k] != dp[b][k]) {
					maxDist = Math.max(maxDist, Math.max(max[a][k], max[b][k]));
					minDist = Math.min(minDist, Math.min(min[a][k], min[b][k]));
					a = dp[a][k];
					b = dp[b][k];
				}
			}
			maxDist = Math.max(maxDist, Math.max(max[a][0], max[b][0]));
			minDist = Math.min(minDist, Math.min(min[a][0], min[b][0]));
		}

	}

	static class Node {
		int n;
		int w;

		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
