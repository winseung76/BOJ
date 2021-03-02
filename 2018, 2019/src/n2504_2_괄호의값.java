import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class n2504_2_괄호의값 {
	private static Stack<String> stack = new Stack<>();
	private static HashMap map = new HashMap();

	public static void main(String[] args) {

		map.put("(", "2");
		map.put("[", "3");
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String str = sc.nextLine();

		System.out.println(get_sum(str));
	}

	public static int get_sum(String str) {
		int i = 0;
		String pop;
		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(String.valueOf(c));
			} else {
				if (stack.isEmpty())
					return 0;

				pop = stack.pop();

				if ((c == ')' && pop.equals("(")) || (c == ']' && pop.equals("["))) {
					stack.push((String) map.get(pop));
				} else if ((c == ')' && pop.equals("[")) || (c == ']' && pop.equals("(")))
					return 0;
				else if (!pop.equals("(") && !pop.equals("[")) { // pop한 결과가 숫자일 경우
					if (stack.isEmpty())
						return 0;

					int sum = Integer.parseInt(pop);
					while (!(pop = stack.pop()).equals("(") && !pop.equals("[")) {
						sum += Integer.parseInt(pop);
					}
					if ((c == ')' && pop.equals("(")) || (c == ']' && pop.equals("["))) {
						sum = Integer.parseInt((String) map.get(pop)) * sum;
						stack.push(String.valueOf(sum));
					} else
						return 0;

				}

			}

		}
		pop = stack.pop();
		if (pop == "(" || pop == "[")
			return 0;
		else
			return Integer.parseInt(pop);

	}
}
