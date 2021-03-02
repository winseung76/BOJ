import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// dfs 사용시, 경로 추적을 위해서 parent 배열을 사용 
public class n13913 {

	static int N, K;
	static int[] parent = new int[100001];
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		bfs(N);
  
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int idx = K;
		while (idx != N) {

			stack.push(parent[idx]);
			idx = parent[idx];
		}

		bw.write(stack.size() - 1 + "\n");

		while (!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}

		bw.flush();

	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();

		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {

			int n = q.poll();

			if (n == K)
				return;

			int[] nPos = { n + 1, n - 1, n * 2 };

			for (int i = 0; i < 3; i++) {
				int m = nPos[i];

				if ((0 <= m && m <= 100000) && !visited[m]) {
					parent[m] = n;
					visited[m] = true;
					q.offer(m);
				}
			}
		}

	}

}
