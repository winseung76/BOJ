import java.util.Arrays;
import java.util.Scanner;

public class n05618_°ø¾à¼ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i = 1; i <= arr[0]; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] % i == 0)
					count++;
			}
			if (count == n)
				System.out.println(i);
		}

	}
}
