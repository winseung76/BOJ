import java.util.Scanner;

public class n01964_오각형_오각형_오각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int n = 0; n < N; n++) {
			if (n == 0)
				arr[n] = 5;
			else {
				arr[n] = arr[n - 1] + 4 + 3 * n;
			}
			arr[n] = arr[n] % 45678;
		}
		System.out.println(arr[N - 1]);
	}
}
