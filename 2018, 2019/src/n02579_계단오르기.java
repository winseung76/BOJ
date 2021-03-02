import java.util.Scanner;

public class n02579_계단오르기 {
	private static int[] vof, arr1, arr2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 계단의 개수, 층 수

		vof = new int[n];
		arr1 = new int[n];
		arr2 = new int[n];

		for (int i = 0; i < n; i++) {
			vof[i] = sc.nextInt();

			if (i == 0) {
				arr1[i] = vof[i];
				arr2[i] = vof[i];
			} else if (i == 1) {
				arr1[i] = arr1[i - 1] + vof[i];
				arr2[i] = vof[i];
			} else {
				arr1[i] = arr2[i - 1] + vof[i];
				arr2[i] = Math.max(arr1[i - 2], arr2[i - 2]) + vof[i];
			}
		}
		System.out.println(Math.max(arr1[n - 1], arr2[n - 1]));

	}
}
