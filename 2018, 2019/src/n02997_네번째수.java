import java.util.Arrays;
import java.util.Scanner;

public class n02997_네번째수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];

		for (int i = 0; i < 3; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);

		if (2 * arr[1] == arr[0] + arr[2])
			System.out.println(arr[2] + arr[2] - arr[1]);
		else if (arr[2] - arr[1] == 2 * (arr[1] - arr[0])) {
			int d = arr[1] - arr[0];
			System.out.println(arr[1] + d);
		} else if (2 * (arr[2] - arr[1]) == arr[1] - arr[0]) {
			int d = arr[2] - arr[1];
			System.out.println(arr[0] + d);
		}
	}
}
