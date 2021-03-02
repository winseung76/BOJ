import java.util.Scanner;

public class n0925_BABBA {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[] a = new int[k + 1];
		int[] b = new int[k + 1];

		for (int i = 0; i <= k; i++) {
			if (i == 0) {
				a[i] = 1;
				b[i] = 0;
			} else if (i == 1) {
				a[i] = 0;
				b[i] = 1;
			} else {
				a[i] = a[i - 1] + a[i - 2];
				b[i] = b[i - 1] + b[i - 2];
			}
		}
		System.out.println(a[k] + " " + b[k]);

	}
}
