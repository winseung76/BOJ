import java.util.Scanner;
import java.util.Stack;

public class n01874_���ü��� {
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
		int push_count = 0; // push�� �� �� �ߴ��� ī��Ʈ�ϴ� ����

		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			// �Ұ����� ��� : ������ ���� �� ���� ���� n���� ū ���(������������ �ֱ� ������)
			if (!stack.empty() && (int) stack.peek() > n)
				return null; // �Ұ����� ��� null ��ȯ
			// ������ ��� : 1. ������ ���� �� ���� ���� n�� ���ų�(�ٷ� pop�ϸ� ��)
			// 2. ���� ���ÿ� push�� ���� ���� ���
			// push�� ���� ���� ������ n���� ���ÿ� push�� ������
			for (int k = push_count + 1; k <= n; k++) {
				stack.push(k);
				result.append('+');
				push_count++;
			}
			stack.pop(); // �������� ���� n�� pop�Ͽ� ������.
			result.append('-');

		}
		return result.toString();

	}
}
