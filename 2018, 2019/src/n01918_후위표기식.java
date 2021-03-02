import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n01918_후위표기식 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (65 <= ch && ch <= 90)
				bw.write(ch);

			else if (ch == ')') {

				while (!stack.isEmpty()) {
					char c = stack.pop();
					if (c == '(') {
						break;
					} else
						bw.write(c);
				}

			} else if (ch == '(')
				stack.push(ch);

			else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch))
					bw.write(stack.pop());
				stack.push(ch);
			}

		}
		while (!stack.isEmpty())
			bw.write(stack.pop());
		bw.flush();
	}

	public static int priority(char op) {
		if (op == '(')
			return 0;
		if (op == '+' || op == '-')
			return 1;
		if (op == '*' || op == '/')
			return 2;
		else
			return 3;
	}
}
