import java.util.Scanner;

public class n02947_나무조각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5 - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					for (int k = 0; k < 5; k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.println();
				}
			}
		}

	}
}
