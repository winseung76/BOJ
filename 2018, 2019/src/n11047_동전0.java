import java.util.Scanner;

public class n11047_µ¿Àü0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int price = sc.nextInt();
		int[] value = new int[n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
		}
		int index = n - 1;
		while (price > 0) {

			count += price / value[index];
			price = price % value[index];
			index--;
		}
		System.out.println(count);
	}
}
