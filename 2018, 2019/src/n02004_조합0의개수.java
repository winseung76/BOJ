import java.util.Scanner;

public class n02004_조합0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long m = sc.nextLong();
		int five = five_count(n) - (five_count(n - m) + five_count(m));
		int two = two_count(n) - (two_count(n - m) + two_count(m));

		int count = Math.min(five, two);
		System.out.println(count);
	}

	public static int five_count(long n) {
		int count = 0;
		long i = 5;

		while (i <= n) {
			count += n / i;
			i *= 5;
		}
		return count;
	}

	public static int two_count(long n) {
		int count = 0;
		long i = 2;

		while (i <= n) {
			count += n / i;
			i *= 2;
		}
		return count;
	}
}
