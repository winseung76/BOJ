import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n11437_2 {

	static int[][] dp;
	static ArrayList<Integer>[] arr;
	static int[] depth;
	static int N, maxLevel;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		depth = new int[N + 1];
		arr = new ArrayList[N + 1];

		maxLevel = (int) Math.floor(Math.log(N) / Math.log(2));

		dp = new int[N + 1][maxLevel + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();

			for (int j = 0; j <= maxLevel; j++)
				dp[i][j] = -1;
		}

		for (int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			arr[a].add(b);
			arr[b].add(a);
		}

		getDPArr(1, 0);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			int res = getLCA(a, b);
			bw.write(res + "\n");

		}
		bw.flush();

	}

	public static void getDPArr(int n, int parent) {

		depth[n] = depth[parent] + 1;
		dp[n][0] = parent;

		for (int i = 0; i < maxLevel ; i++) {
			int tmp = dp[n][i];
			if (tmp > -1)
				dp[n][i + 1] = dp[tmp][i];
		}

		for (int i = 0; i < arr[n].size(); i++) {
			int m = arr[n].get(i);
			if (m != parent)
				getDPArr(m, n);
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
			if (diff % 2 > 0)
				b = dp[b][i];

			diff = diff / 2;
			i++;
		}

		if (a != b) {
			for (int j = maxLevel; j >= 0; j--) {
				if (dp[a][j] != -1 && dp[a][j] != dp[b][j]) {
					a = dp[a][j];
					b = dp[b][j];
				}
			}
			a = dp[a][0];
		}

		return a;
	}
}
