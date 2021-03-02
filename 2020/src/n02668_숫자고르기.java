import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n02668_숫자고르기 {

	static int[] arr;
	static boolean[] isvisited, res;
	static int count, N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		isvisited = new boolean[N + 1];
		res = new boolean[N + 1];

		for (int n = 1; n <= N; n++)
			arr[n] = Integer.parseInt(br.readLine());

		for (int n = 1; n <= N; n++) {
			if (!isvisited[n])
				dfs(n);
		}
		bw.write(count + "\n");
		for (int i = 1; i <= N; i++) {
			if (res[i])
				bw.write(i + "\n");
		}
		bw.flush();

	}

	static void dfs(int s) {

		Stack<Integer> stack = new Stack<>();
		boolean[] v = new boolean[N + 1];

		stack.push(s);
		isvisited[s] = true;
		v[s] = true;

		while (!stack.isEmpty()) {
			int n = stack.peek();

			if (!isvisited[arr[n]]) {
				stack.push(arr[n]);
				isvisited[arr[n]] = true;
				v[arr[n]] = true;
			} else {
				if (v[arr[n]]) {
					while (!stack.isEmpty() && (stack.peek()) != arr[n]) {
						res[stack.pop()] = true;
						count++;
					}
					if (!stack.isEmpty() && stack.peek() == arr[n]) {
						res[stack.pop()] = true;
						count++;
					}
				}
				return;
			}
		}
	}
}
