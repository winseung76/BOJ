import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n09466_≈“_«¡∑Œ¡ß∆Æ {

	static int[] slct, visited;
	static int count;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			count = 0;
			int n = Integer.parseInt(br.readLine());
			slct = new int[n + 1];
			visited = new int[n + 1];

			String[] arr = br.readLine().split(" ");
			for (int i = 1; i <= n; i++)
				slct[i] = Integer.parseInt(arr[i - 1]);

			for (int i = 1; i <= n; i++) {
				if (visited[slct[i]] == 0)
					matchTeam(i);
				else
					visited[slct[i]] = -1;
			}

			bw.write((n - count) + "\n");
		}
		bw.flush();
	}

	public static void matchTeam(int s) {
		Stack<Integer> stack = new Stack<>();

		stack.push(s);
		visited[s] = 1;

		while (!stack.isEmpty()) {

			int n = stack.peek();

			int stu = slct[n];

			if (visited[stu] == 0) {
				stack.push(stu);
				visited[stu] = 1;
			}

			else if (visited[stu] == 1) {
				visited[stu] = 2;
				count++;

				int pop;
				while (!stack.isEmpty() && (pop = stack.pop()) != stu) {
					visited[pop] = 2;
					count++;
				}
				break;
			} else
				break;

		}

		while (!stack.isEmpty())
			visited[stack.pop()] = -1;
	}
}
