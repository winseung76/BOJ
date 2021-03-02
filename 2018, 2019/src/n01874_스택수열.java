import java.util.Scanner;
import java.util.Stack;

public class n01874_스택수열 {
	private static Scanner sc = new Scanner(System.in);
	private static Stack stack = new Stack();

	public static void main(String[] args) {

		int size = sc.nextInt();

		String result = checkAnswer(size);

		if (result == null)
			System.out.println("NO");
		else {
			for (int i = 0; i < result.length(); i++) {
				System.out.println(result.charAt(i));
			}
		}
	}

	public static String checkAnswer(int size) {
		StringBuffer result = new StringBuffer();
		int push_count = 0; // push를 몇 번 했는지 카운트하는 변수

		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			// 불가능한 경우 : 스택의 가장 맨 위의 값이 n보다 큰 경우(오름차순으로 넣기 때문에)
			if (!stack.empty() && (int) stack.peek() > n)
				return null; // 불가능한 경우 null 반환
			// 가능한 경우 : 1. 스택의 가장 맨 위의 값이 n과 같거나(바로 pop하면 됨)
			// 2. 아직 스택에 push를 하지 않은 경우
			// push를 하지 않은 수부터 n까지 스택에 push한 다음에
			for (int k = push_count + 1; k <= n; k++) {
				stack.push(k);
				result.append('+');
				push_count++;
			}
			stack.pop(); // 마지막에 넣은 n을 pop하여 꺼낸다.
			result.append('-');

		}
		return result.toString();

	}
}
