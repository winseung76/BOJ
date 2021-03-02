import java.util.Scanner;

/* top-down방식(재귀호출) + 메모이제이션 방법 */
/* 피보나치에서는 46번째부터는 숫자가 커져서 int형을 초과하게 된다. -> long을 사용해야함 */
public class n02193_이친수 {
	private static long[] zero, one;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextInt();
		zero = new long[(int) (n + 1)];
		one = new long[(int) (n + 1)];

		for (int i = 1; i <= n; i++) {
			zero[i] = -1;
			one[i] = -1;
		}
		long result = get_count(n - 1, 0);

		System.out.println(result);
	}

	public static long get_count(long n, long bin) {
		if (n == 1 || n == 0) {
			zero[1] = 1;
			one[1] = 1;
			return 1;
		}

		if (bin == 0) {
			if (zero[(int) n] == -1)
				zero[(int) n] = get_count(n - 1, 0) + get_count(n - 1, 1);
			return zero[(int) n];
		} else {
			if (one[(int) n] == -1)
				one[(int) n] = get_count(n - 1, 0);
			return one[(int) n];
		}
	}
}
