import java.util.Scanner;

public class n10707_수도요금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();
		int price_a = P * A;
		int price_b;

		if (C >= P)
			price_b = B;
		else {
			price_b = B + D * (P - C);
		}
		System.out.println(Math.min(price_a, price_b));

	}
}
