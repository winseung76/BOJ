import java.util.Scanner;

public class n02798_∫Ì∑¢¿Ë {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int data = arr[i] + arr[j] + arr[k];
					if (data <= m && max < data)
						max = data;
				}
			}
		}
		System.out.println(max);

	}
}
