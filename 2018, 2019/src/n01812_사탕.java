import java.util.Scanner;

public class n01812_ªÁ≈¡ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int i = 0;
		while (true) {
			ans[0] = i;
			for (int j = 1; j < N; j++) {
				ans[j] = arr[j - 1] - ans[j - 1];
			}
			if (ans[0] + ans[N - 1] == arr[N - 1])
				break;
			i++;
		}
		for (i = 0; i < N; i++) {
			System.out.println(ans[i]);
		}
	}
}
