import java.util.Scanner;

public class n01022_소용돌이_예쁘게_출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer buf = new StringBuffer();
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		long[][] arr = new long[r2 - r1 + 1][c2 - c1 + 1];
		long max = Math.max(Math.max(Math.abs(r1), Math.abs(r2)), Math.max(Math.abs(c1), Math.abs(c2)));
		int i = 0;
		/*
		 * max = (2 * max + 1) * (2 * max + 1); while (max > 0) { max = max - (int) (9 *
		 * Math.pow(10, i)); i++; }
		 */
		max = 0;
		int length = i;
		long res = 0;
		int r = 0, c = 0;
		for (int x = r1; x <= r2; x++) {
			int n = Math.abs(x);
			c = 0;
			for (int y = c1; y <= c2; y++) {
				int m = Math.abs(y);
				if (m <= n) {
					if (x < 0)
						res = (long) (Math.pow((2 * n + 1), 2) - 4 * n - Math.abs(x - y));
					else if (x >= 0)
						res = (long) (Math.pow((2 * n + 1), 2) - 2 * n + (x + y));

				} else {
					m = m + 1;
					if (y < 0)
						res = (long) (4 * Math.pow(m, 2) - 7 * m + 4 + x);
					else if (y >= 0)
						res = (long) (4 * Math.pow(m, 2) - 11 * m + 8 - x);

				}
				arr[r][c] = res;
				c++;
				max = Math.max(max, res);
			}
			r++;
		}
		length = String.valueOf(max).length();

		for (i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < length - String.valueOf(arr[i][j]).length(); k++) {
					System.out.print(" ");
				}
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();

		}
	}
}
