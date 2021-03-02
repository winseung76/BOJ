import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02098 {

	static int N;
	static int[][] W;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		W = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++)
				W[i][j] = Integer.parseInt(s[j - 1]);
		}

		for (int s = 1; s <= N; s++) {
			visited = new boolean[N + 1];
			dfs(s, s, 0);
		}

		bw.write(min + "\n");
		bw.flush();

	}

	public static void dfs(int start, int n, int sum) {

		if (n == start && sum > 0) {

			boolean flag = true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				min = Math.min(min, sum);

			return;
		}

		for (int i = 1; i <= N; i++) {

			if (W[n][i] > 0 && !visited[i]) {
				visited[i] = true;
				dfs(start, i, sum + W[n][i]);
				visited[i] = false;
			}
		}

	}

}
