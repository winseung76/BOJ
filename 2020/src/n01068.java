import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

// dfs, bfs ������� ���� ��� �����ϱ�
// ���� : ��Ʈ ��常 ���������� ��Ʈ ��嵵 ���� ��忡 �ش��� 
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
			int n = Integer.parseInt(s[i]); // n�� i�� �θ���
			
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
		boolean pop = false; // ��尡 ������������� �˱� ���ؼ� �ʿ�
		                     // ���ÿ� �����Ͱ� push�� �� false�� ����Ǹ�, ���ÿ� �����͸� pop�� �� true�� �ȴ�.
		                     // pop = true : ���� ������ ���� ����� ������(n)�� ������ pop�� �����Ͱ� �����Ѵ�. = n�� ������尡 �ƴ�
		                     // pop = false : ���� ������ ���� ����� ������(n) ������ pop�� �����Ͱ� ����. = n�� ���������

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
