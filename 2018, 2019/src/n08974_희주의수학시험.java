import java.util.Scanner;

public class n08974_희주의수학시험 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int n = 1;

		while (true) {
			if (a == 1 || a < n * (n - 1) / 2 + 1) {
				n--;
				break;
			}
			n++;
		}
		int sum = 0;
		for (int i = a; i <= b; i++) {
			if (i < (n + 1) * n / 2 + 1) {
				sum += n;
			} else {
				n++;
				sum += n;
			}
		}
		System.out.println(sum);
	}
}
