import java.util.Scanner;

public class n01188_������а� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();

		// n�� m�� �ִ������� �̸� ���� �ּҰ���� ���ϱ�
		int lcm, gcd;
		int x = 1;
		int new_m = m, new_n = n;
		while (x > 0) {
			x = new_m % new_n;
			new_m = new_n;
			new_n = x;
		}
		gcd = new_m;
		lcm = n * m / gcd;

		int share = lcm / m;
		if (lcm / n > share) {
			result += n;
		}

	}
}
