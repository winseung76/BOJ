import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n02812 {

	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		K = Integer.parseInt(sarr[1]);

		String str = br.readLine();

		int cnt = K;
		Stack<Integer> stack = new Stack<>();
		stack.push(str.charAt(0) - '0');

		for (int i = 1; i < str.length(); i++) {
			int n = str.charAt(i) - '0';

			while (!stack.isEmpty() && stack.peek() < n && cnt > 0) {
				stack.pop();
				cnt--;
			}

			stack.push(n);
		}

		while (stack.size() > N - K) {
			stack.pop();
		}

		StringBuffer buf = new StringBuffer();

		while (!stack.empty()) {
			buf.append(stack.pop());
		}

		bw.write(buf.reverse().toString() + "\n");
		bw.flush();

	}
}
