import java.util.Scanner;

public class n02965_캥거루_세마리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int count = 0;
		while (true) {
			if (b - a <= c - b) {
				a = b;
				b = b + 1;
			} else if (b - a > c - b) {
				c = b;
				b = b - 1;
			}
			if (a < b && b < c)
				count++;
			else
				break;
		}
		System.out.println(count);
	}
}
