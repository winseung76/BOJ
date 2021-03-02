import java.util.Scanner;

public class n10797_10∫Œ¡¶ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (sc.nextInt() == N)
				count++;
		}
		System.out.println(count);
	}
}
