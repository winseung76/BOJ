import java.util.Scanner;

public class n09095_2_1_2_3_¥ı«œ±‚ {
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			arr = new int[x + 1];

			for (int j = 1; j <= x; j++)
				arr[j] = -1;

			System.out.println(sumWith123(x));
		}

	}

	public static int sumWith123(int n) {

		if (n == 1) {
			arr[1] = 1;
			return arr[1];
		}

		if (n == 2) {
			arr[2] = 2;
			return arr[2];
		}

		if (n == 3) {
			arr[3] = 4;
			return arr[3];
		}

		int result = 0;

		if (arr[n] != -1)
			return arr[n];

		else {
			result = sumWith123(n - 1) + sumWith123(n - 2) + sumWith123(n - 3);
			arr[n] = result;
			return arr[n];
		}

	}
}
