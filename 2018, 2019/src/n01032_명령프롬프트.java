import java.util.Scanner;

public class n01032_명령프롬프트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		String first_str = sc.next();
		int length = first_str.length();
		char[] arr = new char[length];

		for (int i = 0; i < length; i++)
			arr[i] = first_str.charAt(i);

		String pre_str = first_str;
		for (int i = 0; i < size - 1; i++) {
			String str = sc.next();

			for (int index = 0; index < length; index++) {
				char ch = str.charAt(index);

				if (arr[index] == '?')
					continue;
				if (pre_str.charAt(index) != ch)
					arr[index] = '?';

			}
			pre_str = str;
		}

		for (int i = 0; i < length; i++)
			System.out.print(arr[i]);

	}
}
