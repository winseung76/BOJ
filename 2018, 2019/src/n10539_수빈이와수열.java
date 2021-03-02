import java.util.Scanner;

public class n10539_수빈이와수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			if (i == 0)
				b[i] = a[i];
			else {
				int sum = 0;
				for (int j = 0; j < i; j++)
					sum += b[j];
				b[i] = a[i] * (i + 1) - sum;

			}
			System.out.print(b[i] + " ");
		}

	}
}
