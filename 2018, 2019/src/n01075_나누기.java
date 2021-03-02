import java.util.Scanner;

public class n01075_³ª´©±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int F = sc.nextInt();
		String str_n = String.valueOf(N);
		String s = str_n.substring(0, str_n.length() - 2);

		for (int i = 0; i < 100; i++) {
			String tmp = s + String.format("%02d", i);
			int tmp_n = Integer.parseInt(tmp);

			if (tmp_n % F == 0) {
				System.out.println(String.format("%02d", i));
				break;
			}
		}

	}
}
