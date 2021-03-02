import java.util.Scanner;
import java.util.Stack;

public class n09012_°ýÈ£ {
	private static Stack stack;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		for (int i = 0; i < size; i++) {
			stack = new Stack<Character>();
			String string = sc.next();
			if (checkVPS(string))
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

	public static boolean checkVPS(String string) {

		for (int j = 0; j < string.length(); j++) {
			char ch = string.charAt(j);

			if (ch == '(')
				stack.push(ch);

			else if (ch == ')') {
				if (stack.isEmpty())
					return false;

				char pop_ch = (char) stack.pop();
				if (pop_ch == ')')
					return false;
			}
		}
		if (stack.empty())
			return true;
		else
			return false;
	}
}
