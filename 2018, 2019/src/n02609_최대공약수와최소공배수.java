import java.util.Scanner;

public class n02609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int tmp_a = a;
		int tmp_b = b;
		a = Math.max(tmp_a, tmp_b);
		b = Math.min(tmp_a, tmp_b);

		int r = 1;

		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		int gcd = a;
		long lcm = (tmp_a * tmp_b) / gcd;

		System.out.println(gcd + "\n" + lcm);

	}
}
