import java.util.Arrays;
import java.util.Scanner;

public class n05576_콘테스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr;
		for (int i = 0; i < 2; i++) {
			arr = new int[10];
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print(arr[9] + arr[8] + arr[7] + " ");
		}

	}
}
