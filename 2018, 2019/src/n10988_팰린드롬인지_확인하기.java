import java.util.Scanner;

public class n10988_팰린드롬인지_확인하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String string = sc.nextLine();

		System.out.println(checkPalindrome(string));

	}

	public static int checkPalindrome(String string) {
		int length = string.length();

		for (int i = 0; i < length / 2; i++) {
			if (string.charAt(i) != string.charAt(length - i - 1))
				return 0;
		}
		return 1;
	}
}
