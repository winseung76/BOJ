import java.util.Scanner;

public class n01476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt() % 15;
		int S = sc.nextInt() % 28;
		int M = sc.nextInt() % 19;
		int n = 1;
		while (true) {
			if (n % 15 == E && n % 28 == S && n % 19 == M) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}
}
