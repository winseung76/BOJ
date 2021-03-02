import java.util.Arrays;
import java.util.Scanner;

public class n11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		int sum = 0, result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			result += sum;
		}
		System.out.println(result);

	}
}
