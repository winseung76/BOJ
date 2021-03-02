import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n13023 {

	static int N, M;
	static Vector<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		arr = new Vector[N];
		for (int i = 0; i < N; i++)
			arr[i] = new Vector<>();

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			int res = dfs(i, 1);

			if (res == 1) {
				bw.write(res + "\n");
				bw.flush();
				return;
			}
		}

		bw.write(0 + "\n");
		bw.flush();

	}

	public static int dfs(int n, int cnt) {

		if (cnt >= 5)
			return 1;

		for (int m : arr[n]) {

			if (!visited[m]) {
				visited[m] = true;
				if (dfs(m, cnt + 1) == 1)
					return 1;
				visited[m] = false;
			}
		}

		return 0;

	}

}
