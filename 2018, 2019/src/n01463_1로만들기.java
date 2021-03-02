import java.util.Scanner;

/* 메모이제이션 & top-down 방식 */
public class n01463_1로만들기 {
	private static int n;
	private static int[] arr;

	public static void main(String[] args) {
		n = (new Scanner(System.in)).nextInt();

		arr = new int[n + 1];
		for (int i = 0; i <= n; i++)
			arr[i] = -1;

		System.out.println(get_min(n));

	}

	public static int get_min(int n) {

		if (n == 1)
			return 0;

		if (arr[n] != -1)
			return arr[n];

		int result = get_min(n - 1) + 1;

		if (n % 3 == 0)
			result = Math.min(result, get_min(n / 3) + 1);
		else if (n % 2 == 0)
			result = Math.min(result, get_min(n / 2) + 1);

		arr[n] = result;

		return arr[n];
	}
}
