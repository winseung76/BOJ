import java.util.Scanner;

public class n02847_게임을_만든_동준이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= arr[i + 1]) {
				int dif = arr[i] - (arr[i + 1] - 1);
				result += dif;
				arr[i] = arr[i + 1] - 1;
			}
		}
		System.out.println(result);
	}
}
