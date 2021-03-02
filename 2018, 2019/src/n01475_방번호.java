import java.util.Arrays;
import java.util.Scanner;

public class n01475_¹æ¹øÈ£ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		String str = sc.next();
		int n = Integer.parseInt(str);

		for (int i = 0; i < 10; i++) {
			arr[i] = 0;
		}
		for (int i = 0; i < str.length(); i++) {
			int index = n % 10;
			if (index == 6 && arr[index] != 0 && arr[9] < arr[index])
				arr[9]++;
			else if (index == 9 && arr[index] != 0 && arr[6] < arr[index])
				arr[6]++;
			else
				arr[index]++;
			n = n / 10;
		}
		Arrays.sort(arr);
		System.out.println(arr[9]);

	}
}
