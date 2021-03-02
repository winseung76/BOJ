import java.util.Scanner;

public class n09546_3000¹ø¹ö½º {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int num = 0;
			for (int j = 0; j < k; j++) {
				int n = 2 * num + 1;
				num = n;
			}
			System.out.println(num);
		}

	}
}
