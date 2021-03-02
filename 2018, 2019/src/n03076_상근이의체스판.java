import java.util.Scanner;

public class n03076_상근이의체스판 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < r * a; i++) {
			for (int j = 0; j < c * b; j++) {
				if ((i / a) % 2 == 0 && (j / b) % 2 == 0 || (i / a) % 2 != 0 && (j / b) % 2 != 0)
					buf.append("X");
				else
					buf.append(".");
			}
			buf.append("\n");
		}
		System.out.println(buf.toString());

	}
}
