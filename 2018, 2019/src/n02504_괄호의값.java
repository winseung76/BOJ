import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class n02504_°ýÈ£ÀÇ°ª {
	public static void main(String[] args) {
		Stack stack = new Stack();
		HashMap map = new HashMap();
		map.put('(', 2);
		map.put('[', 3);
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					arr[0] = 0;
					break;
				}
				char pop_c = (char) stack.pop();

				if ((c == ')' && pop_c == '(') || (c == ']' && pop_c == '[')) {

					if (arr[stack.size() + 1] == 0)
						arr[stack.size()] += (int) map.get(pop_c);
					else {
						arr[stack.size()] += arr[stack.size() + 1] * (int) map.get(pop_c);
						arr[stack.size() + 1] = 0;
					}
				} else {
					arr[0] = 0;
					break;
				}

			}

		}
		System.out.println(arr[0]);
	}
}
