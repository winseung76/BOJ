import java.util.Scanner;

public class n02789_���б��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String str2 = "CAMBRIDGE";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (!str2.contains(String.valueOf(c)))
				System.out.print(c);

		}
	}
}
