import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 트리에서의 다이나믹 프로그래밍
public class n02533_2 {

	static ArrayList<Integer>[] arr = new ArrayList[1000001];
	static int[][] dp = new int[1000001][2];
	static boolean[] visited = new boolean[1000001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");

			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);

			arr[u].add(v);
			arr[v].add(u);
		}
		dfs(1);

		int res = Math.min(dp[1][0], dp[1][1]);
		bw.write(res + "\n");
		bw.flush();

	}

	public static void dfs(int n) {

		visited[n] = true;
		dp[n][0] = 0;
		dp[n][1] = 1;

		for (int j = 0; j < arr[n].size(); j++) {
			int m = arr[n].get(j);

			if (!visited[m]) {
				dfs(m);

				dp[n][0] += dp[m][1];
				dp[n][1] += Math.min(dp[m][0], dp[m][1]);
			}
		}

	}

}
