import java.util.Scanner;

public class n02783_»ï°¢±è¹ä {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		double min = 1000.0 / y * x;
		int n = sc.nextInt();
		int[] won = new int[n];
		int[] gram = new int[n];

		for (int i = 0; i < n; i++) {
			won[i] = sc.nextInt();
			gram[i] = sc.nextInt();
			double price = 1000.0 / gram[i] * won[i];
			if (price < min)
				min = price;
		}
		System.out.println(String.format("%.2f", min));
	}
}
