import java.util.Scanner;

public class n01789_수들의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long S = sc.nextLong();
		long n = 1;

		while (S >= n) {
			S = S - n;
			n++;
		}
		System.out.println(n - 1);
	}
}
