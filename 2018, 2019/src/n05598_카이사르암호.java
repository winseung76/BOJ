import java.util.Scanner;

public class n05598_카이사르암호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			char new_c = (char) (c - 3);

			if (new_c < 'A')
				new_c = (char) ('Z' - ('A' - new_c) + 1);

			System.out.print(new_c);
		}
	}
}
