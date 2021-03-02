import java.util.Scanner;

public class n09506_약수들의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, sum = 0;
		StringBuffer buf;
		while ((n = sc.nextInt()) != -1) {
			buf = new StringBuffer();
			sum = 0;

			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					buf.append(i + " + ");
					sum += i;
				}
			}
			if (sum == n) {
				buf.replace(buf.length() - 3, buf.length(), "");
				System.out.println(n + " = " + buf.toString());
			} else
				System.out.println(n + " is NOT perfect.");
		}
	}
}
