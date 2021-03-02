import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

// dfs, bfs 방법에서 리프 노드 구분하기
// 유의 : 루트 노드만 남았을때는 루트 노드도 리프 노드에 해당함 
public class n01068 {

	static ArrayList<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		visited = new boolean[N];
		int root=0;

		for (int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(s[i]); // n은 i의 부모노드
			
			if (n == -1)
				root = i;
			
			else if (n > -1) {
				arr[i].add(n);
				arr[n].add(i);
			}
		}
		int R = Integer.parseInt(br.readLine());

		arr[R] = null;
		for (int i = 0; i < N; i++) {
			if (i != R)
				arr[i].remove((Integer) R);
		}

		int ans;
		if (arr[root] == null)
			ans = 0;
		else
			ans = dfs(root);
		bw.write(ans + "\n");
		bw.flush();

	}

	public static int dfs(int n) {

		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		boolean pop = false; // 노드가 리프노드인지를 알기 위해서 필요
		                     // 스택에 데이터가 push될 때 false로 변경되며, 스택에 데이터를 pop할 때 true가 된다.
		                     // pop = true : 현재 스택의 가장 꼭대기 데이터(n)의 이전에 pop된 데이터가 존재한다. = n은 리프노드가 아님
		                     // pop = false : 현재 스택의 가장 꼭대기 데이터(n) 이전에 pop된 데이터가 없다. = n이 리프노드임

		stack.push(n);
		visited[n] = true;

		boolean flag = false;

		while (!stack.isEmpty()) {

			flag = false;
			int m = stack.peek();

			if (arr[m] != null) {
				for (int i = 0; i < arr[m].size(); i++) {
					int nn = arr[m].get(i);

					if (!visited[nn]) {
						stack.push(nn);
						visited[nn] = true;

						flag = true;
						pop = false;
						break;
					}
				}
				if (!flag) {
					if (!pop)
						cnt++;
					stack.pop();
					pop = true;

				}
			}
		}
		return cnt;
	}
}
