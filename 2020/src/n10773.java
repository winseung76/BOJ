import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class n10773 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();
		int res = 0;

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				stack.pop();
			else
				stack.push(n);
		}

		Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			res += it.next();
		}
		bw.write(res + "\n");
		bw.flush();

	}

}
