import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n01761 {

	static int[] depth = new int[40001];
	static List<Node>[] arr = new ArrayList[40001];
	static int[][] dp, weight;
	static int maxlevel;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		maxlevel = (int) Math.floor(Math.log(N) / Math.log(2));
		dp = new int[40001][maxlevel + 1];
		weight = new int[40001][maxlevel + 1];

		for (int i = 0; i <= 40000; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int w = Integer.parseInt(s[2]);

			arr[a].add(new Node(b, w));
			arr[b].add(new Node(a, w));
		}
		getDPArr(1, 0, 0);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			bw.write(getDist(a, b) + "\n");

		}
		bw.flush();
	}

	public static void getDPArr(int n, int parent, int w) {

		depth[n] = depth[parent] + 1;
		dp[n][0] = parent;
		weight[n][0] = w;

		for (int i = 1; i <= maxlevel; i++) {
			dp[n][i] = dp[dp[n][i - 1]][i - 1];
			weight[n][i] = weight[n][i - 1] + weight[dp[n][i - 1]][i - 1];
		}

		for (int i = 0; i < arr[n].size(); i++) {
			Node node = arr[n].get(i);
			if (node.n != parent) {
				getDPArr(node.n, n, node.w);
			}
		}
	}

	public static int getDist(int a, int b) {

		int dist = 0;

		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		int diff = depth[b] - depth[a];
		int i = 0;

		while (diff > 0) {
			if (diff % 2 > 0) {
				dist += weight[b][i];
				b = dp[b][i];
			}
			diff = diff / 2;
			i++;
		}

		if (a != b) {
			for (int j = maxlevel; j >= 0; j--) {
				if (depth[a] > 0 && dp[a][j] != dp[b][j]) {
					dist += weight[a][j] + weight[b][j];
					a = dp[a][j];
					b = dp[b][j];
				}
			}
			dist += weight[a][0] + weight[b][0];
		}

		return dist;

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
