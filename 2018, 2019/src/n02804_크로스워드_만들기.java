import java.util.Scanner;

public class n02804_크로스워드_만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		int a_index = -1, b_index = -1;
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			b_index = b.indexOf(ch);
			if (b_index >= 0) {
				a_index = i;
				break;
			}
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < b.length(); i++) {
			if (i == b_index) {
				buf.append(a);
			} else {
				for (int j = 0; j < a.length(); j++) {
					if (j == a_index)
						buf.append(b.charAt(i));
					else
						buf.append(".");
				}
			}
			buf.append("\n");
		}
		System.out.println(buf.toString());

	}
}
