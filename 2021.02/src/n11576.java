import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n11576 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int A = Integer.parseInt(sarr[0]);
		int B = Integer.parseInt(sarr[1]);

		int m = Integer.parseInt(br.readLine());

		sarr = br.readLine().split(" ");
		int n = 0;
		int k = 0;

		for (int i = sarr.length - 1; i >= 0; i--) {
			n += Integer.parseInt(sarr[i]) * Math.pow(A, k++);
		}

		Stack<Integer> stack = new Stack<>();

		while (n > 0) {
			stack.push(n % B);
			n = n / B;
		}

		while (!stack.isEmpty())
			bw.write(stack.pop() + " ");
		bw.flush();

	}

}
