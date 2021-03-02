import java.util.Scanner;

public class n11006_남욱이의닭장 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.println((2 * M - N) + " " + (N - M));
		}

	}
}
