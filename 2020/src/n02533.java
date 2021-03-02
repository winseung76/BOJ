import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n02533 {

	static ArrayList<Integer>[] arr = new ArrayList[1000001];
	static boolean[] ea = new boolean[1000001];
	static boolean[] visited = new boolean[1000001];
	static int[] parent = new int[1000001];

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

		dfs(1, -1);

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (ea[i])
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void dfs(int n, int p) {

		boolean flag = false;
		visited[n] = true;
		parent[n] = p;

		for (int i = 0; i < arr[n].size(); i++) {
			int m = arr[n].get(i);
			if (!visited[m]) {
				flag = true;
				dfs(m, n);
			}
		}

		if (flag) {

			for (int i = 0; i < arr[n].size(); i++) {
				int m = arr[n].get(i);
				if (m != parent[n] && !ea[m]) {
					ea[n] = true;
					return;
				}
			}

		}
	}

}
