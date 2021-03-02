import java.util.Scanner;
import java.util.Stack;

public class n10799_¼è¸·´ë±â {
	private static Stack stack = new Stack();

	public static void main(String[] args) {

		int total_count = 0;
		String str = new Scanner(System.in).nextLine();

		char pre_ch = ' ';
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				stack.pop();
				if (pre_ch == '(') {
					total_count += stack.size();
				} else {
					total_count += 1;
				}
			}
			pre_ch = ch;
		}
		System.out.println(total_count);

	}
}
