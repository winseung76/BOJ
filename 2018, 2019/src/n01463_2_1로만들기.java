import java.util.Scanner;

/* 메모이제이션 & down-top 방식 */
public class n01463_2_1로만들기 {
	private static int[] arr;

	public static void main(String[] args) {

		int n = new Scanner(System.in).nextInt();
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1)
				arr[i] = 0;

			else {
				if (i % 3 == 0)
					arr[i] = Math.min(arr[i - 1], arr[i / 3]) + 1;
				else if (i % 2 == 0)
					arr[i] = Math.min(arr[i - 1], arr[i / 2]) + 1;
				else
					arr[i] = arr[i - 1] + 1;
			}
		}
		System.out.println(arr[n]);

	}
}
