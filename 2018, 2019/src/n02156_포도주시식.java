import java.util.Scanner;

public class n02156_포도주시식 {
	private static int[] max1;
	private static int[] max2;
	private static int[] max3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		max1 = new int[n];
		max2 = new int[n];
		max3 = new int[n];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();

			if (i == 0) {
				max1[i] = x;
				max2[i] = x;
				max3[i] = x;
			} else if (i == 1) {
				max1[i] = max1[i - 1] + x;
				max2[i] = x;
				max3[i] = x;
			} else if (i == 2) {
				max1[i] = max2[i - 1] + x;
				max2[i] = max1[i - 2] + x;
				max3[i] = x;
			} else {
				max1[i] = Math.max(max2[i - 1], max3[i - 1]) + x;
				max2[i] = Math.max(max1[i - 2], Math.max(max2[i - 2], max3[i - 2])) + x;
				max3[i] = Math.max(max1[i - 3], Math.max(max2[i - 3], max3[i - 3])) + x;
			}
		}
		int result1 = Math.max(max1[n - 1], max2[n - 1]);
		int result2 = 0;
		if (n > 1)
			result2 = Math.max(max1[n - 2], max2[n - 2]);
		System.out.println(Math.max(result1, result2));

	}
}
