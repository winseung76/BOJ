import java.util.Arrays;
import java.util.Scanner;

public class n02217_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 1; i <= n; i++) {
			arr[n - i] = arr[n - i] * i;
		}
		Arrays.sort(arr);
		System.out.println(arr[n - 1]);

	}
}
