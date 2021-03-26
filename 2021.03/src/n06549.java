import java.io.*;
import java.util.*;

public class n06549 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] input = br.readLine().split(" ");
			long max = 0;

			int n = Integer.parseInt(input[0]);

			if (n == 0)
				break;

			long[] arr = new long[n];
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(input[i + 1]);
			}

			for (int i = 0; i < n; i++) {

				while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
					int pop = stack.pop();
					// int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					int width = i - pop;
					long area = width * arr[pop];
					System.out.print(area + " ");
					max = Math.max(max, area);
				}

				stack.push(i);
			}

			while (!stack.empty()) {
				int pop = stack.pop();
				int width = stack.isEmpty() ? n : n - stack.peek() - 1;
				long area = width * arr[pop];
				max = Math.max(max, area);
			}

			bw.write(max + "\n");
		}
		bw.flush();

	}

}
