import java.util.*;
import java.io.*;

public class n01935 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		char ch = 'A';
		for (int i = 0; i < N; i++)
			map.put(ch++, Integer.parseInt(br.readLine()));

		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);

			if ('A' <= ch && ch <= 'Z')
				stack.push((double) map.get(ch));
			else {
				double b = stack.pop();
				double a = stack.pop();

				switch (ch) {
				case '+':
					double n = a + b;
					stack.push(n);
					break;
				case '-':
					n = a - b;
					stack.push(n);
					break;
				case '*':
					n = a * b;
					stack.push(n);
					break;
				case '/':
					n = a / b;
					stack.push(n);
					break;
				}

			}
		}
		bw.write(String.format("%.2f",stack.pop()) + "\n");
		bw.flush();

	}

}
