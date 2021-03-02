import java.util.Scanner;

public class n05586_JOI¿ÍIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		int joi_count = 0;
		int ioi_count = 0;
		int index;
		int i = 0;
		while (i < str.length()) {
			index = str.indexOf("JOI", i);
			if (index != -1) {
				joi_count++;
				i = index + 2;
			} else
				break;

		}
		i = 0;
		while (i < str.length()) {
			index = str.indexOf("IOI", i);
			if (index != -1) {
				ioi_count++;
				i = index + 2;
			} else
				break;

		}
		System.out.println(joi_count);
		System.out.println(ioi_count);

	}
}
