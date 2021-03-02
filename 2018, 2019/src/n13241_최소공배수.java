import java.util.Scanner;

public class n13241_최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long tmp_a = sc.nextLong();
		long tmp_b = sc.nextLong();

		long a = Math.max(tmp_a, tmp_b);
		long b = Math.min(tmp_a, tmp_b);

		long r = 1;

		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		long lcm = (tmp_a * tmp_b) / a;
		System.out.println(lcm);

	}
}
