import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class n02493_ž {
	private static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int i = 1;
		while (st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			map.put(k, i);

			while (!stack.isEmpty() && stack.peek() < k) {
				int key = stack.pop();
				map.remove(key);
			}
			if (stack.isEmpty()) {
				bw.write(0 + " ");
			} else {
				int key = stack.peek();
				bw.write(map.get(key) + " ");
			}
			stack.push(k);
			i++;
		}
		bw.flush();
	}
}
