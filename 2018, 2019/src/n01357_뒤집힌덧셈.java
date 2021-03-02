import java.util.Scanner;

public class n01357_µÚÁýÈùµ¡¼À {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int Y = sc.nextInt();

		System.out.println(Rev(Rev(X) + Rev(Y)));

	}

	public static int Rev(int n) {

		String str_n = String.valueOf(n);
		StringBuffer buf = new StringBuffer();

		for (int i = str_n.length() - 1; i >= 0; i--) {
			char ch = str_n.charAt(i);

			buf.append(ch);
		}
		return Integer.parseInt(buf.toString());
	}
}
