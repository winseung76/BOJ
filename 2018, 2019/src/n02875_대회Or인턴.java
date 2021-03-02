import java.util.Scanner;

public class n02875_대회Or인턴 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;

		while (true) {
			n -= 2;
			m -= 1;
			if (n + m >= k && n >= 0 && m >= 0)
				count++;
			else
				break;

		}
		System.out.println(count);
	}
}
