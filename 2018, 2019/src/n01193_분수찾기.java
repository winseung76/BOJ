import java.util.Scanner;

public class n01193_분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int c, p;

		int n = 1;
		while (true) {
			if (X <= n * (n + 1) / 2) {
				X = X - (n - 1) * n / 2;

				if (n % 2 == 0)
					c = X;
				else
					c = n - X + 1;
				p = n - c + 1;
				System.out.println(c + "/" + p);
				break;
			}
			n++;
		}

	}
}
