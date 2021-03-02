import java.util.Scanner;

public class n01188_음식평론가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();

		// n과 m의 최대공약수와 이를 통해 최소공배수 구하기
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
