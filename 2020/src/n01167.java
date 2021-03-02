import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n01167 {

	static List<Node>[] arr;
	static boolean[] visited;
	static int N, res, max;
	static int V;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		V = Integer.parseInt(br.readLine());
		arr = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);

			int j = 1;
			while (j < s.length - 1) {
				int m = Integer.parseInt(s[j++]);
				int w = Integer.parseInt(s[j++]);
				arr[n].add(new Node(m, w));
				arr[n].add(new Node(n, w));
			}
		}
		visited = new boolean[V + 1];
		dfs(1);

		res = 0;
		max = 0;
		visited = new boolean[V + 1];
		dfs(N);

		bw.write(res + "\n");
		bw.flush();

	}

	public static void dfs(int n) {

		visited[n] = true;

		boolean flag = false;

		for (int i = 0; i < arr[n].size(); i++) {
			Node p = arr[n].get(i);
			if (!visited[p.n]) {
				max += p.w;
				flag = true;
				dfs(p.n);
				max -= p.w;
			}
		}
		if (!flag) {
			if (res < max) {
				res = max;
				N = n;
			}
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
