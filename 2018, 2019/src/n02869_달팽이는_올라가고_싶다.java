import java.util.Scanner;

public class n02869_달팽이는_올라가고_싶다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		V = V - A;
		int count = 1;
		while (V > 0) {
			V = V - (A - B);
			count++;
		}
		System.out.println(count);
	}
}
