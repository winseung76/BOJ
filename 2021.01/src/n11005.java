import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n11005 {

	static int N, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		B = Integer.parseInt(sarr[1]);

		Stack<Character> stack = new Stack<>();

		while (N > 0) {
			int n = N % B;

			if (n >= 10)
				stack.push((char) (n + 55));
			else
				stack.push((char) (n + '0'));

			N = N / B;
		}

		while (!stack.isEmpty()) {
			bw.write(stack.pop() + "");
		}
		bw.flush();

	}

}
