import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
// LCA 알고리즘(최소 공통 부모 찾기) 
// dfs방법을 이용하여 parent배열과 depth배열로 구하는 방법
public class n11437 {

	static ArrayList<Integer>[] arr;
	static int[] parent;
	static int[] depth;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		arr = new ArrayList[N + 1];
		parent = new int[N + 1];
		depth = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
			depth[i] = -1;
		}

		for (int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			int aDepth = depth[a];
			int bDepth = depth[b];

			while (aDepth > bDepth) {
				aDepth = depth[a] - 1;
				a = parent[a];
			}
			while (aDepth < bDepth) {
				bDepth = depth[b] - 1;
				b = parent[b];
			}
			while (a != b) {
				aDepth = depth[a] - 1;
				bDepth = depth[b] - 1;
				a = parent[a];
				b = parent[b];
			}

			bw.write(a + "\n");

		}
		bw.flush();
	}

	public static void dfs(int n) {

		Stack<Integer> stack = new Stack<>();

		stack.push(n);
		parent[n] = 1;
		depth[n] = 1;

		boolean flag;
		while (!stack.isEmpty()) {

			int p = stack.peek();
			flag=false;

			for (int i = 0; i < arr[p].size(); i++) {
				int m = arr[p].get(i);
				if (depth[m] == -1) {
					stack.push(m);

					parent[m] = p;
					depth[m] = depth[p] + 1;
					flag=true;
					break;
				}
			}
			if (!flag)
				stack.pop();

		}
	}

}
