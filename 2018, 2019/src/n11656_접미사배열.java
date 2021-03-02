import java.util.Arrays;
import java.util.Scanner;

public class n11656_접미사배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int size = str.length();
		String[] arr = new String[size];

		for (int i = 0; i < size; i++) {
			arr[i] = str.substring(i);
		}
		Arrays.sort(arr);

		for (int i = 0; i < size; i++)
			System.out.println(arr[i]);

	}
}
